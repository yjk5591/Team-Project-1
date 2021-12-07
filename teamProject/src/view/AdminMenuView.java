package view;

import java.util.Scanner;

import dao.MenuDAO;

public class AdminMenuView {
	public AdminMenuView() {
		Scanner sc = new Scanner(System.in);
		MenuDAO mdao = new MenuDAO();
		int choice = 0;
		while(true) {
			System.out.println("원하시는 항목을 골라주세요.\n1. 메뉴 추가\n2. 메뉴 수정\n3. 메뉴 삭제\n4. 나가기");
			choice = sc.nextInt();
			if(choice == 1) {
				new MenuAdd();
			}else if(choice == 2) {
				new MenuMod();
			}else if(choice == 3) {
				new MenuDelete();
			}else if(choice == 4) {
				System.out.println("메뉴 추가/수정/삭제 항목에서 나갑니다.");
				break;
			}
		}
	}
}