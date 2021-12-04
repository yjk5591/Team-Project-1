package view;

import java.util.Scanner;

import dao.CustomerDAO;
import dao.ProductDAO;
import dao.Session;
import dto.CustomerDTO;

public class UsingPointView {
	public UsingPointView(String cus_id) {
		Scanner sc = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
		CustomerDAO udao = new CustomerDAO();
		
		System.out.println("------ ����Ʈ ��� ------");
		
		//���� ����Ʈ�� ����
		System.out.println("����� ����Ʈ �ݾ� : ");
		int usepoint = sc.nextInt();
		
		if(udao.updatePoint(cus_id, usepoint)) {
			System.out.println(usepoint+" ����Ʈ�� ���Ǿ����ϴ�.");
		}else {
			System.out.println("����Ʈ ��� ���� / ������ �ٽ� �õ����ּ���.");
		}
		
		
	}
}
