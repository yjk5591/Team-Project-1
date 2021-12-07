package menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu_delete {
	public Menu_delete() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String pw = "1234";
		
		try {
			Class.forName(driver);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}	

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection(url, user, pw);
			String sql = "DELETE FORM MENU_DB WHERE MENU_ID=?";
			ps = conn.prepareStatement(sql);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("������ �޴��� ���̵� �Է��ϼ���");
			String menu_id = sc.next();
			ps.setString(1, menu_id);
			
			int n = ps.executeUpdate();
			if(n == 1) {
				System.out.println(menu_id + " �޴� ������ �����Ͽ����ϴ�!");
			} else {
				System.out.println(menu_id + " �޴� ������ �����Ͽ����ϴ�...");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}

		}
	}
}