package emsystem.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import emsystem.data.Choice;

public class Choice_logic {
	conn_mysql cm = new conn_mysql();
	Statement st;
	
	public ArrayList<Choice> getChoiceBySno(String sno){
		ArrayList<Choice> list = new ArrayList<Choice>();
		Connection conn = cm.getConnection();
		
		Choice choice;
		String sql = "SELECT * FROM choicec WHERE Sno = "+sno;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				choice = new Choice(rs.getString("Cno"), rs.getString("Sno"), rs.getInt("Grd"));
				list.add(choice);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Choice> getChoiceByCno(String cno){
		ArrayList<Choice> list = new ArrayList<Choice>();
		Connection conn = cm.getConnection();
		Choice choice;
		String sql = "SELECT * FROM choicec WHERE Cno = "+cno;
		try {
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				choice = new Choice(rs.getString("Cno"), rs.getString("Sno"), rs.getInt("Grd"));
				list.add(choice);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean addChoice(String cno,String sno){//增加一条选课
		Connection conn = cm.getConnection();
		String sql = "INSERT INTO choicec(Cno,Sno,Grd) VALUES('"+cno+"','"+sno+"',"+0+")";
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteChoice(String cno,String sno){
		boolean isdelete = false;
		Connection conn = cm.getConnection();
		String sql = "DELETE from choicec WHERE Cno='"+cno+"' and Sno='"+sno+"'";
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
			isdelete = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isdelete;
	}

}
