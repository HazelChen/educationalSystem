package emsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseHelper {
	static //数据库连接服务
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:A";
	//数据库的用户名
	private static String user = "test";
	//数据库的用户口令
	private static String password = "test";
	private static Connection c;
	
	public  static Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			 c= DriverManager.getConnection(dbUrl, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}
