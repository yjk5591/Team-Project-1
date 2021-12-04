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
					
					//���� ��� �� ���� �� ������ �Ѿ� ������Ʈ
					int total_price = getTotal(cus_id);
					total_price = total_price - (usecoupons * 1000);
					updateTotal(cus_id, total_price);
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
					
					//����Ʈ ��� �� ���� �� ������ �Ѿ� ������Ʈ
					int total_price = getTotal(cus_id);
					total_price = total_price - usepoint;
					updateTotal(cus_id, total_price);
				} catch (SQLException e) {
				}
				//������Ʈ �����ߴٸ� true
				return result == 1;
			}
		}
	}

	//����Ʈ ����
	public void establishPoint(String cus_id) {
		int recent_point = getPoint(cus_id);
		int total = getTotal(cus_id);
		
		recent_point = (int) (recent_point + (total * 0.05));
	
		updatePoint(cus_id, recent_point);
	}

	public String selectLocation(String cus_id, int choice) {
		String location;
		
		if(choice == 1) {
			String sql = "SELECT CUS_ADDR FROM CUS_DB WHERE CUD_ID=?";
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, cus_id);
				
				rs = ps.executeQuery();
				
				location = rs.getString("CUS_ADDR");

				return location;
			} catch (SQLException e) {
			}
		}
		return "����� ���� ���� / ������ �ٽ� �õ����ּ���.";
	}
	
	public String selectNewLocation(String cus_id, int choice, String newlocation) {
		if(choice == 2) {
			String sql = "UPDATE CUS_DB SET CUD_ADDR2=? WHERE CUS_ID=?";
			int result = 0;
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, newlocation);
				ps.setString(2, cus_id);
				
				result = ps.executeUpdate();
				
				return newlocation;
			} catch (SQLException e) {
			}
		}
		return "����� ���� ���� / ������ �ٽ� �õ����ּ���.";
	}
	
	public int getTotal(String cus_id) {
		String sql = "SELECT ORDER_PRICE FROM ORDER_VIEW WHERE CUS_ID=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cus_id);
			
			rs = ps.executeQuery();
			
			 int total = rs.getInt("ORDER_PRICE");
			 
			 return total;
		} catch (SQLException e) {
		}
		return (Integer) null;
	}

	public int updateTotal(String cus_id, int total) {
		String sql = "UPDATE ORDER_VIEW SET ORDER_PRICE=? WHERE CUS_ID=?";
		
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, total);
			ps.setString(2, cus_id);
			
			result = ps.executeUpdate();
			
			return total;
		} catch (SQLException e) {
		}
		return (Integer) null;
	}
}
