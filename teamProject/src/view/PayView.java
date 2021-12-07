package view;

import java.util.Scanner;

import dao.CustomerDAO;

public class PayView {
	public PayView(String cus_id) {
		Scanner sc = new Scanner(System.in);
		CustomerDAO cdao = new CustomerDAO();

		while(true) {
			System.out.println("------ ���� â ------");
			System.out.println("���� ����� �������ּ���.");
			System.out.println("[1] ���� ����");
			System.out.println("[2] ī�� ����");
			System.out.println("[3] ��ٱ��Ϸ� ���ư���");
			
			int choice = sc.nextInt();
			
			if(choice == 1) {
				int total = cdao.getTotal(cus_id);
				System.out.println("�Ѿ� : "+total+"��");
				System.out.println("�������� �����Ǿ����ϴ�.");
				cdao.updateTotal(cus_id, 0);
			}else if(choice == 2) {
				int total = cdao.getTotal(cus_id);
				System.out.println("�Ѿ� : "+total+"��");
				System.out.println("ī��� �����Ǿ����ϴ�.");
				cdao.updateTotal(cus_id, 0);
			}else if(choice == 3) {
				new PaymentView();
			}else {
				System.out.println("���� ���� / ������ �ٽ� �õ����ּ���.");
			}
		}
	}
}