package view;

import java.util.Scanner;

import dao.MenuDAO;
import dao.Session;
import dto.CustomerDTO;

public class ModifyMenuView {
	public ModifyMenuView(String cus_id) {
		Scanner sc = new Scanner(System.in);
		MenuDAO mdao = new MenuDAO();
		
		while(true) {
			System.out.println("------ ���� ���� ------");
			System.out.println("[1] ������ ����");
			System.out.println("[2] ��ٱ��Ϸ� �ٽ� ���ư���");
			int number = sc.nextInt();
			
			if(number == 1) {
				//���� �ø� ��ǰ ��� ����
//				System.out.println(pdao.getList(cus_id));
				System.out.println("������ ��ǰ �̸� : ");
				String menu_name = sc.next();
				System.out.println("���� : ");
				String newData = sc.next();
				
				if(mdao.modifyAmount(cus_id, menu_name, newData)) {
					System.out.println(menu_name+"�� ������ ���������� �����Ǿ����ϴ�.");
				}else {
					System.out.println("��ǰ ���� ���� ���� / ������ �ٽ� �õ����ּ���.");
				}
			}else if(number == 2) {
				new PaymentView();
			}else {
				System.out.println("��ȣ�� �ٽ� �Է����ּ���.");
			}
		}
	}
}