package emsystem.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import emsystem.data.Course;

public class DealWithCourse {
	Connection c;
	Statement s;
	ResultSet rs;
	
	public ArrayList<Course> getAllCourse(){
		ArrayList<Course> list=new ArrayList<Course>();
		c=DatabaseHelper.getConnection();
		String sql="select * from course";
		try {
			s=c.createStatement();
			rs=s.executeQuery(sql);
			while(rs.next()){
			String  pId=rs.getString("���");
			String  pCourseName=rs.getString("����");
			String  pCourseTime=rs.getString("��ʱ");
			int  pCredit=Integer.parseInt(rs.getString("ѧ��"));
			String  pTeacher=rs.getString("��ʦ");
			String  pAddress=rs.getString("�ص�");
			String   pShareFlag=rs.getString("����");
			Course course=new Course(pId, pCourseName, pCredit, pCourseTime, pTeacher, pAddress, pShareFlag);
			list.add(course);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
			close();
		}
		return list;
	}
	
	public boolean insert(Course course){
		boolean b=false;
		c=DatabaseHelper.getConnection();
		String sql="insert into course(���,����,��ʱ,ѧ��,��ʦ,�ص�,����) values('"+course.getId()+"','"
				+course.getCourseName()+"','"+course.getCourseTime()+"','"+course.getCredit()+"','"
				+course.getTeacher()+"','"+course.getAddress()+"','"+course.getShareFlag()+"');";
		try {
			s=c.createStatement();
			s.execute(sql);
			close();
			b=true;
		} catch (SQLException e) {
			e.printStackTrace();
			close();
		}
		return b;
	}
	
	public boolean  delete(String cid){
		boolean b=false;
		c=DatabaseHelper.getConnection();
		String sql="delete from course where ���="+cid;
		try {
			s=c.createStatement();
			s.execute(sql);
			close();
			b=true;
		} catch (SQLException e) {
			e.printStackTrace();
			close();
		}
		return b;
	}
	public Course search(String cid){
		c=DatabaseHelper.getConnection();
		String sql="select * from course where ���="+cid;
		Course course = null;
		try {
			s=c.createStatement();
			rs=s.executeQuery(sql);
			while(rs.next()){
				String pId=rs.getString("���");
				String pCourseName=rs.getString("����");
				int pCredit=Integer.parseInt(rs.getString("ѧ��"));
				String pTeacher=rs.getString("��ʦ");
				String pCourseTime=rs.getString("��ʱ");
				String pAddress=rs.getString("�ص�");
				String pShareFlag=rs.getString("����");
				course=new Course(pId, pCourseName, pCredit, pCourseTime, pTeacher, pAddress, pShareFlag);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
			close();
		}
		return course;
	}
	public boolean  modify(Course course){
		boolean b=false;
		c=DatabaseHelper.getConnection();
		String sql="update course set ����='"+course.getCourseName()
				+"',��ʱ='"+course.getCourseTime()+"',ѧ��="+course.getCredit()+",��ʦ='"+course.getTeacher()
				+"',�ص�='"+course.getAddress()+"',����='"+course.getShareFlag()+"' where ѧ��="+course.getId();
		try {
			s=c.createStatement();
			s.execute(sql);
			close();
			b=true;
		} catch (SQLException e) { 
			e.printStackTrace();
			close();
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
