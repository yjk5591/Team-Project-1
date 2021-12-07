package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.CUS_DTO;

public class CUS_DAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	// UserDAO 클래스의 객체는 DB에 접근하기 위해서 생성해서 사용한다.
	public CUS_DAO() {
		// 생성되었다면 무조건 다리 받아서 conn에 넣어주기
		conn = DBConnection.getConnection();
	}

	public boolean join(CUS_DTO newCustomer) {
		// 객체에 담긴 비밀번호 암호화
		newCustomer.cusPW = encrypt(newCustomer.cusPW);
		int result = 0;
		// 쿼리문 내부에 가변하는 값들이 있기 때문에 그걸 문자열 연결을 통해서 작성해 주면
		// 너무 코드가 복잡해진다. 값들이 들어갈 자리에 ? 를 이용해서
		// sql문을 미완성으로 놔둔다.
		String sql = "INSERT INTO UMS_USER VALUES(?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);

			// 전달해준 sql문은 완성되지 않은 쿼리문이므로 ? 자리에 들어갈 값들을
			// 하나씩 세팅해 주어야 한다.
			ps.setString(1, newCustomer.cusID);// 첫번째 물음표에 'apple' 세팅
			ps.setString(2, newCustomer.cusID);// ..
			ps.setString(3, newCustomer.cusName);
			ps.setString(5, newCustomer.cusPhone);
			ps.setString(6, newCustomer.cusAddr);

			// INSERT, UPDATE, DELETE : executeUpdate() - 수정된 행 수 리턴
			// SELECT : executeQuery() - 검색된 결과 테이블(rs)을 리턴
			result = ps.executeUpdate();
		} catch (SQLException e) {
		}
		// 가입이 성공했다면 1줄이 추가(테이블의 수정)되었으므로 1개가 result에 담겨있다면
		// 가입 성공이라는 뜻
		return result == 1;
	}

	public boolean checkId(String userid) {
//		String sql = "SELECT COUNT(*) FROM UMS_USER WHERE USERID=?";
		String sql = "SELECT * FROM UMS_USER WHERE USERID=?";
//		int result = 1;
		boolean result = false;
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, cusID);
			rs = ps.executeQuery();

//			if(rs.next()) {
//				result = rs.getInt(1);
//			}
			// USERID가 같은 행을 검색하는것이 쿼리문의 수행 결과이다.
			// 검색이 되었다면 중복되는 아이디가 이미 존재한다는 뜻
			// 검색이 안되었다면 rs.next()로 화살표를 옮길 수 없기 때문에
			// rs.next()의 결과는 false가 나온다. 하지만 중복체크는
			// 통과한것이기 때문에 앞에 !를 이용해서 결과를 true로 바꾸어준다.
			result = !rs.next();

		} catch (SQLException e) {
		}
//		return result == 0;
		return result;
	}

	public boolean login(String cusID, String cusPW) {
		String sql = "SELECT * FROM UMS_USER WHERE USERID=? AND USERPW=?";
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, cusID);
			// DB에 암호화된 비밀번호가 담겨있으므로 검색할 때에도 암호화해서 검색
			ps.setString(2, encrypt(cusPW));

			rs = ps.executeQuery();

			if (rs.next()) {
				// rs.next()가 있다는 뜻은 검색 성공(로그인 성공)이라는 뜻이고
				// 검색된 결과로 세션에 세팅을 해주어야 한다.
				// 검색된 행에서 각 열의 값들을 가져와서 객체로 포장 후 세팅
				CUS_DTO loginUser = new CUS_DTO(rs.getString("USERID"), decrypt(rs.getString("USERPW")),
						rs.getString("USERNAME"), rs.getString("USERPHONE"), rs.getString("USERADDR"));
				// 위에서 만들어진 객체로 세션에 세팅
				Session.put("loginUser", loginUser);
				return true;
			}
		} catch (SQLException e) {
		}
		// 위의 return true를 못만났다면 무조건 로그인 실패
		return false;
	}

	public String encrypt(String cusPW) {
		String result = "";
		for (int i = 0; i < cusPW.length(); i++) {
			result += (char) (cusPW.charAt(i) + 4);
		}
		return result;
	}

	public String decrypt(String en_pw) {
		String result = "";
		for (int i = 0; i < en_pw.length(); i++) {
			result += (char) (en_pw.charAt(i) - 4);
		}
		return result;
	}

	public boolean modifyUser(String cusID, int col, String newData) {
		// 1 : USERPW / 2 : USERPHONE / 3 : USERADDR
		String[] cols = { "", "USERPW", "USERPHONE", "USERADDR" };
		String sql = "UPDATE UMS_USER SET " + cols[col] + " = ? WHERE USERID=?";

		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newData);
			ps.setString(2, cusID);

			result = ps.executeUpdate();
		} catch (SQLException e) {
		}
		return result == 1;
	}
}
