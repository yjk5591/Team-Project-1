package view;

import java.util.Scanner;

import dao.ProductDAO;

public class UsePointView {
	public UsePointView() {
		Scanner sc = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
//		CustomerDTO loginUser = (CustomerDTO)Session.get("loginUser");
		
		System.out.println("------ ����Ʈ ��� ------");
		
		//���� ����Ʈ�� ����
		
		
		System.out.println("����� ����Ʈ �ݾ� : ");
		int usepoint = sc.nextInt();
		
		
		
		
	}
}
