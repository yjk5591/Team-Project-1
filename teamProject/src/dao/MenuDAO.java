package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import dto.MenuDTO;

public class MenuDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public MenuDAO() {
		conn = DBConnection.getConnection();
	}
	
	//�޴� �ѹ� �ߺ������� üũ�ϴ� �޼ҵ�
		public boolean check_menu_num(int menu_num) {
			String sql = "SELECT * FROM MENU_DB WHERE MENU_NUM = ?";
			boolean result = false;
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, menu_num);
				rs = ps.executeQuery();
				
				result = !rs.next();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
			return result;
		}
		//�޴� DB�� �߰��ϴ� �޼ҵ�
		public boolean add(MenuDTO newMenu) {
			int result = 0;
			String sql = "INSERT INTO MENU_DB (MENU_NAME, MENU_PRICE, MENU_NUM, MENU_CATEGORY, MENU_ID, MENU_NEW)"
					+ "VALUES(?,?,?,?,?,?)";
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, newMenu.menu_name);
				ps.setInt(2, newMenu.menu_price);
				ps.setInt(3, newMenu.menu_num);
				ps.setString(4, newMenu.menu_category);
				ps.setString(5, newMenu.menu_id);
				ps.setInt(6, newMenu.menu_new);
				
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result == 1;
		}
		public boolean menu_delete(String menu_name) {
			//�޴� �̸��� menu_name�� ���� ������ ��� �����ض� ��� ������ �ۼ�
			String sql = "DELETE FROM MENU_DB WHERE MENU_NAME = ?";
			int result = 0;
			try {
				//����ְ� 
				ps = conn.prepareStatement(sql);
				//�������� ?�� menu_name�� �Է�
				ps.setString(1, menu_name);
				//����� ������ ������ �ִٸ� 1, ������ 0�� ���̴�.
				result = ps.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//�׷��� ������ ������ �����ߴٸ� result���� ��, �����ߴٸ� ������ ���ϵȴ�.
			return result == 1;
			
		}
		
		public boolean menu_mod(String menu_name, String mod_menu_name, int mod_menu_price) {
			//�޴� �̸��� menu_name�� ���� �޴� �̸��� �޴� ������ �����ϴ� �������� �ۼ�
			String sql = "UPDATE MENU_DB SET MENU_NAME = ?, MENU_PRICE = ? WHERE MENU_NAME = ?";
			int result = 0;
			try {
				//����ְ�
				ps = conn.prepareStatement(sql);
				//�������� 3���� ? �� ù ��° ?�� ���ο� �޴��̸��� �Է�
				ps.setString(1, mod_menu_name);
				//�� ��° ?�� ���ο� ���� �Է�
				ps.setInt(2, mod_menu_price);
				//�� ��° ?�� ���� �޴� �̸��� �Է�
				ps.setString(3, menu_name);
				//result ���� ������ ������ �ִٸ� 1�� ��� ���̰�, ������ ������ ���ٸ� 0�� ��� ���̴�.
				result = ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//���� ������ �����ߴٸ� result���� true, �����ߴٸ� false�� ���ϵȴ�.
			//���� ������ �����ߴٴ� ���� ���� MENU_NAME �÷��� �������� ���ǿ� �����ϴ� ������ �Էµ��� �ʾ����� �ǹ��Ѵ�.
			//�̴� ��, �Է��� ���� MENU_NAME ���� �߸��Ǿ��ٴ� ���� �ǹ��ϹǷ� ������ ���ϵǾ��ٸ� 
			//��Ȯ�� �޴��̸��� �ٽ� �Է����־�� �Ѵ�.
			return result == 1;
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

	public String[] getList(String cus_id) {
		String sql = "SELECT ORDER_NUMBER,MENU_NAME,ORDER_AMOUNT,MENU_PRICE FROM ORDER_DETAIL WHERE CUS_ID=?";
		String[] menulist = new String[4];
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cus_id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				menulist[0] = rs.getString("ORDER_NUMBER");
				menulist[1] = rs.getString("MENU_NAME");
				menulist[2] = rs.getString("ORDER_AMOUNT");
				menulist[3] = rs.getString("MENU_PRICE");
			}
		} catch (SQLException e) {
		}
		return menulist;
	}
}
