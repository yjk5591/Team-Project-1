package view;

import java.util.Scanner;

import dao.ProductDAO;
import dao.Session;
import dto.CustomerDTO;

public class ModifyProductView {
	public ModifyProductView(String cus_id) {
		Scanner sc = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
		
		System.out.println("------ ���� ���� ------");
		
		//���� �ø� ��ǰ ��� ����
//		System.out.println(pdao.getList(loginUser.userid));
		System.out.println("������ ��ǰ �̸� : ");
		String menu_name = sc.next();
		System.out.println("���� : ");
		String newData = sc.next();
		
		if(pdao.modifyAmount(cus_id, menu_name, newData)) {
			System.out.println(menu_name+"�� ������ ���������� �����Ǿ����ϴ�.");
		}else {
			System.out.println("��ǰ ���� ���� ���� / ������ �ٽ� �õ����ּ���.");
		}
	}
}