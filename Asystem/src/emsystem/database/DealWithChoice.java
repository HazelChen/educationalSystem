package emsystem.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import emsystem.data.Choice;
import emsystem.data.Student;

public class DealWithChoice {

	Connection c;
	Statement s;
	ResultSet rs;
	
	public ArrayList<Choice> getAllChoice(){
		ArrayList<Choice> list=new ArrayList<Choice>();
		c=DatabaseHelper.getConnection();
		String sql="select * from choice";
		try {
			s=c.createStatement();
			rs=s.executeQuery(sql);
			while(rs.next()){
				String studentId=rs.getString("ѧ��");
				String courseId=rs.getString("�γ̱��");
				int score=Integer.parseInt(rs.getString("�÷�"));
				Choice choice=new Choice(studentId, courseId, score);
				list.add(choice);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean insert(Choice choice){
		boolean b=false;
		c=DatabaseHelper.getConnection();
		String sql="insert into choice(�γ̱��,ѧ��,�÷�) values('"+choice.getCourseId()+"','"
				+choice.getStudentId()+"',"+choice.getScore()+");";
		try {
			s=c.createStatement();
			b=s.execute(sql);
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public boolean delete(String cid,String sid){
		boolean b=false;
		c=DatabaseHelper.getConnection();
		String sql="delete from choice where ѧ��="+sid +"and �γ̱��="+cid;
		try {
			s=c.createStatement();
			b=s.execute(sql);
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	public Choice search(String cid,String sid){
		c=DatabaseHelper.getConnection();
		String sql="select * from choice where ѧ��="+sid+" and �γ̱��="+cid;
		Choice choice = null;
		try {
			s=c.createStatement();
			rs=s.executeQuery(sql);
			while(rs.next()){
				String studentId=rs.getString("ѧ��");
				String courseId=rs.getString("�γ̱��");
				int score=Integer.parseInt(rs.getString("�÷�"));
				choice=new Choice(studentId, courseId, score);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return choice;
	}
	public ArrayList<Choice> getMyChoice(String sid){
		ArrayList<Choice> list=new ArrayList<Choice>();
		c=DatabaseHelper.getConnection();
		String sql="select * from choice where ѧ��="+sid;
		try {
			s=c.createStatement();
			rs=s.executeQuery(sql);
			while(rs.next()){
				String studentId=rs.getString("ѧ��");
				String courseId=rs.getString("�γ̱��");
				int score=Integer.parseInt(rs.getString("�÷�"));
				Choice choice=new Choice(studentId, courseId, score);
				list.add(choice);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean hasSelect(String sid,String cid){
		boolean b=false;
		ArrayList<Choice> list=getMyChoice(sid);
		for(int i=0;i<list.size();i++){
			Choice c=list.get(i);
			if(c.getCourseId().equals(cid)){
				b=true;
			}
		}
		return b;
	}
	
	
	public  void close(){
			try {
				if(c!=null) {
					c.close();
					c=null;
				}
				if(s!=null){
					s.close();
					s=null;
				}
				if(rs!=null) {
					rs.close();
					rs=null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
