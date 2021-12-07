package view;

import java.util.Scanner;

import view.AdminJoinView;

public class Index {
	public static void main(String[] args) {
		System.out.println("★★★★밥사조 키오스크 메인 화면★★★★");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("0. 나가기\n1. 회원가입\n2. 로그인\n3. 마이페이지\n4. 매장 찾기"
					+ "\n5. 메뉴\n6. 장바구니");
			int choice = sc.nextInt();
			
			if(choice == 0) {
				//나가기
				System.out.println("안녕히 가세요.");
				break;
			} else if(choice == 1) {
				//회원가입
				System.out.println("회원가입을 시작합니다.");
				while(true) {
					System.out.println("1. 관리자 회원가입");
					System.out.println("2. 고객 회원가입");
					int ch = sc.nextInt();
					if(ch == 1) {
						System.out.println("관리자 회원가입");
						new AdminJoinView();
					} else if(ch == 2) {
						System.out.println("고객 회원가입");
					} else {
						System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
					}
				}
			} else if(choice == 2) {
				//로그인
			} else if(choice == 3) {
				//마이페이지
			} else if(choice == 4) {
				//매장 찾기
			} else if(choice == 5) {
				//메뉴
			} else if(choice == 6) {
				//장바구니
				new PaymentView();
			} else {
				//잘못 입력 시
				System.out.println("잘못 입력했습니다. 처음으로 돌아갑니다.");
			}
		}
	}
}