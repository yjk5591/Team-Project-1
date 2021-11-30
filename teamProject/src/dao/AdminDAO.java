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
}
