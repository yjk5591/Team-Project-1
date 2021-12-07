package view;

import java.util.Scanner;

import dao.MenuDAO;

public class MenuMod {
	public MenuMod() {
		MenuDAO mdao = new MenuDAO();
		Scanner sc = new Scanner(System.in);
		//무한반복 설정
		while(true) {
			//정보 수정을 할 메뉴의 이름, 변경할 이름, 변경할 가격 입력 받기
			System.out.println("정보를 수정할 메뉴의 이름을 입력해주세요.");
			String menu_name = sc.next();
			System.out.println(menu_name+" 메뉴의 새로운 이름을 입력해주세요.");
			String mod_menu_name = sc.next();
			System.out.println(mod_menu_name+" 메뉴의 새로운 가격을 입력해주세요.");
			int mod_menu_price = sc.nextInt();
				//mdao의 menu_mod 메소드 실행 후 참이면
				if(mdao.menu_mod(menu_name, mod_menu_name, mod_menu_price)) {
					//출력 후 while문 탈출
					System.out.println("기존 "+menu_name+" 메뉴의 이름이"+mod_menu_name+" (으)로 변경되었습니다.\n"
									+mod_menu_name+" 메뉴의 새로운 가격은 "+mod_menu_price+"원 입니다." );
					break;
				//거짓이면	
				}else {
					//기존 메뉴 이름이 알맞지 않아 데이터가 존재하지 않는 것이기 때문에 정확한 이름을 다시 입력받기 위해 돌아감.
					System.out.println("기존 메뉴 이름이 없습니다. 다시 시도해주세요.");
				}
			}
		
		}
}
