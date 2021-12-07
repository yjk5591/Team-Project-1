package view;

import java.util.Scanner;

import dao.CustomerDAO;
import dao.MenuDAO;
import dao.Session;
import dto.CustomerDTO;

public class UsingPointView {
	public UsingPointView(String cus_id) {
		Scanner sc = new Scanner(System.in);
		MenuDAO mdao = new MenuDAO();
		CustomerDAO cdao = new CustomerDAO();

		while(true) {
			System.out.println("------ 포인트 사용 ------");
			System.out.println("[1] 포인트 사용하기");
			System.out.println("[2] 장바구니로 다시 돌아가기");
			int number = sc.nextInt();
			
			if(number == 1) {
				//보유 포인트량 보기
				System.out.println("사용할 포인트 금액 : ");
				int usepoint = sc.nextInt();
				
				if(cdao.updatePoint(cus_id, usepoint)) {
					System.out.println(usepoint+" 포인트가 사용되었습니다.");
					cdao.establishPoint(cus_id);
				}else {
					System.out.println("포인트 사용 실패 / 다음에 다시 시도해주세요.");
				}
			}else if(number == 2) {
				new PaymentView();
			}else {
				System.out.println("번호를 다시 입력해주세요.");
			}
		}
	}
}