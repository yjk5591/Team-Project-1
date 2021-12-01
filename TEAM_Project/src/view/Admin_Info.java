package view;

import java.util.Scanner;

import dao.AdminDAO;

public class Admin_Info {
	public Admin_Info() {
		AdminDAO adao = new AdminDAO();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. 소속 매장 변경\n2. 비밀번호 변경\n3. 전화번호 변경\n4. 나가기");
			int choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("매장 변경을 위해 관리자 ID를 입력해 주세요 : ");
				String admin_id = sc.next();
				System.out.println("변경할 매장의 매장 아이디를 입력해 주세요 : ");
				String admin_store_id = sc.next();
				if(adao.change_Store(admin_store_id, admin_id)) {
					System.out.println("소속 매장이 성공적으로 변경되었습니다!");
				}else {
					System.out.println("매장 변경에 실패하였습니다. 다시 시도해주세요.");
				}
			}else if(choice == 2) {
				
			}else if(choice == 3) {
				
			}else if(choice == 4) {
				System.out.println("감사합니다.");
				break;
			}
		}
	}
}
