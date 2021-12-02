package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public CustomerDAO() {
		conn = DBConnection.getConnection();
	}
	
	//���� ���� ������ �ҷ����� �޼��� --> updateCoupons�� ����
	public int getCoupons(String cus_id) {
		//���� ���� ������ �ҷ����� sql��
		String sql = "SELECT CUS_COUPONS FROM CUS_DB WHERE CUS_ID=?";
		
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cus_id);
			
			//���� ������ �ҷ��ͼ� ������
			rs = ps.executeQuery();
			
			//rs�� CUS_COUPONS �÷��� ���� �ҷ��� result�� �������ش�.
			result = rs.getInt("CUS_COUPONS");
		} catch (SQLException e) {
		}
		//���� ���� ������ �������ش�.
		return result;		
	}

	//������ ������ CUS_DB�� ������Ʈ �ϴ� �޼���
	public boolean updateCoupons(String cus_id, int usecoupons) {
		//getCoupons �޼��带 ����ؼ� ���� ���� ������ coupons ������ ����
		int coupons = getCoupons(cus_id);
		
		//������ ������ 0 ���ϸ� ����� �� �ִ� ������ ������ �����Ƿ�
		//false�� �������ش�.
		if(coupons <= 0) {
			return false;
		//������ ������ 0���� ũ�ٸ� ����� �� �ִ� ������ ������ �ִٴ� ��
		}else {
			//���� ���� ���� �������� ����Ϸ��� ���� ������ ���ٸ� false ����
			if(coupons < usecoupons) {
				return false;
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
	}
	
	//���� ���� ����Ʈ�� �ҷ����� �޼��� --> updatePoint�� ����
	public int getPoint(String cus_id) {
		//���� ���� ����Ʈ�� �ҷ����� sql��
		String sql = "SELECT CUS_POINT FROM CUS_DB WHERE CUS_ID=?";
		
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cus_id);
			
			//���� ����Ʈ�� �ҷ��ͼ� ������
			rs = ps.executeQuery();
			
			//rs�� CUS_POINT �÷��� ���� �ҷ��� result�� �������ش�.
			result = rs.getInt("CUS_POINT");
		} catch (SQLException e) {
		}
		//���� ����Ʈ�� �������ش�.
		return result;		
	}

	//����ϰ� ���� ����Ʈ�� �����̺z �ϴ� �޼���
	public boolean updatePoint(String cus_id, int usepoint) {
		//getPoint �޼��带 ����ؼ� ���� ���� ����Ʈ�� point ������ ����
		int point = getCoupons(cus_id);
		
		//���� ����Ʈ ���� 0 ���ϸ� ����� �� �ִ� ����Ʈ�� �����Ƿ�
		//false�� �������ش�.
		if(point <= 0) {
			return false;
		//����Ʈ�� 0���� ���ٸ� ����� �� �ִ� ����Ʈ�� �ִٴ� ��
		}else {
			//���� ���� ����Ʈ���� ����Ϸ��� ����Ʈ�� ���ٸ� false ����
			if(point < usepoint) {
				return false;
			}else {
				//point�� ����� ����Ʈ ���� �� ���� ����
				point = point - usepoint;
				
				//point ���� CUS_POINT�� ������Ʈ
				String sql = "UPDATE CUS_DB SET CUS_POINT=? WHERE CUS_ID=?";
				
				int result = 0;
				try {
					ps = conn.prepareStatement(sql);
					//���� ���� �÷� ���� point �־���
					ps.setLong(1, point);
					ps.setString(2, cus_id);
					
					//������Ʈ �����ϸ� 1 ����
					result = ps.executeUpdate();
				} catch (SQLException e) {
				}
				//������Ʈ �����ߴٸ� true
				return result == 1;
			}
		}
	}

	
}
