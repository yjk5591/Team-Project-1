package view;

import java.util.Scanner;

import dao.ProductDAO;
import dao.Session;
import dto.CustomerDTO;

public class DeleteProductView {
	public DeleteProductView(String cus_id) {
		Scanner sc = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
		
		System.out.println("------ �޴� ���� ------");
		
		//���� �ø� ��ǰ ��� ����
//		System.out.println(pdao.getList(loginUser.userid));
		System.out.println("������ �޴� �̸� : ");
		String menu_name = sc.next();
		
		if(pdao.deleteProduct(cus_id, menu_name)) {
			System.out.println(menu_name+"�� ���������� �����Ǿ����ϴ�.");
		}else {
			System.out.println("�޴� ���� ���� / ������ �ٽ� �Է����ּ���.");
		}
	}
}
