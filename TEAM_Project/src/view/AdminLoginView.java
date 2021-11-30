package view;

import java.util.Scanner;

import dao.AdminDAO;
import dao.Session;

public class AdminLoginView {
	public AdminLoginView() {
		Scanner sc = new Scanner(System.in);
		AdminDAO adao = new AdminDAO();
		System.out.println("ID : ");
		String admin_id = sc.next();
		System.out.println("PW : ");
		String admin_pw = sc.next();
		if(adao.login(admin_id,admin_pw)) {
			System.out.println(admin_id + "�� �������!");
			System.out.println(Session.get("loginAdmin"));
		}else {
			System.out.println("�α��� ����");
		}
		while(true) {
			System.out.println("1. ����������\n2. �޴�����\n3. ������");
			int choice = sc.nextInt();
			if(choice == 1) {
				new MyPage();
			} else if(choice == 2) {
				new Menu_Modify();
			} else if(choice == 3) {
				System.out.println("�̿����ּż� �����մϴ�^^");
				break;
			}
		}
	}	
}