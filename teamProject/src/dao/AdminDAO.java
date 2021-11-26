package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.AdminDTO;

public class AdminDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public AdminDAO() {
		conn = DBConnection.getConnection();
	}
	

	public boolean join(AdminDTO newAdmin) {
		newAdmin.admin_pw = encrypt(newAdmin.admin_pw);
		int result=0;
		String sql = "INSERT INTO ADMIN_DB VALUES(?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, newAdmin.admin_num);
			ps.setString(2, newAdmin.admin_id);
			ps.setString(3, newAdmin.admin_pw);
			ps.setString(4, newAdmin.admin_name);
			ps.setString(5, newAdmin.admin_phone);
			ps.setString(6, newAdmin.admin_store_id);
			
			result = ps.executeUpdate();
		}catch(SQLException e) {
			
		}
		return result == 1;
	}

	public boolean checkId(String admin_id) {
		String sql= "SELECT * FROM ADMIN_DB WHERE ADMIN_ID = ?";
		boolean result = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(2, admin_id);
			rs = ps.executeQuery();
			
			result = !rs.next();
		} catch (SQLException e) {
			
		}
		return result;
	}
	public boolean checkStore(String admin_store_id) {
		String sql= "SELECT * FROM ADMIN_DB WHERE STORE_ID = ?";
		boolean result = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(6, admin_store_id);
			rs = ps.executeQuery();
			
			result = !rs.next();
		} catch (SQLException e) {
			
		}
		return result;
	}
	
	public String encrypt(String admin_pw) {
		String result="";
		for (int i = 0; i < admin_pw.length(); i++) {
			result += (char)(admin_pw.charAt(i)+4);
		}
		return result;
	}
	public String decrypt(String en_pw) {
		String result="";
		for (int i = 0; i < en_pw.length(); i++) {
			result += (char)(en_pw.charAt(i)-4);
		}
		return result;
	}
}
