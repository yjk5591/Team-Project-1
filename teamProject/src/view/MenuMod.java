package view;

import java.util.Scanner;

import dao.MenuDAO;

public class MenuMod {
	public MenuMod() {
		MenuDAO mdao = new MenuDAO();
		Scanner sc = new Scanner(System.in);
		//���ѹݺ� ����
		while(true) {
			//���� ������ �� �޴��� �̸�, ������ �̸�, ������ ���� �Է� �ޱ�
			System.out.println("������ ������ �޴��� �̸��� �Է����ּ���.");
			String menu_name = sc.next();
			System.out.println(menu_name+" �޴��� ���ο� �̸��� �Է����ּ���.");
			String mod_menu_name = sc.next();
			System.out.println(mod_menu_name+" �޴��� ���ο� ������ �Է����ּ���.");
			int mod_menu_price = sc.nextInt();
				//mdao�� menu_mod �޼ҵ� ���� �� ���̸�
				if(mdao.menu_mod(menu_name, mod_menu_name, mod_menu_price)) {
					//��� �� while�� Ż��
					System.out.println("���� "+menu_name+" �޴��� �̸���"+mod_menu_name+" (��)�� ����Ǿ����ϴ�.\n"
									+mod_menu_name+" �޴��� ���ο� ������ "+mod_menu_price+"�� �Դϴ�." );
					break;
				//�����̸�	
				}else {
					//���� �޴� �̸��� �˸��� �ʾ� �����Ͱ� �������� �ʴ� ���̱� ������ ��Ȯ�� �̸��� �ٽ� �Է¹ޱ� ���� ���ư�.
					System.out.println("���� �޴� �̸��� �����ϴ�. �ٽ� �õ����ּ���.");
				}
			}
		
		}
}
