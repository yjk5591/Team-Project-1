package view;

import java.util.Scanner;

import dao.AdminDAO;
import dao.Session;

public class AdminLoginView {
	public AdminLoginView() {
		Scanner sc = new Scanner(System.in);
		AdminDAO adao = new AdminDAO();
		System.out.println("ID : ");
		String admin_id = sc.next();
		System.out.println("PW : ");
		String admin_pw = sc.next();
		if(adao.login(admin_id,admin_pw)) {
			System.out.println(admin_id + "님 어서오세요!");
			System.out.println(Session.get("loginAdmin"));
		}else {
			System.out.println("로그인 실패");
		}
	}	
}