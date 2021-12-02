package view;

import java.util.Scanner;

import dao.MenuDAO;
import dao.Menu_ID_Generation;
import dto.MenuDTO;

public class Menu_add {
	public Menu_add() {
		MenuDAO mdao = new MenuDAO();
		Menu_ID_Generation mig = new Menu_ID_Generation();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("추가할 메뉴 이름 : ");
		String menu_name = sc.next();
		System.out.println(menu_name+" 가격 : ");
		int menu_price = sc.nextInt();
		System.out.println(menu_name+" 카테고리 : ");
		String menu_category = sc.next();
		String menu_id = mig.getMenu_ID();
		System.out.println(menu_name+" 을(를) 신제품으로 등록하려면 1, 아니라면 0을 입력해주세요. ");
		int menu_new = sc.nextInt();
		if(menu_new == 1) {
			System.out.println("해당 제품은 신제품으로 등록되었습니다.");			
		}else {
			System.out.println("해당 제품은 신제품이 아닙니다.");
		}
		int menu_num = mig.getMenu_NUM();
		while(true) {
			if(mdao.check_menu_num(menu_num)) {
				break;
			}else {
				menu_num = mig.getMenu_NUM();
			}
		}
		MenuDTO newMenu = new MenuDTO(menu_name, menu_price, menu_num, menu_category, menu_id, menu_new);
		if(mdao.add(newMenu)) {
			System.out.println("메뉴 추가가 성공적으로 완료되었습니다.");
		}else {
			System.out.println("메뉴 추가에 실패하였습니다. 다시 시도해주세요.");
		}
	}
}
