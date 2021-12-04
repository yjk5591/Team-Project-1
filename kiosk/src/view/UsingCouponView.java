package view;

import java.util.Scanner;

import dao.CustomerDAO;
import dao.ProductDAO;
import dao.Session;
import dto.CustomerDTO;

public class UsingCouponView {
	public UsingCouponView(String cus_id) {
		Scanner sc = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
		CustomerDAO cdao = new CustomerDAO();
		
		System.out.println("------ 쿠폰 사용 ------");

		//내가 올린 상품 목록 띄우기
//		System.out.println(pdao.getList(loginUser.userid));
		System.out.println("사용할 쿠폰의 개수를 입력해주세요 : ");
		int usecoupons = sc.nextInt();
		
		if(cdao.updateCoupons(cus_id, usecoupons)) {
			System.out.println(cus_id+"의 쿠폰 "+usecoupons+"개가 정상적으로 사용되었습니다.");
		}else {
			System.out.println("쿠폰 사용 실패 / 다음에 다시 시도해주세요.");
		}
		
	}
}
