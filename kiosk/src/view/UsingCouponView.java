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
		
		System.out.println("------ ���� ��� ------");

		//���� �ø� ��ǰ ��� ����
//		System.out.println(pdao.getList(loginUser.userid));
		System.out.println("����� ������ ������ �Է����ּ��� : ");
		int usecoupons = sc.nextInt();
		
		if(cdao.updateCoupons(cus_id, usecoupons)) {
			System.out.println(cus_id+"�� ���� "+usecoupons+"���� ���������� ���Ǿ����ϴ�.");
		}else {
			System.out.println("���� ��� ���� / ������ �ٽ� �õ����ּ���.");
		}
		
	}
}
