package dao;

import java.util.Random;
import java.util.UUID;


public class Menu_ID_Generation {
	//�޴� ���̵� ���� �޼ҵ�
	public String getMenu_ID() {
		String menu_id = UUID.randomUUID().toString();
		
		menu_id = menu_id.replace("-", "");
		
		return menu_id;
	}
	//�޴� �ѹ� ���� �޼ҵ� (�������� �̾Ƴ����� �ߺ����� ���� ���ɼ��� ����)
	public int getMenu_NUM() {
		Random random = new Random();
		int menu_num = random.nextInt(10000);
		
		
		return menu_num;
	
	}
	
}
