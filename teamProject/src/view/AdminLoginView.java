package view;

import java.util.Scanner;

import dao.AdminDAO;

public class AdminLoginView {
	public AdminLoginView() {
		Scanner sc = new Scanner(System.in);
		AdminDAO adao = new AdminDAO();		// DB ������ �ʿ��� ��� ����
		System.out.println("���̵� : ");
		String userid = sc.next();
		System.out.println("��й�ȣ : ");
		String userpw = sc.next();
	}
}