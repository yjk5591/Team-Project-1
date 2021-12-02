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
	
	//���� ���� ������ �ҷ����� �޼��� --> updateCoupons�� ����
	public int getCoupons(String cus_id) {
		//���� ���� ������ �ҷ����� sql��
		String sql = "SELECT CUS_COUPONS FROM CUS_DB WHERE CUS_ID=?";
		
		//���� ������ couponamount��� �̸����� ����
		ResultSet couponamount = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cus_id);
			
			//���� ������ �ҷ��ͼ� ������
			couponamount = ps.executeQuery();
			//couponamount�� ù ��° �ε��� ���� �ҷ���
			//--> �ε����� �ϳ��� �ٷ� ���� ������ �ҷ����� �ȴ�
			return couponamount.getInt(1);
		} catch (SQLException e) {
		}
		
		//?? ���� 0�� �ϴ°� �´°ǰ�?
		return 0;
	}

	//������ ������ CUS_DB�� ������Ʈ �ϴ� �޼���
	public boolean updateCoupons(String cus_id, int usecoupons) {
		//getCoupons �޼��带 ����ؼ� ���� ���� ������ coupons ������ ����
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
			//������Ʈ �����ߴٸ� true
			return result == 1;
		}
	}

	//����ϰ� ���� ����Ʈ�� �����̺z �ϴ� �޼���
	public boolean updatePoint(String cus_id, int usepoint) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
