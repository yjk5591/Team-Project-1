package view;

import java.util.Scanner;

import dao.CustomerDAO;
import dao.StoreDAO;

public class SelectStoreView {
	public SelectStoreView() {
		Scanner sc = new Scanner(System.in);
		CustomerDAO udao = new CustomerDAO();
		StoreDAO sdao = new StoreDAO();
//		CustomerDTO loginUser = (CustomerDTO)Session.get("loginUser");
		
		System.out.println("------ ���� ���� ------");
		
		System.out.println("ã���ô� ������ �ּҸ� �����ּ��� : ");
		String store_addr = sc.nextLine();

		if(sdao.checkStore(store_addr)==store_addr) {
			System.out.println(store_addr+"�� ������ �����մϴ�.");
		}else {
			System.out.println("���� ���� ���� / ������ �ٽ� �õ����ּ���.");
		}
		
	}
}
