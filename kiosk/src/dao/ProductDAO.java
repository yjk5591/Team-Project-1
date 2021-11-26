package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductDAO {
	Connection conn;
	PreparedStatement ps;
	
	public ProductDAO() {
		conn = DBConnection.getConnection();
	}
	
	public void update(String menuid, int col, int newData) {
		String[] cols = {""
		
		String sql = "UPDATE ORDER_DETAIL SET ORDER_AMOUNT=?";
		
		
		ps.setString(1, newData);
	}
}
