package emsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoHelper {
	private static DaoHelper daoHelper;
	private Connection connection;
	
	private DaoHelper(){
		createConnection();
	}
	
	public static DaoHelper getInstance() {
		if (daoHelper == null) {
			daoHelper = new DaoHelper();
		}
		return daoHelper;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	private void createConnection() {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=educationSystemB";
		String userName = "sa";
		String userPwd = "root";

		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("连接数据库成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("SQL Server连接失败！");
		}
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closePreparedStatement(PreparedStatement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeResult(ResultSet result) {
		try {
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
