package dao;

import java.sql.Connection;

public class ProductDAO {
	Connection conn;
	
	public ProductDAO() {
		conn = DBConnection.getConnection();
	}
	
	public void getList(String MENU_ID) {
		String sql = "SELECT * FROM MENU_DB";
	}
}
