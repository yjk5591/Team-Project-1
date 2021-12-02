package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
	Connection conn;
	PreparedStatement ps;
	
	public CustomerDAO() {
		conn = DBConnection.getConnection();
	}
	
	public int getCoupons(String cus_id) {
		String sql = "SELECT CUS_COUPONS FROM CUS_DB WHERE CUS_ID=?";
		
		ResultSet couponamount = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cus_id);
			
			couponamount = ps.executeQuery();
			return couponamount.getInt(1);
		} catch (SQLException e) {
		}
		return 0;
	}

	public boolean updateCoupons(String cus_id, int usecoupons) {
		int coupons = getCoupons(cus_id);
		
		//������ ������ 0���� ������ ����� ������ ������ �����Ƿ�
		//false�� �������ش�.
		if(coupons <= 0) {
			return false;
		//������ ������ 0���� ũ�ٸ� ����� ������ ������ �ִٴ� ��
		}else {
			//coupons�� ����� ���� ������ �� ���� ����
			coupons = coupons - usecoupons;
			
			//coupons ���� CUS_COUPONS�� ������Ʈ
			String sql = "UPDATE CUS_DB SET CUS_COUPONS=? WHERE CUS_ID=?";
			
			int result = 0;
			try {
				ps = conn.prepareStatement(sql);
				//���� ���� �÷� ���� coupons �־���
				ps.setLong(1, coupons);
				ps.setString(2, cus_id);
				
				//������Ʈ �����ϸ� 1 ����
				result = ps.executeUpdate();
			} catch (SQLException e) {
			}
			return result == 1;
		}
	}

	
}
