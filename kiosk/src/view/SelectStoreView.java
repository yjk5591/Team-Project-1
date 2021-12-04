package view;

import java.util.Scanner;

import dao.CustomerDAO;
import dao.Session;
import dao.StoreDAO;
import dto.CustomerDTO;

public class SelectStoreView {
	public SelectStoreView() {
		Scanner sc = new Scanner(System.in);
		StoreDAO sdao = new StoreDAO();

		while(true) {
			System.out.println("------ ���� ���� ------");
			System.out.println("[1] ����Ʈ ����ϱ�");
			System.out.println("[2] ��ٱ��Ϸ� �ٽ� ���ư���");
			int number = sc.nextInt();
			
			if(number == 1) {
				System.out.println("ã���ô� ������ �ּҸ� �����ּ��� : ");
				String store_addr = sc.nextLine();
		
				if(sdao.checkStore(store_addr)==store_addr) {
					System.out.println(store_addr+"�� ������ �����մϴ�.");
				}else {
					System.out.println("���� ���� ���� / ������ �ٽ� �õ����ּ���.");
				}
			}else if(number == 2) {
				new PaymentView();
			}else {
				System.out.println("��ȣ�� �ٽ� �Է����ּ���.");
			}
		}
	}
}
