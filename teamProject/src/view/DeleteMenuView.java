package view;

import java.util.Scanner;

import dao.MenuDAO;
import dao.Session;
import dto.CustomerDTO;

public class DeleteMenuView {
	public DeleteMenuView(String cus_id) {
		Scanner sc = new Scanner(System.in);
		MenuDAO mdao = new MenuDAO();
		
		while(true) {
			System.out.println("------ 메뉴 삭제 ------");
			System.out.println("[1] 메뉴 삭제하기");
			System.out.println("[2] 장바구니로 다시 돌아가기");
			int number = sc.nextInt();
			
			if(number == 1) {
				//내가 올린 상품 목록 띄우기
//				System.out.println(pdao.getList(cus_id));
				System.out.println("삭제할 메뉴 이름 : ");
				String menu_name = sc.next();
				
				if(mdao.deleteProduct(cus_id, menu_name)) {
					System.out.println(menu_name+"이 정상적으로 삭제되었습니다.");
				}else {
					System.out.println("메뉴 삭제 실패 / 다음에 다시 입력해주세요.");
				}
			}else if(number == 2) {
				new PaymentView();
			}else {
				System.out.println("번호를 다시 입력해주세요.");
			}
		}
	}
}