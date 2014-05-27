package emsystem.database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Account_logic {
	conn_mysql cm = new conn_mysql();
	Statement st;
	
	public boolean isLogin(String acc,String passwd){
		boolean islogin = false;
		if(queryAccount(acc).equals(passwd)){
			islogin = true;
		}
		return islogin;
	}
	
	private String queryAccount(String acc){//根据account来查询密码
			Connection conn = cm.getConnection();
			String ps = null;
			String sql = "SELECT * from accountc WHERE acc = "+acc;
			try {
				st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
					ps = rs.getString("passwd");
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ps;
	}

}
