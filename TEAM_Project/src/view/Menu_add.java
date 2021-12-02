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
		//메뉴 아이디를 dao패키지의 Menu_ID_Generation 클래스 안에 있는 메소드를 통해 부여
		String menu_id = mig.getMenu_ID();
		System.out.println(menu_name+" 을(를) 신제품으로 등록하려면 1, 아니라면 0을 입력해주세요. ");
		int menu_new = sc.nextInt();
		//DB에서 불린타입 지정이 되지 않으므로 1을 신제품, 0은 신제품이 아닌것으로 하였음
		if(menu_new == 1) {
			System.out.println("해당 제품은 신제품으로 등록되었습니다.");			
		}else {
			System.out.println("해당 제품은 신제품이 아닙니다.");
		}
		//메뉴 아이디와 마찬가지로  Menu_ID_Generation 클래스 안에 있는 메소드를 통해 부여
		int menu_num = mig.getMenu_NUM();
		//넘버의 경우 중복이 발생할 수 있으므로 while문을 통해서 중복을 없애주었음
		while(true) {
			//만약 중복체크하는 메소드에서 중복이 없다고 나왔을 경우
			if(mdao.check_menu_num(menu_num)) {
				//그대로 탈출
				break;
				//그렇지 않다면 중복이라는 뜻
			}else {
				//메뉴 넘버를 재설정해주고 while문으로 돌아감
				//이 때 다시 if문을 거치므로 만약 계속해서 중복이 나올 경우 중복되지 않을 때까지 넘버 재설정
				menu_num = mig.getMenu_NUM();
			}
		}
		//MenuDTO 객체로 데이터 포장 
		MenuDTO newMenu = new MenuDTO(menu_name, menu_price, menu_num, menu_category, menu_id, menu_new);
		//MenuDAO클래스 안의 add 메소드를 통해 성공적으로 DB에 데이터가 저장되었다면
		if(mdao.add(newMenu)) {
			//출력
			System.out.println("메뉴 추가가 성공적으로 완료되었습니다.");
			//저장되지 못하고 실패하였다면
		}else {
			//출력
			System.out.println("메뉴 추가에 실패하였습니다. 다시 시도해주세요.");
		}
	}
}
