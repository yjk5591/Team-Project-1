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
			System.out.println(admin_id + "님 어서오세요!");
			System.out.println(Session.get("loginAdmin"));
		}else {
			System.out.println("로그인 실패");
		}
		while(true) {
			System.out.println("1. 마이페이지\n2. 메뉴수정\n3. 나가기");
			int choice = sc.nextInt();
			if(choice == 1) {
				new MyPage();
			} else if(choice == 2) {
				new Menu_Modify();
			} else if(choice == 3) {
				System.out.println("이용해주셔서 감사합니다^^");
				break;
			}
		}
	}	
}