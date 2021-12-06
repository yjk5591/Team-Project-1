package view;

import java.util.Scanner;

import dao.AdminDAO;


public class AdminInfo {
	public AdminInfo() {
		AdminDAO adao = new AdminDAO();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. �Ҽ� ���� ����\n2. ��й�ȣ ����\n3. ��ȭ��ȣ ����\n4. ������");
			int choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("���� ������ ���� ������ ID�� �Է��� �ּ��� : ");
				String admin_id = sc.next();
				System.out.println("������ ������ ���� ���̵� �Է��� �ּ��� : ");
				String admin_store_id = sc.next();
				if(adao.change_Store(admin_store_id, admin_id)) {
					System.out.println("�Ҽ� ������ ���������� ����Ǿ����ϴ�!");
				}else {
					System.out.println("���� ���濡 �����Ͽ����ϴ�. �ٽ� �õ����ּ���.");
				}
			}else if(choice == 2) {
				System.out.println("��й�ȣ ������ ���� ���� ��й�ȣ�� �Է���  �ּ��� : ");
				String old_pw = sc.next();
				if(adao.check_pw(old_pw)) {
					System.out.println("��й�ȣ�� Ȯ�εǾ����ϴ�.\n���ο� ��й�ȣ�� �Է��� �ּ��� : ");
					String new_pw = sc.next();
					if(adao.change_pw(new_pw, old_pw)) {
						System.out.println("��й�ȣ ���� ����!!");
					}else {
						System.out.println("��й�ȣ ���� ����..\n�ٽ� �õ����ּ���.");
					}
				}else {
					System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.\n�ٽ� �õ����ּ���");
				}
				
			}else if(choice == 3) {
				System.out.println("�������� ������ ���� ��й�ȣ�� �Է��� �ּ��� : ");
				String admin_pw = sc.next();
				if(adao.check_pw(admin_pw)) {
					System.out.println("��й�ȣ�� Ȯ�εǾ����ϴ�.\n���ο� ��ȭ��ȣ�� �Է��� �ּ��� : ");
					String new_phone = sc.next();
					if(adao.change_phone(new_phone, admin_pw)) {
						System.out.println("��ȭ��ȣ ������ �Ϸ�Ǿ����ϴ�.");
					}else {
						System.out.println("��ȭ��ȣ ���� ����.. \n�ٽ� �õ����ּ���.");
					}
				}else {
					System.out.println("��й�ȣ ���� \n�ٽ� �õ����ּ���.");
				}
			}else if(choice == 4) {
				System.out.println("�����մϴ�.");
				break;
			}
		}
	}
}