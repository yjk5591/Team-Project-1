package view;

import java.util.Scanner;

import dao.ProductDAO;
import dao.Session;

//��ٱ��� ��
public class PaymentView {
	public static void main(String[] args) {
		if(Session.get("loginUser") != null) {
			Scanner sc = new Scanner(System.in);
//			UserDTO loginUser = (UserDTO)Session.get("loginUser");
			ProductDAO pdao = new ProductDAO();
			
			System.out.println("========== ��ٱ��� ==========");
			while(true) {
				if(Session.get("loginUser") == null) {
					break;
				} else {
//					loginUser = (UserDTO)Session.get("loginUser");
				}
				
//				System.out.println(loginUser.username + "��(" + loginUser.userid + ") ��ٱ���");
				System.out.println("0. ó������ ���ư���\n1. ���� ����\n2. �޴� ����\n3. ���� ���\n4. ����Ʈ ���"
						+ "\n5. ���� ����\n6. ����� ����");
				int choice = sc.nextInt();
				
				switch(choice) {
				case 0:
					//ó������ ���ư���
					break;
				case 1:
					//���� ����
					new ModifyProductView();
					break;
				case 2:
					//�޴� ����
					break;
				case 3:
					//���� ���
					break;
				case 4:
					//����Ʈ ���
					break;
				case 5:
					//���� ����
					break;
				case 6:
					//����� ����
					break;
				default:
					System.out.println("�߸� �Է��߽��ϴ�. �ٽ� �Է����ּ���.");
				}
			}
		}
	}
}
