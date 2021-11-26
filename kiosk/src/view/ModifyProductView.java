package view;

import java.util.Scanner;

import dao.ProductDAO;
import dao.Session;

public class ModifyProductView {
	public ModifyProductView() {
		Scanner sc = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
//		UserDTO loginUser = (UserDTO)Session.get("loginUser");
		
		System.out.println("------ 수량 변경 ------");
		
		//내가 올린 상품 목록 띄우기
//		System.out.println(pdao.getList(loginUser.userid));
		System.out.println("변경할 상품 이름 : ");
		String menuname = sc.next();
		System.out.println("수량 : ");
		int newData = sc.nextInt();
		
			
		}
	}