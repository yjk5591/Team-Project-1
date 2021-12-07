package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public StoreDAO() {
		conn = DBConnection.getConnection();
	}

	public String checkStore(String store_addr) {
		String sql = "SELECT STORE_ADDR FROM STORE_DB WHERE=?";
		
		String result = null;
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, store_addr);
			
			rs = ps.executeQuery();
			
			result = rs.getString("STORE_ADDR");
		} catch (SQLException e) {
		}
		return result;
	}
}