package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerDAO {
	Connection conn;
	PreparedStatement ps;
	
	public CustomerDAO() {
		conn = DBConnection.getConnection();
	}
}
