package view;

import java.util.Scanner;

import dao.CustomerDAO;

public class SelectLocationView {
	public SelectLocationView() {
		Scanner sc = new Scanner(System.in);
		CustomerDAO cdao = new CustomerDAO();
//		CustomerDTO loginUser = (CustomerDTO)Session.get("loginUser");
		
		System.out.println("------ ����� ���� ------");

		System.out.println("���̵� �Է����ּ��� : ");
		String cus_id = sc.next();
		System.out.println("[1] �⺻ �����");
		System.out.println("[2] �ٸ� �����");
		int choice = sc.nextInt();
		
		if(cdao.selectLocation(cus_id, choice)) {
			System.out.println("������ ������� ����մϴ�.");
		}else {
			System.out.println("����� ���� ���� / ������ �ٽ� �õ����ּ���.");
		}
	}
}
