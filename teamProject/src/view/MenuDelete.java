package view;

import java.util.Scanner;

import dao.MenuDAO;

public class MenuDelete {
	public MenuDelete() {
		MenuDAO mdao = new MenuDAO();
		Scanner sc = new Scanner(System.in);
		
		//���� �ݺ������� �����ش�.
		while(true) {
			//������ �޴��� �̸��� ����ڿ��� �Է� �޴´�.
			System.out.println("������ �޴� �̸� :");
			String del_menu_name = sc.next();
			//�޴��� ������ ������ Ȯ���� �޴´�.
			System.out.println(del_menu_name+" �޴��� ������ �����Ͻðڽ��ϱ�?\n1.��\n2. �ƴϿ�");
			int choice = sc.nextInt();
			//���� 1�� �� �� �����ߴٸ�
			if(choice == 1) {
				//mdao�� menu_delete�޼ҵ带 ������ �� ���̶��
				if(mdao.menu_delete(del_menu_name)) {
					//��� �� while�� Ż��
					System.out.println(del_menu_name+" �޴��� ���������� �����Ǿ����ϴ�.");
					break;
				//�����̶�� 
				}else {
					//��� �� �ٽ� while������ ���ư��� �޴� �̸��� �ٽ� �Է¹޴´�.
					System.out.println("�޴� ������ �����Ͽ����ϴ�.\n�޴� �̸��� ��Ȯ�� �Է��Ͽ����� Ȯ�����ּ���.");
				}		
			//2�� �ƴϿ� �� �����ߴٸ�
			}else if(choice == 2) {
				//��� �� while�� Ż��
				System.out.println("�޴� ������ ����Ͽ����ϴ�.");
				break;
			//1, 2���� �ƴ� �ٸ� ���� �Է��ߴٸ�	
			}else {
				//��� �� �ٽ� while������ ���ư� ���Է� �޴´�.
				System.out.println("1, 2 �߿��� �Է����ּ���.");
			}
		}
	}
}
