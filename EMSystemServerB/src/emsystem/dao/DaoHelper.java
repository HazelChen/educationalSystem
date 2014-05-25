package emsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoHelper {

	public Connection getConnection() {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=BԺϵDatabase";
		String userName = "sa";
		String userPwd = "361549286";
		Connection dbConn = null;

		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("�������ݿ�ɹ���");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("SQL Server����ʧ�ܣ�");
		}

		return dbConn;
	}

	public void closeConnection(Connection con) {
		try {
			con.close();
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
