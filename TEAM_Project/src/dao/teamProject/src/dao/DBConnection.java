package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DB�� Java�� �����ϴ� �ڵ�� DB�� ������ �� ������ ���־�� �Ѵ�.
//�������̳� �ڵ��� ���̿��� �������� �ֱ� ������ ���� Ŭ������ �޼ҵ�� �������ش�.
public class DBConnection {
	// �ٸ��� �Ź� �ν��� ����°ͺ��� static���� ��� �������� ���°��� ����.
	private static Connection conn;

	// �ٸ� ��� �����ִ� �޼ҵ�
	public static Connection getConnection() {
		// �̱��� ����
		// �ٸ��� ��������� �������� ������ִ� �ڵ带 �����ϴ°��� ����.
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
		// ������ ����������� �ִٸ� ����ִ°� �״�� ����
		// ���ٸ� ���� if���� ����ؼ� ������ְ� ����
		return conn;
	}
}
