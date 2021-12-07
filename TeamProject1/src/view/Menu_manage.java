package menu;

import java.util.Scanner;

public class Menu_manage {
	public Menu_manage() {
		System.out.println("메뉴관리 시스템");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. 메뉴추가\n2. 메뉴수정\n3. 메뉴삭제");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				new Menu_insert();
			} else if(choice == 2) {
				new Menu_update();
			} else if(choice == 3) {
				new Menu_delete();
			} else
				System.out.println("잘못 입력하셨습니다!\n다시 입력해주세요");
		}
	}
}
