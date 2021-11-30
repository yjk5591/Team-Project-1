package view;

import java.util.Scanner;

import dao.AdminDAO;

public class AdminLoginView {
	public AdminLoginView() {
		Scanner sc = new Scanner(System.in);
		AdminDAO adao = new AdminDAO();		// DB 접근이 필요할 경우 선언
		System.out.println("아이디 : ");
		String userid = sc.next();
		System.out.println("비밀번호 : ");
		String userpw = sc.next();
	}
}