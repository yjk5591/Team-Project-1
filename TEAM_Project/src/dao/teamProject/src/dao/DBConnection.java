package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DB와 Java를 연결하는 코드는 DB에 연결을 할 때마다 써주어야 한다.
//가독성이나 코드의 길이에서 불편함이 있기 때문에 따로 클래스와 메소드로 관리해준다.
public class DBConnection {
	// 다리를 매번 부쉈다 만드는것보다 static으로 계속 유지시켜 놓는것이 좋다.
	private static Connection conn;

	// 다리 지어서 돌려주는 메소드
	public static Connection getConnection() {
		// 싱글톤 패턴
		// 다리는 만들어진게 없을때만 만들어주는 코드를 수행하는것이 좋다.
		if (conn == null) {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "web";
			String password = "web";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
			} catch (SQLException sqle) {
			}
		}
		// 기존에 만들어진것이 있다면 담겨있는것 그대로 리턴
		// 없다면 위의 if문을 통과해서 만들어주고 리턴
		return conn;
	}
}
