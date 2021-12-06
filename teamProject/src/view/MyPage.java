package view;

import java.util.Scanner;

import dao.AdminDAO;

public class MyPage {
	public MyPage() {
		AdminDAO adao = new AdminDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("매장 아이디를 입력해주세요.");
		String admin_store_id = sc.next();
		System.out.println("소속 매장은 "+adao.myStore(admin_store_id)+"입니다.");
		while(true) {
			System.out.println("1. 우리 매장 평가보기\n2. 관리자 정보 변경\n3. 나가기");
			int choice = sc.nextInt();
			if(choice == 1) {
				
			}else if(choice == 2) {
				new AdminInfo();
			}else if(choice == 3) {
				System.out.println("마이 페이지에서 나갑니다.");
				break;
			}
		}
	}
}
