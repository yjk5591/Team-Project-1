package menu;

import java.util.Scanner;

public class Menu_manage {
	public Menu_manage() {
		System.out.println("�޴����� �ý���");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. �޴��߰�\n2. �޴�����\n3. �޴�����");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				new Menu_insert();
			} else if(choice == 2) {
				new Menu_update();
			} else if(choice == 3) {
				new Menu_delete();
			} else
				System.out.println("�߸� �Է��ϼ̽��ϴ�!\n�ٽ� �Է����ּ���");
		}
	}
}
