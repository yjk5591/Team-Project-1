package view;

import java.util.Scanner;

import dao.CustomerDAO;

public class PayView {
	public PayView() {
		Scanner sc = new Scanner(System.in);
		CustomerDAO cdao = new CustomerDAO();
		
		System.out.println("------ ���� â ------");
		System.out.println("���� ����� �������ּ���.");
		System.out.println("[1] ���� ����");
		System.out.println("[2] ī�� ����");
		
		int choice = sc.nextInt();
		
		if(choice == 1) {
			System.out.println("�������� �����մϴ�.");
			
		}else if(choice == 2) {
			System.out.println("ī��� �����մϴ�.");
			
		}else {
			System.out.println("���� ���� / ������ �ٽ� �õ����ּ���.");
		}
	}
}
