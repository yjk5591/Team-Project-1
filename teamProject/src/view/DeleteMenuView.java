package view;

import java.util.Scanner;

import dao.MenuDAO;
import dao.Session;
import dto.CustomerDTO;

public class DeleteMenuView {
	public DeleteMenuView(String cus_id) {
		Scanner sc = new Scanner(System.in);
		MenuDAO mdao = new MenuDAO();
		
		while(true) {
			System.out.println("------ �޴� ���� ------");
			System.out.println("[1] �޴� �����ϱ�");
			System.out.println("[2] ��ٱ��Ϸ� �ٽ� ���ư���");
			int number = sc.nextInt();
			
			if(number == 1) {
				//���� �ø� ��ǰ ��� ����
//				System.out.println(pdao.getList(cus_id));
				System.out.println("������ �޴� �̸� : ");
				String menu_name = sc.next();
				
				if(mdao.deleteProduct(cus_id, menu_name)) {
					System.out.println(menu_name+"�� ���������� �����Ǿ����ϴ�.");
				}else {
					System.out.println("�޴� ���� ���� / ������ �ٽ� �Է����ּ���.");
				}
			}else if(number == 2) {
				new PaymentView();
			}else {
				System.out.println("��ȣ�� �ٽ� �Է����ּ���.");
			}
		}
	}
}