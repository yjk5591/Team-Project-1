package view;

import java.util.Scanner;

import dao.ProductDAO;

public class UsePointView {
	public UsePointView() {
		Scanner sc = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
//		CustomerDTO loginUser = (CustomerDTO)Session.get("loginUser");
		
		System.out.println("------ 포인트 사용 ------");
		
		//보유 포인트량 보기
		
		
		System.out.println("사용할 포인트 금액 : ");
		int usepoint = sc.nextInt();
		
		
		
		
	}
}
