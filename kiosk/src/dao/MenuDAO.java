package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MenuDAO {
	Connection conn;
	PreparedStatement ps;
	
	public MenuDAO() {
		conn = DBConnection.getConnection();
	}
	
	//장바구니에 있는 메뉴 수량 변경하는 메서드
	//메뉴 이름은 중복이 안  될거 같아서 메뉴 이름이랑 새로 적을 수량 변수만 담아온다
	public boolean modifyAmount(String cus_id, String menu_name, String newData) {
		String sql = "UPDATE ORDER_DETAIL SET ORDER_AMOUNT=? WHERE MENU_NAME=? AND CUS_ID=?";
		
		//변한게 없으면 0 그대로일 것
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			//?에 값을 하나씩 넣어준다
			ps.setLong(1, Integer.parseInt(newData));
			ps.setString(2, menu_name);
			ps.setString(3, cus_id);
			
			
			//변한 것이 있다면 값이 증가했을 것
			result = ps.executeUpdate();
		} catch (SQLException e) {
		}
		//result가 1이면 값이 변했다는 뜻이므로 true가 반환되게 된다.
		//0이면 값이 그대로라는 뜻으로 false가 반환
		return result == 1;
	}

	//장바구니에 있는 메뉴 삭제하는 메서드
	//메뉴 이름만 불러와서 delete 해주면 됨
	public boolean deleteProduct(String cus_id, String menu_name) {
		String sql = "DELETE FROM ORDER_DETAIL WHERE MENU_NAME=? AND CUS_ID=?";
		//초기값을 0으로 준다.
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			//?에 메뉴 이름을 넣어줘서 메뉴 이름이 같으면 주문상세내역에서 삭제되게 함
			ps.setString(1, menu_name);
			ps.setString(2, cus_id);
			
			//변한 값이 있다면 1이 됐을 것이다
			result = ps.executeUpdate();
		} catch (SQLException e) {
		}
		//1이면 true / 0 그대로면 false
		return result == 1;
	}
}
