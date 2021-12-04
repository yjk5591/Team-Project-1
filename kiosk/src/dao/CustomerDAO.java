package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public CustomerDAO() {
		conn = DBConnection.getConnection();
	}
	
	//고객의 쿠폰 개수를 불러오는 메서드 --> updateCoupons에 사용됨
	public int getCoupons(String cus_id) {
		//고객의 쿠폰 개수를 불러오는 sql문
		String sql = "SELECT CUS_COUPONS FROM CUS_DB WHERE CUS_ID=?";
		
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cus_id);
			
			//쿠폰 개수를 불러와서 저장함
			rs = ps.executeQuery();
			
			//rs의 CUS_COUPONS 컬럼의 값을 불러와 result에 저장해준다.
			result = rs.getInt("CUS_COUPONS");
		} catch (SQLException e) {
		}
		//보유 쿠폰 개수를 리턴해준다.
		return result;		
	}

	//쿠폰의 개수를 CUS_DB에 업데이트 하는 메서드
	public boolean updateCoupons(String cus_id, int usecoupons) {
		//getCoupons 메서드를 사용해서 고객의 쿠폰 개수를 coupons 변수에 저장
		int coupons = getCoupons(cus_id);
		
		//쿠폰의 개수가 0 이하면 사용할 수 있는 쿠폰의 개수가 없으므로
		//false를 리턴해준다.
		if(coupons <= 0) {
			return false;
		//쿠폰의 개수가 0보다 크다면 사용할 수 있는 쿠폰의 개수가 있다는 뜻
		}else {
			//보유 중인 쿠폰 개수보다 사용하려는 쿠폰 개수가 많다면 false 리턴
			if(coupons < usecoupons) {
				return false;
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
					
					//쿠폰 사용 한 값을 뺀 나머지 총액 업데이트
					int total_price = getTotal(cus_id);
					total_price = total_price - (usecoupons * 1000);
					updateTotal(cus_id, total_price);
				} catch (SQLException e) {
				}
				//업데이트 성공했다면 true
				return result == 1;
			}
		}
	}
	
	//고객의 보유 포인트를 불러오는 메서드 --> updatePoint에 사용됨
	public int getPoint(String cus_id) {
		//고객의 보유 포인트를 불러오는 sql문
		String sql = "SELECT CUS_POINT FROM CUS_DB WHERE CUS_ID=?";
		
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cus_id);
			
			//보유 포인트를 불러와서 저장함
			rs = ps.executeQuery();
			
			//rs의 CUS_POINT 컬럼의 값을 불러와 result에 저장해준다.
			result = rs.getInt("CUS_POINT");
		} catch (SQLException e) {
		}
		//보유 포인트를 리턴해준다.
		return result;		
	}

	//사용하고 남은 포인트를 업데이틑 하는 메서드
	public boolean updatePoint(String cus_id, int usepoint) {
		//getPoint 메서드를 사용해서 고객의 보유 포인트를 point 변수에 저장
		int point = getCoupons(cus_id);
		
		//보유 포인트 양이 0 이하면 사용할 수 있는 포인트가 없으므로
		//false를 리턴해준다.
		if(point <= 0) {
			return false;
		//포인트가 0보다 많다면 사용할 수 있는 포인트가 있다는 뜻
		}else {
			//보유 중인 포인트보다 사용하려는 포인트가 많다면 false 리턴
			if(point < usepoint) {
				return false;
			}else {
				//point에 사용할 포인트 양을 뺀 값을 저장
				point = point - usepoint;
				
				//point 값을 CUS_POINT에 업데이트
				String sql = "UPDATE CUS_DB SET CUS_POINT=? WHERE CUS_ID=?";
				
				int result = 0;
				try {
					ps = conn.prepareStatement(sql);
					//고객의 쿠폰 컬럼 값에 point 넣어줌
					ps.setLong(1, point);
					ps.setString(2, cus_id);
					
					//업데이트 성공하면 1 증가
					result = ps.executeUpdate();
					
					//포인트 사용 한 값을 뺀 나머지 총액 업데이트
					int total_price = getTotal(cus_id);
					total_price = total_price - usepoint;
					updateTotal(cus_id, total_price);
				} catch (SQLException e) {
				}
				//업데이트 성공했다면 true
				return result == 1;
			}
		}
	}

	//포인트 적립
	public void establishPoint(String cus_id) {
		int recent_point = getPoint(cus_id);
		int total = getTotal(cus_id);
		
		recent_point = (int) (recent_point + (total * 0.05));
	
		updatePoint(cus_id, recent_point);
	}

	public String selectLocation(String cus_id, int choice) {
		String location;
		
		if(choice == 1) {
			String sql = "SELECT CUS_ADDR FROM CUS_DB WHERE CUD_ID=?";
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, cus_id);
				
				rs = ps.executeQuery();
				
				location = rs.getString("CUS_ADDR");

				return location;
			} catch (SQLException e) {
			}
		}
		return "배송지 선택 실패 / 다음에 다시 시도해주세요.";
	}
	
	public String selectNewLocation(String cus_id, int choice, String newlocation) {
		if(choice == 2) {
			String sql = "UPDATE CUS_DB SET CUD_ADDR2=? WHERE CUS_ID=?";
			int result = 0;
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, newlocation);
				ps.setString(2, cus_id);
				
				result = ps.executeUpdate();
				
				return newlocation;
			} catch (SQLException e) {
			}
		}
		return "배송지 선택 실패 / 다음에 다시 시도해주세요.";
	}
	
	public int getTotal(String cus_id) {
		String sql = "SELECT ORDER_PRICE FROM ORDER_VIEW WHERE CUS_ID=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cus_id);
			
			rs = ps.executeQuery();
			
			 int total = rs.getInt("ORDER_PRICE");
			 
			 return total;
		} catch (SQLException e) {
		}
		return (Integer) null;
	}

	public int updateTotal(String cus_id, int total) {
		String sql = "UPDATE ORDER_VIEW SET ORDER_PRICE=? WHERE CUS_ID=?";
		
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, total);
			ps.setString(2, cus_id);
			
			result = ps.executeUpdate();
			
			return total;
		} catch (SQLException e) {
		}
		return (Integer) null;
	}
}
