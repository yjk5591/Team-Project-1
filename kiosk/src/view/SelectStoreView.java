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
