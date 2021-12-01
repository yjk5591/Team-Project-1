package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAO {
	Connection conn;
	PreparedStatement ps;
	
	public CustomerDAO() {
		conn = DBConnection.getConnection();
	}

	public boolean usePoint(String cus_id, int usepoint) {
		String pointsql = "SELECT CUS_POINT FROM CUS_DB WHERE CUS_ID=?";
		String usesql = "UPDATE CUS_POINT FROM CUS_DB WHERE CUS_ID=?";
		int result = 0;
		
		try {
			ps = conn.prepareStatement(pointsql);
			ps.setString(1, cus_id);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
		}
		return result == 1;
	}
}
