package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import dto.MenuDTO;

public class MenuDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public MenuDAO() {
		conn = DBConnection.getConnection();
	}
	
	//메뉴 넘버 중복인지를 체크하는 메소드
		public boolean check_menu_num(int menu_num) {
			String sql = "SELECT * FROM MENU_DB WHERE MENU_NUM = ?";
			boolean result = false;
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, menu_num);
				rs = ps.executeQuery();
				
				result = !rs.next();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
			return result;
		}
		//메뉴 DB에 추가하는 메소드
		public boolean add(MenuDTO newMenu) {
			int result = 0;
			String sql = "INSERT INTO MENU_DB (MENU_NAME, MENU_PRICE, MENU_NUM, MENU_CATEGORY, MENU_ID, MENU_NEW)"
					+ "VALUES(?,?,?,?,?,?)";
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, newMenu.menu_name);
				ps.setInt(2, newMenu.menu_price);
				ps.setInt(3, newMenu.menu_num);
				ps.setString(4, newMenu.menu_category);
				ps.setString(5, newMenu.menu_id);
				ps.setInt(6, newMenu.menu_new);
				
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result == 1;
		}
		public boolean menu_delete(String menu_name) {
			//메뉴 이름이 menu_name인 행의 정보를 모두 삭제해라 라는 쿼리문 작성
			String sql = "DELETE FROM MENU_DB WHERE MENU_NAME = ?";
			int result = 0;
			try {
				//담아주고 
				ps = conn.prepareStatement(sql);
				//쿼리문의 ?에 menu_name을 입력
				ps.setString(1, menu_name);
				//결과는 삭제한 정보가 있다면 1, 없으면 0일 것이다.
				result = ps.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//그렇기 때문에 삭제에 성공했다면 result값은 참, 실패했다면 거짓이 리턴된다.
			return result == 1;
			
		}
		
		public boolean menu_mod(String menu_name, String mod_menu_name, int mod_menu_price) {
			//메뉴 이름이 menu_name인 행의 메뉴 이름과 메뉴 가격을 수정하는 쿼리문을 작성
			String sql = "UPDATE MENU_DB SET MENU_NAME = ?, MENU_PRICE = ? WHERE MENU_NAME = ?";
			int result = 0;
			try {
				//담아주고
				ps = conn.prepareStatement(sql);
				//쿼리문의 3개의 ? 중 첫 번째 ?에 새로운 메뉴이름을 입력
				ps.setString(1, mod_menu_name);
				//두 번째 ?에 새로운 가격 입력
				ps.setInt(2, mod_menu_price);
				//세 번째 ?에 기존 메뉴 이름을 입력
				ps.setString(3, menu_name);
				//result 값에 수정된 정보가 있다면 1이 담길 것이고, 수정된 정보가 없다면 0이 담길 것이다.
				result = ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//따라서 수정에 성공했다면 result값은 true, 실패했다면 false가 리턴된다.
			//또한 수정에 실패했다는 뜻은 기존 MENU_NAME 컬럼에 쿼리문의 조건에 만족하는 정보가 입력되지 않았음을 의미한다.
			//이는 즉, 입력한 기존 MENU_NAME 값이 잘못되었다는 것을 의미하므로 거짓이 리턴되었다면 
			//정확한 메뉴이름을 다시 입력해주어야 한다.
			return result == 1;
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

	public String[] getList(String cus_id) {
		String sql = "SELECT ORDER_NUMBER,MENU_NAME,ORDER_AMOUNT,MENU_PRICE FROM ORDER_DETAIL WHERE CUS_ID=?";
		String[] menulist = new String[4];
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cus_id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				menulist[0] = rs.getString("ORDER_NUMBER");
				menulist[1] = rs.getString("MENU_NAME");
				menulist[2] = rs.getString("ORDER_AMOUNT");
				menulist[3] = rs.getString("MENU_PRICE");
			}
		} catch (SQLException e) {
		}
		return menulist;
	}
}
