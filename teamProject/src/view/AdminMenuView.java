package view;

import java.util.Scanner;

import dao.MenuDAO;

public class AdminMenuView {
	public AdminMenuView() {
		Scanner sc = new Scanner(System.in);
		MenuDAO mdao = new MenuDAO();
		int choice = 0;
		while(true) {
			System.out.println("���Ͻô� �׸��� ����ּ���.\n1. �޴� �߰�\n2. �޴� ����\n3. �޴� ����\n4. ������");
			choice = sc.nextInt();
			if(choice == 1) {
				new MenuAdd();
			}else if(choice == 2) {
				new MenuMod();
			}else if(choice == 3) {
				new MenuDelete();
			}else if(choice == 4) {
				System.out.println("�޴� �߰�/����/���� �׸񿡼� �����ϴ�.");
				break;
			}
		}
	}
}