package view;

import java.util.Scanner;

import dao.CustomerDAO;
import dao.ProductDAO;

public class UsingCouponView {
	public UsingCouponView() {
		Scanner sc = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
		CustomerDAO udao = new CustomerDAO();
//		CustomerDTO loginUser = (CustomerDTO)Session.get("loginUser");
		
		System.out.println("------ ���� ��� ------");
		

		//���� �ø� ��ǰ ��� ����
//		System.out.println(pdao.getList(loginUser.userid));
		System.out.println("���̵� �Է����ּ��� : ");
		String cus_id = sc.next();
		System.out.println("����� ������ ������ �Է����ּ��� : ");
		int usecoupons = sc.nextInt();
		
		if(udao.updateCoupons(cus_id, usecoupons)) {
			System.out.println(cus_id+"�� ���� "+usecoupons+"���� ���������� ���Ǿ����ϴ�.");
		}else {
			System.out.println("���� ��� ���� / ������ �ٽ� �õ����ּ���.");
		}
		
	}
}
