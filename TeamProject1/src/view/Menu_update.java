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
			System.out.println("수정할 메뉴의 아이디를 선택하세요 : ");
			String menu_id = sc.next();
			System.out.println(menu_id + "수정할 항목을 선택하세요.\n1. 메뉴명\n2. 메뉴가격\n3. 메뉴 카테고리");
			int choice = sc.nextInt();

			switch(choice) {
			case 1 :
				System.out.println("수정할 메뉴명을 입력하세요 : ");
				String menu_name = sc.next();
				sql = "UPDATE MENU_DB SET MENU_NAME=? WHERE MENU_ID=?";
				ps.setString(1, menu_name);
				break;
				
			case 2 :
				System.out.println("수정할 가격을 입력하세요 : ");
				int menu_price = sc.nextInt();
				sql = "UPDATE MENU_DB SET MENU_PRICE=? WHERE MENU_ID=?";
				ps.setInt(2, menu_price);
				break;
				
			case 3 :
				System.out.println("수정할 카테고리를 입력하세요 : ");
				String menu_category = sc.next();
				sql = "UPDATE MENU_DB SET MENU_CATEGORY=? WHERE MENU_ID=?";
				ps.setString(3, menu_category);
				break;
			}
			
			int n = ps.executeUpdate();
			if(n == 1) {
				System.out.println(menu_id + "상품 정보 수정이 성공하였습니다!");
			} else {
				System.out.println("상품 정보 수정이 실패하였습니다...");
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