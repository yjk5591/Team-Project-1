package view;

import java.util.Scanner;

import dao.MenuDAO;

public class MenuDelete {
	public MenuDelete() {
		MenuDAO mdao = new MenuDAO();
		Scanner sc = new Scanner(System.in);
		
		//무한 반복문으로 묶어준다.
		while(true) {
			//삭제할 메뉴의 이름을 사용자에게 입력 받는다.
			System.out.println("삭제할 메뉴 이름 :");
			String del_menu_name = sc.next();
			//메뉴를 삭제할 것인지 확인을 받는다.
			System.out.println(del_menu_name+" 메뉴를 정말로 삭제하시겠습니까?\n1.예\n2. 아니오");
			int choice = sc.nextInt();
			//만약 1번 예 를 선택했다면
			if(choice == 1) {
				//mdao의 menu_delete메소드를 실행한 후 참이라면
				if(mdao.menu_delete(del_menu_name)) {
					//출력 후 while문 탈출
					System.out.println(del_menu_name+" 메뉴가 정상적으로 삭제되었습니다.");
					break;
				//거짓이라면 
				}else {
					//출력 후 다시 while문으로 돌아가서 메뉴 이름을 다시 입력받는다.
					System.out.println("메뉴 삭제에 실패하였습니다.\n메뉴 이름을 정확히 입력하였는지 확인해주세요.");
				}		
			//2번 아니오 를 선택했다면
			}else if(choice == 2) {
				//출력 후 while문 탈출
				System.out.println("메뉴 삭제를 취소하였습니다.");
				break;
			//1, 2번이 아닌 다른 값을 입력했다면	
			}else {
				//출력 후 다시 while문으로 돌아가 재입력 받는다.
				System.out.println("1, 2 중에서 입력해주세요.");
			}
		}
	}
}
