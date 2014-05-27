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
			String  pId=rs.getString("编号");
			String  pCourseName=rs.getString("名称");
			String  pCourseTime=rs.getString("课时");
			int  pCredit=Integer.parseInt(rs.getString("学分"));
			String  pTeacher=rs.getString("老师");
			String  pAddress=rs.getString("地点");
			String   pShareFlag=rs.getString("共享");
			if(pShareFlag.equals("1")){
				pShareFlag="是";
			}else{
				pShareFlag="否";
			}
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
		int flag=0;
		if(course.getShareFlag().equals("是")){
			flag=1;
		}
		String sql="insert into course(编号,名称,课时,学分,老师,地点,共享) values('"+course.getId()+"','"
				+course.getCourseName()+"','"+course.getCourseTime()+"','"+course.getCredit()+"','"
				+course.getTeacher()+"','"+course.getAddress()+"','"+flag+"');";
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
		String sql="delete from course where 编号='"+cid+"'";
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
		String sql="select * from course where 编号='"+cid+"'";
		Course course = null;
		try {
			s=c.createStatement();
			rs=s.executeQuery(sql);
			while(rs.next()){
				String pId=rs.getString("编号");
				String pCourseName=rs.getString("名称");
				int pCredit=Integer.parseInt(rs.getString("学分"));
				String pTeacher=rs.getString("老师");
				String pCourseTime=rs.getString("课时");
				String pAddress=rs.getString("地点");
				String pShareFlag=rs.getString("共享");
				if(pShareFlag.equals("1")){
					pShareFlag="是";
				}else{
					pShareFlag="否";
				}
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
		int flag=0;
		if(course.getShareFlag().equals("是")){
			flag=1;
		}
		String sql="update course set 名称='"+course.getCourseName()
				+"',课时='"+course.getCourseTime()+"',学分="+course.getCredit()+",老师='"+course.getTeacher()
				+"',地点='"+course.getAddress()+"',共享='"+flag+"' where 编号='"+course.getId()+"'";
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
