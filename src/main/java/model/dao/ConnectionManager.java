package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
<<<<<<< HEAD
	private final static String URL = "jdbc:mysql://localhost:3306/task_db?useSSL=false";
	private final static String USER = "root";
	private final static String PASSWORD = "root";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		//jdbcドライバの読み込み
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
=======

	//DB接続用のurl
	private final static String URL = "jdbc:mysql://localhost:3306/task_db";
	private final static String USER = "root";
	private final static String PASSWORD = "root";

	//メソッドの定義
	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		//JDBCの読み取り
		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection(URL, USER, PASSWORD);

	}

>>>>>>> 3052bb8b5f3206518911ac56fb1c072fdd4160f3
}
