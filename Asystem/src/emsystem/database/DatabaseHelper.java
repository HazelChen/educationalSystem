package emsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseHelper {
	static //���ݿ����ӷ���
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:A";
	//���ݿ���û���
	private static String user = "test";
	//���ݿ���û�����
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
