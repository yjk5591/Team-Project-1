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
			System.out.println("1. 우리 매장 평가보기\n2. 관리자 정보 변경\n3. 나가기");
			int choice = sc.nextInt();
			if(choice == 1) {
				
			}else if(choice == 2) {
				
			}else if(choice == 3) {
				System.out.println("마이 페이지에서 나갑니다.");
				break;
			}
		}
	}
}
	
	
	

