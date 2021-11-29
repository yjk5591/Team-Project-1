package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAO {
	Connection conn;
	PreparedStatement ps;
	
	public ProductDAO() {
		conn = DBConnection.getConnection();
	}
	
	public boolean modifyAmount(String menu_id, int col, String newData) {
		// 1: ORDER_AMOUNT
		String[] cols = {"","ORDER_AMOUNT"};
		String sql = "UPDATE ORDER_DETAIL SET "
				+ cols[col] + " = ? WHERE MENU_ID=?";
		
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newData);
			ps.setString(2, menu_id);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
		}
		return result == 1;
	}
}
