package view;

import java.util.Scanner;

import dao.CustomerDAO;

public class SelectLocationView {
	public SelectLocationView() {
		Scanner sc = new Scanner(System.in);
		CustomerDAO cdao = new CustomerDAO();
//		CustomerDTO loginUser = (CustomerDTO)Session.get("loginUser");
		
		System.out.println("------ 배송지 선택 ------");

		System.out.println("아이디를 입력해주세요 : ");
		String cus_id = sc.next();
		System.out.println("[1] 기본 배송지");
		System.out.println("[2] 다른 배송지");
		int choice = sc.nextInt();
		
		if(cdao.selectLocation(cus_id, choice)) {
			System.out.println("선택한 배송지로 배송합니다.");
		}else {
			System.out.println("배송지 선택 실패 / 다음에 다시 시도해주세요.");
		}
	}
}
