package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
	Connection conn;
	PreparedStatement ps;
	
	public CustomerDAO() {
		conn = DBConnection.getConnection();
	}
	
	public int getCoupons(String cus_id) {
		String sql = "SELECT CUS_COUPONS FROM CUS_DB WHERE CUS_ID=?";
		
		ResultSet couponamount = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cus_id);
			
			couponamount = ps.executeQuery();
			return couponamount.getInt(1);
		} catch (SQLException e) {
		}
		return 0;
	}

	public boolean updateCoupons(String cus_id, int usecoupons) {
		int coupons = getCoupons(cus_id);
		
		//쿠폰의 개수가 0보다 작으면 사용할 쿠폰의 개수가 없으므로
		//false를 리턴해준다.
		if(coupons <= 0) {
			return false;
		//쿠폰의 개수가 0보다 크다면 사용할 쿠폰의 개수가 있다는 뜻
		}else {
			//coupons에 사용할 쿠폰 개수를 뺀 값을 저장
			coupons = coupons - usecoupons;
			
			//coupons 값을 CUS_COUPONS에 업데이트
			String sql = "UPDATE CUS_DB SET CUS_COUPONS=? WHERE CUS_ID=?";
			
			int result = 0;
			try {
				ps = conn.prepareStatement(sql);
				//고객의 쿠폰 컬럼 값에 coupons 넣어줌
				ps.setLong(1, coupons);
				ps.setString(2, cus_id);
				
				//업데이트 성공하면 1 증가
				result = ps.executeUpdate();
			} catch (SQLException e) {
			}
			return result == 1;
		}
	}

	
}
