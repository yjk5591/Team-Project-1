package view;

import java.util.Scanner;

import dao.MenuDAO;
import dao.Session;
import dto.CustomerDTO;

//장바구니 뷰
public class PaymentView {
	public static void main(String[] args) {
		if(Session.get("loginUser") != null) {
			Scanner sc = new Scanner(System.in);
			CustomerDTO loginUser = (CustomerDTO)Session.get("loginUser");
			MenuDAO mdao = new MenuDAO();
			
			System.out.println("========== 장바구니 ==========");
			while(true) {
				if(Session.get("loginUser") == null) {
					break;
				} else {
					loginUser = (CustomerDTO)Session.get("loginUser");
				}
				
				System.out.println(loginUser.cus_name + "님(" + loginUser.cus_id + ") 장바구니");
				System.out.println("0. 처음으로 돌아가기\n1. 수량 변경\n2. 메뉴 삭제\n3. 쿠폰 사용"
						+ "\n4. 포인트 사용\n5. 매장 선택\n6. 배송지 선택\n7. 결제하기");
				int choice = sc.nextInt();
				
				switch(choice) {
				case 0:
					//처음으로 돌아가기
					new Index();
					break;
				case 1:
					//수량 변경
					new ModifyProductView(loginUser.cus_id);
					break;
				case 2:
					//메뉴 삭제
					new DeleteProductView(loginUser.cus_id);
					break;
				case 3:
					//쿠폰 사용
					new UsingCouponView(loginUser.cus_id);
					break;
				case 4:
					//포인트 사용
					new UsingPointView(loginUser.cus_id);
					break;
				case 5:
					//매장 선택
					new SelectStoreView();
					break;
				case 6:
					//배송지 선택
					new SelectLocationView(loginUser.cus_id);
					break;
				case 7:
					//결제하기
					new PayView(loginUser.cus_id);
					break;
				default:
					System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
				}
			}
		}
	}
}
