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
            System.out.println("PW 확인 :");
            String admin_pw_re = sc.next();
            if(admin_pw.equals(admin_pw_re)) {
               break;
            }else {
               System.out.println("비밀번호를  확인해주세요.");
            }
         }
      System.out.println("이름 : ");
      String admin_name = sc.next();
      System.out.println("나이 : ");
      int admin_age = sc.nextInt();
      System.out.println("핸드폰 번호 :");
      String admin_phonenum = sc.next();
      
      UUIDgeneration uuid = new UUIDgeneration();
      String admin_number = uuid.getUUID();
      
      
      AdminDTO newAdmin = new AdminDTO(admin_id, admin_pw, admin_name, admin_number, admin_phonenum);
      if(adao.join(newAdmin)) {
         System.out.println("회원가입 성공!");
         System.out.println(admin_name + "님 회원가입을 환영합니다!!");
      }else {
         System.out.println("회원가입에 실패했습니다. 다시 시도해주세요.");
      }
   }else {
      System.out.println("중복된 아이디가 있습니다.");
   }
      
   }
   
}