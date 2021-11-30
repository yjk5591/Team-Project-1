package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.CUS_DTO;

public class CUS_DAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	// UserDAO Ŭ������ ��ü�� DB�� �����ϱ� ���ؼ� �����ؼ� ����Ѵ�.
	public CUS_DAO() {
		// �����Ǿ��ٸ� ������ �ٸ� �޾Ƽ� conn�� �־��ֱ�
		conn = DBConnection.getConnection();
	}

	public boolean join(CUS_DTO newCustomer) {
		// ��ü�� ��� ��й�ȣ ��ȣȭ
		newCustomer.cusPW = encrypt(newCustomer.cusPW);
		int result = 0;
		// ������ ���ο� �����ϴ� ������ �ֱ� ������ �װ� ���ڿ� ������ ���ؼ� �ۼ��� �ָ�
		// �ʹ� �ڵ尡 ����������. ������ �� �ڸ��� ? �� �̿��ؼ�
		// sql���� �̿ϼ����� ���д�.
		String sql = "INSERT INTO UMS_USER VALUES(?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);

			// �������� sql���� �ϼ����� ���� �������̹Ƿ� ? �ڸ��� �� ������
			// �ϳ��� ������ �־�� �Ѵ�.
			ps.setString(1, newCustomer.cusID);// ù��° ����ǥ�� 'apple' ����
			ps.setString(2, newCustomer.cusID);// ..
			ps.setString(3, newCustomer.cusName);
			ps.setString(5, newCustomer.cusPhone);
			ps.setString(6, newCustomer.cusAddr);

			// INSERT, UPDATE, DELETE : executeUpdate() - ������ �� �� ����
			// SELECT : executeQuery() - �˻��� ��� ���̺�(rs)�� ����
			result = ps.executeUpdate();
		} catch (SQLException e) {
		}
		// ������ �����ߴٸ� 1���� �߰�(���̺��� ����)�Ǿ����Ƿ� 1���� result�� ����ִٸ�
		// ���� �����̶�� ��
		return result == 1;
	}

	public boolean checkId(String userid) {
//		String sql = "SELECT COUNT(*) FROM UMS_USER WHERE USERID=?";
		String sql = "SELECT * FROM UMS_USER WHERE USERID=?";
//		int result = 1;
		boolean result = false;
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, cusID);
			rs = ps.executeQuery();

//			if(rs.next()) {
//				result = rs.getInt(1);
//			}
			// USERID�� ���� ���� �˻��ϴ°��� �������� ���� ����̴�.
			// �˻��� �Ǿ��ٸ� �ߺ��Ǵ� ���̵� �̹� �����Ѵٴ� ��
			// �˻��� �ȵǾ��ٸ� rs.next()�� ȭ��ǥ�� �ű� �� ���� ������
			// rs.next()�� ����� false�� ���´�. ������ �ߺ�üũ��
			// ����Ѱ��̱� ������ �տ� !�� �̿��ؼ� ����� true�� �ٲپ��ش�.
			result = !rs.next();

		} catch (SQLException e) {
		}
//		return result == 0;
		return result;
	}

	public boolean login(String cusID, String cusPW) {
		String sql = "SELECT * FROM UMS_USER WHERE USERID=? AND USERPW=?";
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, cusID);
			// DB�� ��ȣȭ�� ��й�ȣ�� ��������Ƿ� �˻��� ������ ��ȣȭ�ؼ� �˻�
			ps.setString(2, encrypt(cusPW));

			rs = ps.executeQuery();

			if (rs.next()) {
				// rs.next()�� �ִٴ� ���� �˻� ����(�α��� ����)�̶�� ���̰�
				// �˻��� ����� ���ǿ� ������ ���־�� �Ѵ�.
				// �˻��� �࿡�� �� ���� ������ �����ͼ� ��ü�� ���� �� ����
				CUS_DTO loginUser = new CUS_DTO(rs.getString("USERID"), decrypt(rs.getString("USERPW")),
						rs.getString("USERNAME"), rs.getString("USERPHONE"), rs.getString("USERADDR"));
				// ������ ������� ��ü�� ���ǿ� ����
				Session.put("loginUser", loginUser);
				return true;
			}
		} catch (SQLException e) {
		}
		// ���� return true�� �������ٸ� ������ �α��� ����
		return false;
	}

	public String encrypt(String cusPW) {
		String result = "";
		for (int i = 0; i < cusPW.length(); i++) {
			result += (char) (cusPW.charAt(i) + 4);
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

	public boolean modifyUser(String cusID, int col, String newData) {
		// 1 : USERPW / 2 : USERPHONE / 3 : USERADDR
		String[] cols = { "", "USERPW", "USERPHONE", "USERADDR" };
		String sql = "UPDATE UMS_USER SET " + cols[col] + " = ? WHERE USERID=?";

		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newData);
			ps.setString(2, cusID);

			result = ps.executeUpdate();
		} catch (SQLException e) {
		}
		return result == 1;
	}
}
