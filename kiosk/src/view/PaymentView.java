package view;

import java.util.Scanner;

import dao.ProductDAO;
import dao.Session;

//��ٱ��� ��
public class PaymentView {
	public static void main(String[] args) {
//		if(Session.get("loginUser") != null) {
			Scanner sc = new Scanner(System.in);
//			CustomerDTO loginUser = (CustomerDTO)Session.get("loginUser");
			ProductDAO pdao = new ProductDAO();
			
			System.out.println("========== ��ٱ��� ==========");
			while(true) {
//				if(Session.get("loginUser") == null) {
//					break;
//				} else {
//					loginUser = (CustomerDTO)Session.get("loginUser");
//				}
				
//				System.out.println(loginUser.username + "��(" + loginUser.userid + ") ��ٱ���");
				System.out.println("0. ó������ ���ư���\n1. ���� ����\n2. �޴� ����\n3. ���� ���"
						+ "\n4. ����Ʈ ���\n5. ���� ����\n6. ����� ����\n7. �����ϱ�");
				int choice = sc.nextInt();
				
				switch(choice) {
				case 0:
					//ó������ ���ư���
					new Index();
					break;
				case 1:
					//���� ����
					new ModifyProductView();
					break;
				case 2:
					//�޴� ����
					new DeleteProductView();
					break;
				case 3:
					//���� ���
					new UsingCouponView();
					break;
				case 4:
					//����Ʈ ���
					new UsingPointView();
					break;
				case 5:
					//���� ����
					new SelectStoreView();
					break;
				case 6:
					//����� ����
					new SelectLocationView();
					break;
				case 7:
					//�����ϱ�
					new PayView();
					break;
				default:
					System.out.println("�߸� �Է��߽��ϴ�. �ٽ� �Է����ּ���.");
				}
			}
//		}
	}
}
