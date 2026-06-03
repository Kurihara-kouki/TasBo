package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private final static String URL = "jdbc:mysql://localhost:3306/task_db?useSSL=false";
	private final static String USER = "root";
	private final static String PASSWORD = "root";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		//jdbcドライバの読み込み
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
}
