package view;

import java.util.Scanner;

import view.AdminJoinView;

public class Index {
	public static void main(String[] args) {
		System.out.println("�ڡڡڡڹ���� Ű����ũ ���� ȭ��ڡڡڡ�");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("0. ������\n1. ȸ������\n2. �α���\n3. ����������\n4. ���� ã��"
					+ "\n5. �޴�\n6. ��ٱ���");
			int choice = sc.nextInt();
			
			if(choice == 0) {
				//������
				System.out.println("�ȳ��� ������.");
				break;
			} else if(choice == 1) {
				//ȸ������
				System.out.println("ȸ�������� �����մϴ�.");
				while(true) {
					System.out.println("1. ������ ȸ������");
					System.out.println("2. �� ȸ������");
					int ch = sc.nextInt();
					if(ch == 1) {
						System.out.println("������ ȸ������");
						new AdminJoinView();
					} else if(ch == 2) {
						System.out.println("�� ȸ������");
					} else {
						System.out.println("�߸� �Է��߽��ϴ�. �ٽ� �Է����ּ���.");
					}
				}
			} else if(choice == 2) {
				//�α���
			} else if(choice == 3) {
				//����������
			} else if(choice == 4) {
				//���� ã��
			} else if(choice == 5) {
				//�޴�
			} else if(choice == 6) {
				//��ٱ���
				new PaymentView();
			} else {
				//�߸� �Է� ��
				System.out.println("�߸� �Է��߽��ϴ�. ó������ ���ư��ϴ�.");
			}
		}
	}
}