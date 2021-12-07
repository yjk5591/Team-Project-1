package view;

import java.util.Scanner;

import dao.CustomerDAO;
import dao.MenuDAO;
import dao.Session;
import dto.CustomerDTO;

public class UsingCouponView {
	public UsingCouponView(String cus_id) {
		Scanner sc = new Scanner(System.in);
		MenuDAO mdao = new MenuDAO();
		CustomerDAO cdao = new CustomerDAO();

		while(true) {
			System.out.println("------ ���� ��� ------");
			System.out.println("[1] ���� ����ϱ�");
			System.out.println("[2] ��ٱ��Ϸ� �ٽ� ���ư���");
			int number = sc.nextInt();
			
			if(number == 1) {
				System.out.println("�����ϰ� �ִ� ������ ���� : "+cdao.getCoupons(cus_id));
				System.out.println("����� ������ ������ �Է����ּ��� : ");
				int usecoupons = sc.nextInt();
				
				if(cdao.updateCoupons(cus_id, usecoupons)) {
					System.out.println(cus_id+"�� ���� "+usecoupons+"���� ���������� ���Ǿ����ϴ�.");
				}else {
					System.out.println("���� ��� ���� / ������ �ٽ� �õ����ּ���.");
				}
			}else if(number == 2) {
				new PaymentView();
			}else {
				System.out.println("��ȣ�� �ٽ� �Է����ּ���.");
			}
		}
	}
}