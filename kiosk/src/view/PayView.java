package view;

import java.util.Scanner;

import dao.CustomerDAO;

public class PayView {
	public PayView(String cus_id) {
		Scanner sc = new Scanner(System.in);
		CustomerDAO cdao = new CustomerDAO();
		
		System.out.println("------ 결제 창 ------");
		System.out.println("결제 방식을 선택해주세요.");
		System.out.println("[1] 현금 결제");
		System.out.println("[2] 카드 결제");
		
		int choice = sc.nextInt();
		
		if(choice == 1) {
			int total = cdao.getTotal(cus_id);
			System.out.println("총액 : "+total+"원");
			System.out.println("현금으로 결제되었습니다.");
			cdao.updateTotal(cus_id, 0);
		}else if(choice == 2) {
			int total = cdao.getTotal(cus_id);
			System.out.println("총액 : "+total+"원");
			System.out.println("카드로 결제되었습니다.");
			cdao.updateTotal(cus_id, 0);
		}else {
			System.out.println("결제 실패 / 다음에 다시 시도해주세요.");
		}
	}
}
