package view;

import java.util.Scanner;

import dao.ProductDAO;
import dao.Session;

public class ModifyProductView {
	public ModifyProductView() {
		Scanner sc = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
//		CustomerDTO loginUser = (CustomerDTO)Session.get("loginUser");
		
		System.out.println("------ ���� ���� ------");
		
		//���� �ø� ��ǰ ��� ����
//		System.out.println(pdao.getList(loginUser.userid));
		int col = 1;
		System.out.println("������ ��ǰ �̸� : ");
		String menu_name = sc.next();
		System.out.println("���� : ");
		String newData = sc.next();
		
		if(pdao.modifyAmount(menu_name, col, newData)) {
			System.out.println(menu_name+"�� ������ ���������� �����Ǿ����ϴ�.");
		}else {
			System.out.println("��ǰ ���� ���� ���� / ������ �ٽ� �õ����ּ���.");
		}
	}
}