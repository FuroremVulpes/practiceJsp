package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDatabase {

	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/management?autoReconnect=true&useSSL=false";
	private final String DB_USER = "mysql";
	private final String DB_PASS = "password";

	public Connection getConnection(){

		Connection conn = null;

		try{
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER ,DB_PASS);
		}catch(SQLException e) {
			System.out.println("ここだよ");
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			System.out.println("ここだよ");
			e.printStackTrace();
		}
		return conn;
	}
}
