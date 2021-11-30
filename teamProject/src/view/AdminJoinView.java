package view;

import java.util.Scanner;

import dao.AdminDAO;
import dto.AdminDTO;
import dao.UUIDgeneration;

public class AdminJoinView {
   public AdminJoinView() {
      Scanner sc = new Scanner(System.in);
      
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
            if(admin_pw.equals(admin_pw_re)) {
               break;
            }else {
               System.out.println("��й�ȣ��  Ȯ�����ּ���.");
            }
         }
      System.out.println("�̸� : ");
      String admin_name = sc.next();
      System.out.println("���� : ");
      int admin_age = sc.nextInt();
      System.out.println("�ڵ��� ��ȣ :");
      String admin_phonenum = sc.next();
      
      UUIDgeneration uuid = new UUIDgeneration();
      String admin_number = uuid.getUUID();
      
      
      AdminDTO newAdmin = new AdminDTO(admin_id, admin_pw, admin_name, admin_number, admin_phonenum);
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