package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	 private static Connection conn;
	   public static Connection getConnection() {
	      if(conn==null) {
	         String url = "jdbc:oracle:thin:@localhost:1521:XE";
	         String user = "web";
	         String password = "web";
	         try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            conn = DriverManager.getConnection(url, user, password);

	            System.out.println("Connection Success!");
	         } catch (ClassNotFoundException e) {
	            System.out.println("Fail to ready Driver " + e);
	         } catch (SQLException sqle) {
	            System.out.println("Fail connection " + sqle);
	         }
	      }
	      return conn;
	   }
	}