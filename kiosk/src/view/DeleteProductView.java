package view;

import java.util.Scanner;

import dao.ProductDAO;

public class DeleteProductView {
	public DeleteProductView() {
		Scanner sc = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
//		CustomerDTO loginUser = (CustomerDTO)Session.get("loginUser");
		
		System.out.println("------ �޴� ���� ------");
		
		//���� �ø� ��ǰ ��� ����
//		System.out.println(pdao.getList(loginUser.userid));
		System.out.println("������ �޴� �̸� : ");
		String menu_name = sc.next();
		
		if(pdao.deleteProduct(menu_name)) {
			System.out.println(menu_name+"�� ���������� �����Ǿ����ϴ�.");
		}else {
			System.out.println("�޴� ���� ���� / ������ �ٽ� �Է����ּ���.");
		}
	}
}
