package menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu_update {
	public Menu_update() {
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
			String sql = "UPDATE MENU_DB SET MENU_NAME=?, MENU_PRICE, MENU_CATEGORY=?";
			ps = conn.prepareStatement(sql);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("������ �޴��� ���̵� �����ϼ��� : ");
			String menu_id = sc.next();
			System.out.println(menu_id + "������ �׸��� �����ϼ���.\n1. �޴���\n2. �޴�����\n3. �޴� ī�װ�");
			int choice = sc.nextInt();

			switch(choice) {
			case 1 :
				System.out.println("������ �޴����� �Է��ϼ��� : ");
				String menu_name = sc.next();
				sql = "UPDATE MENU_DB SET MENU_NAME=? WHERE MENU_ID=?";
				ps.setString(1, menu_name);
				break;
				
			case 2 :
				System.out.println("������ ������ �Է��ϼ��� : ");
				int menu_price = sc.nextInt();
				sql = "UPDATE MENU_DB SET MENU_PRICE=? WHERE MENU_ID=?";
				ps.setInt(2, menu_price);
				break;
				
			case 3 :
				System.out.println("������ ī�װ��� �Է��ϼ��� : ");
				String menu_category = sc.next();
				sql = "UPDATE MENU_DB SET MENU_CATEGORY=? WHERE MENU_ID=?";
				ps.setString(3, menu_category);
				break;
			}
			
			int n = ps.executeUpdate();
			if(n == 1) {
				System.out.println(menu_id + "��ǰ ���� ������ �����Ͽ����ϴ�!");
			} else {
				System.out.println("��ǰ ���� ������ �����Ͽ����ϴ�...");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
	            if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} 
}