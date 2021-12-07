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
		newAdmin.adm_pw = encrypt(newAdmin.adm_pw);
		int result = 0;
		String sql = "INSERT INTO UMS_USER VALUES(?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, newAdmin.adm_id);
			ps.setString(2, newAdmin.adm_pw);
			ps.setString(3, newAdmin.adm_name);
			ps.setString(4, newAdmin.adm_number);
			ps.setString(5, newAdmin.adm_phonenum);

			result = ps.executeUpdate();
		} catch (SQLException e) {
		}
		return result == 1;
	}
	
	public String myStore(String admin_store_id) {
		String sql = "SELECT STR_NAME FROM STORE_DB WHERE STR_ID = ?";
		String result = "";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, admin_store_id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = rs.getString("STR_NAME");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	public boolean checkId(String adm_id) {
		String sql = "SELECT * FROM UMS_USER WHERE adm_id=?";
		boolean result = false;
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, adm_id);
			rs = ps.executeQuery();

			result = !rs.next();

		} catch (SQLException e) {
		}
		return result;

	}

	public boolean login(String adm_id, String adm_pw) {
		String sql = "SELECT * FROM UMS_USER WHERE adm_id=? AND adm_pw=?";
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, adm_id);
			ps.setString(1, encrypt(adm_pw));

			rs = ps.executeQuery();
			if (rs.next()) {
				AdminDTO loginAdmin = new AdminDTO(
						rs.getString("ADM_ID"), 
						decrypt(rs.getString("ADM_PW")),
						rs.getString("ADM_NAME"), 
						rs.getString("ADM_NUMBER"), 
						rs.getString("ADM_PHONENUM")
				);
				Session.put("loginAdmin", loginAdmin);

				return true;
			}
		} catch (SQLException e) {
		}
		return false;
	}

	public String encrypt(String adm_pw) {
		String result = "";
		for (int i = 0; i < adm_pw.length(); i++) {
			result += (char) (adm_pw.charAt(i) + 4);
		}
		return result;
	}

	public String decrypt(String en_pw) {
		String result = "";
		for (int i = 0; i < en_pw.length(); i++) {
			result += (char) (en_pw.charAt(i) - 4);
		}
		return result;
	}
	
	public boolean checkStore(String admin_store_id) {
		String sql= "SELECT * FROM ADMIN_DB WHERE STR_ID = ?";
		boolean result = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, admin_store_id);
			rs = ps.executeQuery();
			
			result = !rs.next();
		} catch (SQLException e) {
			
		}
		return result;
	}
	
	public boolean change_Store(String admin_store_id, String admin_id) {
		String sql = "UPDATE ADMIN_DB SET STR_ID = ? WHERE ADM_ID = ?";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, admin_store_id);
			ps.setString(2, admin_id);
			result = ps.executeUpdate();
			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return result == 1;
	}

	public boolean check_pw(String admin_pw) {
		
		
		String sql = "SELECT ADMIN_PW FROM ADMIN_DB WHERE ADM_PW = ?";	
		boolean result = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, encrypt(admin_pw));
			rs = ps.executeQuery();
			rs.getString("ADM_PW");
			
			if(encrypt(admin_pw).equals(rs.getString("ADM_PW"))) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;				
	}

	public boolean change_pw(String new_pw, String old_pw) {
		String sql = "UPDATE ADMIN_DB SET ADM_PW = ? WHERE ADM_PW = ?";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, encrypt(new_pw));
			ps.setString(2, encrypt(old_pw));
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result == 1;
	}

	public boolean change_phone(String new_phone, String admin_pw) {
		String sql = "UPDATE ADMIN_DB SET ADM_PHONENUM = ? WHERE ADM_PW = ?";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, new_phone);
			ps.setString(2, encrypt(admin_pw));
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result == 1;
	}
}
