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
		
		System.out.println("------ ����Ʈ ��� ------");
		
		//���� ����Ʈ�� ����
		System.out.println("���̵� �Է� : ");
		String cus_id = sc.next();
		System.out.println("����� ����Ʈ �ݾ� : ");
		int usepoint = sc.nextInt();
		
		
		if(udao.usePoint(cus_id, usepoint)) {
			System.out.println(usepoint+" ����Ʈ�� ���Ǿ����ϴ�.");
		}else {
			System.out.println("����Ʈ ��� ���� / ������ �ٽ� �õ����ּ���.");
		}
		
		
	}
}
