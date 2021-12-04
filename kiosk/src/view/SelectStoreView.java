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
		
		System.out.println("------ 매장 선택 ------");
		
		System.out.println("찾으시는 매장의 주소를 적어주세요 : ");
		String store_addr = sc.nextLine();

		if(sdao.checkStore(store_addr)==store_addr) {
			System.out.println(store_addr+"의 매장을 선택합니다.");
		}else {
			System.out.println("매장 선택 실패 / 다음에 다시 시도해주세요.");
		}
		
	}
}
