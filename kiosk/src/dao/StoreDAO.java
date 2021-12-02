package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StoreDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public StoreDAO() {
		conn = DBConnection.getConnection();
	}
}
