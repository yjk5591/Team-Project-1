package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
