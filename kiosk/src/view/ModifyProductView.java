package view;

import java.util.Scanner;

import dao.ProductDAO;
import dao.Session;
import dto.CustomerDTO;

public class ModifyProductView {
	public ModifyProductView(String cus_id) {
		Scanner sc = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
		
		System.out.println("------ 수량 변경 ------");
		
		//내가 올린 상품 목록 띄우기
//		System.out.println(pdao.getList(loginUser.userid));
		System.out.println("변경할 상품 이름 : ");
		String menu_name = sc.next();
		System.out.println("수량 : ");
		String newData = sc.next();
		
		if(pdao.modifyAmount(cus_id, menu_name, newData)) {
			System.out.println(menu_name+"의 수량이 정상적으로 수정되었습니다.");
		}else {
			System.out.println("상품 수량 수정 실패 / 다음에 다시 시도해주세요.");
		}
	}
}