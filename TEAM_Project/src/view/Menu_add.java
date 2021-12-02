package view;

import java.util.Scanner;

import dao.MenuDAO;
import dao.Menu_ID_Generation;
import dto.MenuDTO;

public class Menu_add {
	public Menu_add() {
		MenuDAO mdao = new MenuDAO();
		Menu_ID_Generation mig = new Menu_ID_Generation();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�߰��� �޴� �̸� : ");
		String menu_name = sc.next();
		System.out.println(menu_name+" ���� : ");
		int menu_price = sc.nextInt();
		System.out.println(menu_name+" ī�װ� : ");
		String menu_category = sc.next();
		//�޴� ���̵� dao��Ű���� Menu_ID_Generation Ŭ���� �ȿ� �ִ� �޼ҵ带 ���� �ο�
		String menu_id = mig.getMenu_ID();
		System.out.println(menu_name+" ��(��) ����ǰ���� ����Ϸ��� 1, �ƴ϶�� 0�� �Է����ּ���. ");
		int menu_new = sc.nextInt();
		//DB���� �Ҹ�Ÿ�� ������ ���� �����Ƿ� 1�� ����ǰ, 0�� ����ǰ�� �ƴѰ����� �Ͽ���
		if(menu_new == 1) {
			System.out.println("�ش� ��ǰ�� ����ǰ���� ��ϵǾ����ϴ�.");			
		}else {
			System.out.println("�ش� ��ǰ�� ����ǰ�� �ƴմϴ�.");
		}
		//�޴� ���̵�� ����������  Menu_ID_Generation Ŭ���� �ȿ� �ִ� �޼ҵ带 ���� �ο�
		int menu_num = mig.getMenu_NUM();
		//�ѹ��� ��� �ߺ��� �߻��� �� �����Ƿ� while���� ���ؼ� �ߺ��� �����־���
		while(true) {
			//���� �ߺ�üũ�ϴ� �޼ҵ忡�� �ߺ��� ���ٰ� ������ ���
			if(mdao.check_menu_num(menu_num)) {
				//�״�� Ż��
				break;
				//�׷��� �ʴٸ� �ߺ��̶�� ��
			}else {
				//�޴� �ѹ��� �缳�����ְ� while������ ���ư�
				//�� �� �ٽ� if���� ��ġ�Ƿ� ���� ����ؼ� �ߺ��� ���� ��� �ߺ����� ���� ������ �ѹ� �缳��
				menu_num = mig.getMenu_NUM();
			}
		}
		//MenuDTO ��ü�� ������ ���� 
		MenuDTO newMenu = new MenuDTO(menu_name, menu_price, menu_num, menu_category, menu_id, menu_new);
		//MenuDAOŬ���� ���� add �޼ҵ带 ���� ���������� DB�� �����Ͱ� ����Ǿ��ٸ�
		if(mdao.add(newMenu)) {
			//���
			System.out.println("�޴� �߰��� ���������� �Ϸ�Ǿ����ϴ�.");
			//������� ���ϰ� �����Ͽ��ٸ�
		}else {
			//���
			System.out.println("�޴� �߰��� �����Ͽ����ϴ�. �ٽ� �õ����ּ���.");
		}
	}
}
