package view;

import java.util.Scanner;

import dao.AdminDAO;
import dto.AdminDTO;




public class AdminJoinView {
	

	public AdminJoinView() {
		Scanner sc = new Scanner(System.in);
		//���� ���ԵǴ� "�������� ������"�� �����ͺ��̽��� �����ؾ� �ϹǷ�
		//�����ͺ��̽��� �����ϱ� ����(����� ������ ����) DAO�� �ʿ��ϰ�
		//ȸ�������� �����ؾ� �ϱ� ������ AdminDAO ��ü�� �ʿ��ϴ�.
		AdminDAO adao = new AdminDAO();
		System.out.println("ID : ");
		String admin_id = sc.next();
		String admin_pw = "";
		if(adao.checkId(admin_id)) {
			while(true) {
					System.out.println("PW :");
					admin_pw = sc.next();
					System.out.println("PW Ȯ�� :");
					String admin_pw_re = sc.next();
					//��й�ȣ �˻�� ���� �����ͺ��̽��� ��ġ�� �ʰ� ��ܿ��� �ذ�
					if(admin_pw.equals(admin_pw_re)) {
						break;
					}else {
						System.out.println("��й�ȣ��  Ȯ�����ּ���.");
					}
				}		
			System.out.println("�̸� : ");
			String admin_name = sc.next();
			System.out.println("������ ��ȣ : ");
			String admin_num = sc.next();
			System.out.println("�ڵ��� ��ȣ : ");
			String admin_phone = sc.next();
			System.out.println("���� ID : ");
			String admin_store_id = sc.next();
			while(true) {							
				if(adao.checkStore(admin_store_id)) {
					break;
				
				}else {
					System.out.println("�ߺ��� ����ID�� �ֽ��ϴ�.");
				}
			}
			//DB�� ����� �������� ������ �Է¹޾Ҵ�.
			//AdminDTO ��ü�� �����Ͽ� �� ���� �Ѱ��־� DB�� �̵���Ų��.
		
		AdminDTO newAdmin = new AdminDTO(admin_id, admin_pw, admin_name, admin_num, admin_phone, admin_store_id);
		if(adao.join(newAdmin)) {
			System.out.println("ȸ������ ����!");
			System.out.println(admin_name + "�� ȸ�������� ȯ���մϴ�!!");
		}else {
			System.out.println("ȸ�����Կ� �����߽��ϴ�. �ٽ� �õ����ּ���.");
		}
	}else {
		System.out.println("�ߺ��� ���̵� �ֽ��ϴ�.");
	}
		
	}
	
}
