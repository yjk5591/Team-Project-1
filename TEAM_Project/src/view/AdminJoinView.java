package view;

import java.util.Scanner;

import dao.AdminDAO;
import dto.AdminDTO;




public class AdminJoinView {
	

	public AdminJoinView() {
		Scanner sc = new Scanner(System.in);
		//새로 가입되는 "관리자의 정보들"을 데이터베이스에 저장해야 하므로
		//데이터베이스에 접근하기 위한(기능을 구현해 놓은) DAO가 필요하고
		//회원정보에 접근해야 하기 때문에 AdminDAO 객체가 필요하다.
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
					//비밀번호 검사는 따로 데이터베이스를 거치지 않고 뷰단에서 해결
					if(admin_pw.equals(admin_pw_re)) {
						break;
					}else {
						System.out.println("비밀번호를  확인해주세요.");
					}
				}		
			System.out.println("이름 : ");
			String admin_name = sc.next();
			System.out.println("관리자 번호 : ");
			String admin_num = sc.next();
			System.out.println("핸드폰 번호 : ");
			String admin_phone = sc.next();
			System.out.println("매장 ID : ");
			String admin_store_id = sc.next();
			while(true) {							
				if(adao.checkStore(admin_store_id)) {
					break;
				
				}else {
					System.out.println("중복된 매장ID가 있습니다.");
				}
			}
			//DB에 저장될 관리자의 정보를 입력받았다.
			//AdminDTO 객체를 생성하여 한 번에 넘겨주어 DB로 이동시킨다.
		
		AdminDTO newAdmin = new AdminDTO(admin_id, admin_pw, admin_name, admin_num, admin_phone, admin_store_id);
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
