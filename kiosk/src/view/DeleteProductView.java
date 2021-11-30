package view;

import java.util.Scanner;

import dao.ProductDAO;

public class DeleteProductView {
	public DeleteProductView() {
		Scanner sc = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
//		CustomerDTO loginUser = (CustomerDTO)Session.get("loginUser");
		
		System.out.println("------ 메뉴 변경 ------");
		
		//내가 올린 상품 목록 띄우기
//		System.out.println(pdao.getList(loginUser.userid));
		System.out.println("삭제할 메뉴 이름 : ");
		String menu_name = sc.next();
		
		if(pdao.deleteProduct(menu_name)) {
			System.out.println(menu_name+"이 정상적으로 삭제되었습니다.");
		}else {
			System.out.println("메뉴 삭제 실패 / 다음에 다시 입력해주세요.");
		}
	}
}
