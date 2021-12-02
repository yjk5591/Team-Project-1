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
	
	//고객의 쿠폰 개수를 불러오는 메서드 --> updateCoupons에 사용됨
	public int getCoupons(String cus_id) {
		//고객의 쿠폰 개수를 불러오는 sql문
		String sql = "SELECT CUS_COUPONS FROM CUS_DB WHERE CUS_ID=?";
		
		//쿠폰 개수를 couponamount라는 이름으로 설정
		ResultSet couponamount = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cus_id);
			
			//쿠폰 개수를 불러와서 저장함
			couponamount = ps.executeQuery();
			//couponamount의 첫 번째 인덱스 값을 불러옴
			//--> 인덱스가 하나라 바로 쿠폰 개수를 불러오게 된다
			return couponamount.getInt(1);
		} catch (SQLException e) {
		}
		
		//?? 리턴 0을 하는게 맞는건가?
		return 0;
	}

	//쿠폰의 개수를 CUS_DB에 업데이트 하는 메서드
	public boolean updateCoupons(String cus_id, int usecoupons) {
		//getCoupons 메서드를 사용해서 고객의 쿠폰 개수를 coupons 변수에 저장
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
			//업데이트 성공했다면 true
			return result == 1;
		}
	}

	//사용하고 남은 포인트를 업데이틑 하는 메서드
	public boolean updatePoint(String cus_id, int usepoint) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
