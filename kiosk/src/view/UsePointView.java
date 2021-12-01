package view;

import java.util.Scanner;

import dao.CustomerDAO;
import dao.ProductDAO;

public class UsePointView {
	public UsePointView() {
		Scanner sc = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
		CustomerDAO udao = new CustomerDAO();
//		CustomerDTO loginUser = (CustomerDTO)Session.get("loginUser");
		
		System.out.println("------ 포인트 사용 ------");
		
		//보유 포인트량 보기
		System.out.println("아이디 입력 : ");
		String cus_id = sc.next();
		System.out.println("사용할 포인트 금액 : ");
		int usepoint = sc.nextInt();
		
		
		if(udao.usePoint(cus_id, usepoint)) {
			System.out.println(usepoint+" 포인트가 사용되었습니다.");
		}else {
			System.out.println("포인트 사용 실패 / 다음에 다시 시도해주세요.");
		}
		
		
	}
}
