package view;

import java.util.Scanner;

import dao.ProductDAO;
import dao.Session;

public class ModifyProductView {
	public ModifyProductView() {
		Scanner sc = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
//		UserDTO loginUser = (UserDTO)Session.get("loginUser");
		
		System.out.println("------ ���� ���� ------");
		
		//���� �ø� ��ǰ ��� ����
//		System.out.println(pdao.getList(loginUser.userid));
		System.out.println("������ ��ǰ �̸� : ");
		String menuname = sc.next();
		System.out.println("���� : ");
		int newData = sc.nextInt();
		
			
		}
	}