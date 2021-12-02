package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.MenuDTO;

public class MenuDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public MenuDAO() {
		conn = DBConnection.getConnection();
	}
	//메뉴 넘버 중복인지를 체크하는 메소드
	public boolean check_menu_num(int menu_num) {
		String sql = "SELECT * FROM MENU_DB WHERE MENU_NUM = ?";
		boolean result = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, menu_num);
			rs = ps.executeQuery();
			
			result = !rs.next();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return result;
	}
	//메뉴 DB에 추가하는 메소드
	public boolean add(MenuDTO newMenu) {
		int result = 0;
		String sql = "INSERT INTO MENU_DB (MENU_NAME, MENU_PRICE, MENU_NUM, MENU_CATEGORY, MENU_ID, MENU_NEW)"
				+ "VALUES(?,?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newMenu.menu_name);
			ps.setInt(2, newMenu.menu_price);
			ps.setInt(3, newMenu.menu_num);
			ps.setString(4, newMenu.menu_category);
			ps.setString(5, newMenu.menu_id);
			ps.setInt(6, newMenu.menu_new);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result == 1;
	}
}
