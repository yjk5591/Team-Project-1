package view;

import java.util.Scanner;

import dao.AdminDAO;

public class MyPage {
	public MyPage() {
		AdminDAO adao = new AdminDAO();
		Scanner sc = new Scanner(System.in);
		String admin_store_id = sc.next();
		System.out.println(adao.myStore(admin_store_id));
		while(true) {
			System.out.println("1. �츮 ���� �򰡺���\n2. ������ ���� ����\n3. ������");
			int choice = sc.nextInt();
			if(choice == 1) {
				
			}else if(choice == 2) {
				
			}else if(choice == 3) {
				System.out.println("���� ���������� �����ϴ�.");
				break;
			}
		}
	}
}
	
	
	

