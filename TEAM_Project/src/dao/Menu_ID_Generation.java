package dao;

import java.util.Random;
import java.util.UUID;


public class Menu_ID_Generation {
	//메뉴 아이디 생성 메소드
	public String getMenu_ID() {
		String menu_id = UUID.randomUUID().toString();
		
		menu_id = menu_id.replace("-", "");
		
		return menu_id;
	}
	//메뉴 넘버 생성 메소드 (랜덤으로 뽑아내지만 중복으로 뽑힐 가능성이 있음)
	public int getMenu_NUM() {
		Random random = new Random();
		int menu_num = random.nextInt(10000);
		
		
		return menu_num;
	
	}
	
}
