package edu.nju.educationSystem.server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static ConnectionFactory self;
	
	private Connection mConnection;
	
	private ConnectionFactory(){}
	
	public static ConnectionFactory getInstance() {
		if (self == null) {
			self = new ConnectionFactory();
		}
		return self;
	}
	
	/* package */Connection getConnection(){
		if(mConnection == null){
			createConnector();
		}
		return mConnection;
	}
	
	private void createConnector() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/educationsystem?useUnicode=true&characterEncoding=utf-8";
		String user = "root";
		String password = "root";

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
				mConnection = conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void close(){
		try {
			mConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
