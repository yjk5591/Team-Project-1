package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MenuDAO {
	Connection conn;
	PreparedStatement ps;
	
	public MenuDAO() {
		conn = DBConnection.getConnection();
	}
	
	//��ٱ��Ͽ� �ִ� �޴� ���� �����ϴ� �޼���
	//�޴� �̸��� �ߺ��� ��  �ɰ� ���Ƽ� �޴� �̸��̶� ���� ���� ���� ������ ��ƿ´�
	public boolean modifyAmount(String cus_id, String menu_name, String newData) {
		String sql = "UPDATE ORDER_DETAIL SET ORDER_AMOUNT=? WHERE MENU_NAME=? AND CUS_ID=?";
		
		//���Ѱ� ������ 0 �״���� ��
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			//?�� ���� �ϳ��� �־��ش�
			ps.setLong(1, Integer.parseInt(newData));
			ps.setString(2, menu_name);
			ps.setString(3, cus_id);
			
			
			//���� ���� �ִٸ� ���� �������� ��
			result = ps.executeUpdate();
		} catch (SQLException e) {
		}
		//result�� 1�̸� ���� ���ߴٴ� ���̹Ƿ� true�� ��ȯ�ǰ� �ȴ�.
		//0�̸� ���� �״�ζ�� ������ false�� ��ȯ
		return result == 1;
	}

	//��ٱ��Ͽ� �ִ� �޴� �����ϴ� �޼���
	//�޴� �̸��� �ҷ��ͼ� delete ���ָ� ��
	public boolean deleteProduct(String cus_id, String menu_name) {
		String sql = "DELETE FROM ORDER_DETAIL WHERE MENU_NAME=? AND CUS_ID=?";
		//�ʱⰪ�� 0���� �ش�.
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			//?�� �޴� �̸��� �־��༭ �޴� �̸��� ������ �ֹ��󼼳������� �����ǰ� ��
			ps.setString(1, menu_name);
			ps.setString(2, cus_id);
			
			//���� ���� �ִٸ� 1�� ���� ���̴�
			result = ps.executeUpdate();
		} catch (SQLException e) {
		}
		//1�̸� true / 0 �״�θ� false
		return result == 1;
	}
}
