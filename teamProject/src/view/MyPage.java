package view;

import java.util.Scanner;

import dao.AdminDAO;

public class MyPage {
	public MyPage() {
		AdminDAO adao = new AdminDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ���̵� �Է����ּ���.");
		String admin_store_id = sc.next();
		System.out.println("�Ҽ� ������ "+adao.myStore(admin_store_id)+"�Դϴ�.");
		while(true) {
			System.out.println("1. �츮 ���� �򰡺���\n2. ������ ���� ����\n3. ������");
			int choice = sc.nextInt();
			if(choice == 1) {
				
			}else if(choice == 2) {
				new AdminInfo();
			}else if(choice == 3) {
				System.out.println("���� ���������� �����ϴ�.");
				break;
			}
		}
	}
}
