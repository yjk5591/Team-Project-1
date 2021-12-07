package menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import dao.MenuDAO;
import dto.MenuDTO;

public class Menu_insert {
	public Menu_insert() {
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
			String sql = "INSERT INTO MENU_DB(MENU_NAME,MENU_PRICE,MENU_NUM,MENU_CATEGORY,MENU_ID) VALUES(?,?,?,?,?)";

            Scanner sc = new Scanner(System.in);
            MenuDAO mdao = new MenuDAO();
            System.out.println("메뉴이름 : ");
            String menu_name = sc.next();
            System.out.println("메뉴가격 : ");
            int menu_price = sc.nextInt();
            System.out.println("메뉴번호: ");
            int menu_num = sc.nextInt();
            System.out.println("메뉴 카테고리  : ");
            String menu_category = sc.next();
            System.out.println("메뉴 아이디 : ");
            String menu_id = sc.next();

            ps = conn.prepareStatement(sql);
            ps.setString(1,menu_name);
            ps.setInt(2,menu_price);
            ps.setInt(3,menu_num);
            ps.setString(4,menu_category);
            ps.setString(5,menu_id);
            
            int n = ps.executeUpdate();
            if(n == 1) {
            	System.out.println(menu_name + " 추가 성공!");
            } else {
            	System.out.println("메뉴 추가 실패!");
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