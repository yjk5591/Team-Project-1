package view;

import java.util.Scanner;

import dao.CustomerDAO;
import dao.Session;
import dto.CustomerDTO;

public class SelectLocationView {
	public SelectLocationView(String cus_id) {
		Scanner sc = new Scanner(System.in);
		CustomerDAO cdao = new CustomerDAO();

		while(true) {
			System.out.println("------ ����� ���� ------");
			System.out.println("[1] �⺻ �����");
			System.out.println("[2] �ٸ� �����");
			System.out.println("[3] ��ٱ��Ϸ� ���ư���");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				System.out.println(cdao.selectLocation(cus_id, choice)+" �� ����մϴ�.");
			}else if(choice == 2) {
				System.out.println("���� ����ұ��? : ");
				String newlocation = sc.nextLine();
				
				System.out.println(cdao.selectNewLocation(cus_id, choice, newlocation)+" �� ����մϴ�.");
			}else if(choice == 3){
				new PaymentView();
			}else {
				System.out.println("����� ���� ���� / ������ �ٽ� �õ����ּ���.");
			}
		}
	}
}