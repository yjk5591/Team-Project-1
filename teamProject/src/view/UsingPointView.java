package view;

import java.util.Scanner;

import dao.CustomerDAO;
import dao.MenuDAO;
import dao.Session;
import dto.CustomerDTO;

public class UsingPointView {
	public UsingPointView(String cus_id) {
		Scanner sc = new Scanner(System.in);
		MenuDAO mdao = new MenuDAO();
		CustomerDAO cdao = new CustomerDAO();

		while(true) {
			System.out.println("------ ����Ʈ ��� ------");
			System.out.println("[1] ����Ʈ ����ϱ�");
			System.out.println("[2] ��ٱ��Ϸ� �ٽ� ���ư���");
			int number = sc.nextInt();
			
			if(number == 1) {
				//���� ����Ʈ�� ����
				System.out.println("����� ����Ʈ �ݾ� : ");
				int usepoint = sc.nextInt();
				
				if(cdao.updatePoint(cus_id, usepoint)) {
					System.out.println(usepoint+" ����Ʈ�� ���Ǿ����ϴ�.");
					cdao.establishPoint(cus_id);
				}else {
					System.out.println("����Ʈ ��� ���� / ������ �ٽ� �õ����ּ���.");
				}
			}else if(number == 2) {
				new PaymentView();
			}else {
				System.out.println("��ȣ�� �ٽ� �Է����ּ���.");
			}
		}
	}
}