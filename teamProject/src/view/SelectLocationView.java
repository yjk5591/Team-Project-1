package view;

import java.util.Scanner;

import dao.CustomerDAO;
import dao.Session;
import dto.CustomerDTO;

public class SelectLocationView {
	public SelectLocationView(String cus_id) {
		Scanner sc = new Scanner(System.in);
		CustomerDAO cdao = new CustomerDAO();

		while(true) {
			System.out.println("------ 배송지 선택 ------");
			System.out.println("[1] 기본 배송지");
			System.out.println("[2] 다른 배송지");
			System.out.println("[3] 장바구니로 돌아가기");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				System.out.println(cdao.selectLocation(cus_id, choice)+" 로 배송합니다.");
			}else if(choice == 2) {
				System.out.println("어디로 배송할까요? : ");
				String newlocation = sc.nextLine();
				
				System.out.println(cdao.selectNewLocation(cus_id, choice, newlocation)+" 로 배송합니다.");
			}else if(choice == 3){
				new PaymentView();
			}else {
				System.out.println("배송지 선택 실패 / 다음에 다시 시도해주세요.");
			}
		}
	}
}