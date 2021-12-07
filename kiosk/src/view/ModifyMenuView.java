package view;

import java.util.Scanner;

import dao.MenuDAO;
import dao.Session;
import dto.CustomerDTO;

public class ModifyMenuView {
	public ModifyMenuView(String cus_id) {
		Scanner sc = new Scanner(System.in);
		MenuDAO mdao = new MenuDAO();
		
		while(true) {
			System.out.println("------ 수량 변경 ------");
			System.out.println("[1] 수량을 변경");
			System.out.println("[2] 장바구니로 다시 돌아가기");
			int number = sc.nextInt();
			
			if(number == 1) {
				//내가 올린 상품 목록 띄우기
//				System.out.println(pdao.getList(cus_id));
				System.out.println("변경할 상품 이름 : ");
				String menu_name = sc.next();
				System.out.println("수량 : ");
				String newData = sc.next();
				
				if(mdao.modifyAmount(cus_id, menu_name, newData)) {
					System.out.println(menu_name+"의 수량이 정상적으로 수정되었습니다.");
				}else {
					System.out.println("상품 수량 수정 실패 / 다음에 다시 시도해주세요.");
				}
			}else if(number == 2) {
				new PaymentView();
			}else {
				System.out.println("번호를 다시 입력해주세요.");
			}
		}
	}
}