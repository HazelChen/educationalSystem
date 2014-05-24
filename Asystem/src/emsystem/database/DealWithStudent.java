package emsystem.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import emsystem.data.Account;
import emsystem.data.Student;


public class DealWithStudent {
	Connection c;
	Statement s;
	ResultSet rs;
	
	public ArrayList<Student> getAllStudent(){
		ArrayList<Student> list=new ArrayList<Student>();
		c=DatabaseHelper.getConnection();
		String sql="select * from student";
		try {
			s=c.createStatement();
			rs=s.executeQuery(sql);
			while(rs.next()){
				String pId=rs.getString("ѧ��");
				String pName=rs.getString("����");
				String pSex=rs.getString("�Ա�");
				String pMajor=rs.getString("רҵ");
				String pPassword=rs.getString("����");
				Student stu=new Student(pId, pName, pSex, pMajor, pPassword);
				list.add(stu);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean insert(Student stu){
		boolean b=false;
		c=DatabaseHelper.getConnection();
		String sql="insert into student(ѧ��,����,�Ա�,רҵ,����) values('"+stu.getId()+"','"
				+stu.getName()+"','"+stu.getSex()+"','"+stu.getMajor()+"','"+stu.getmPassword()+"');";
		try {
			s=c.createStatement();
			b=s.execute(sql);
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Account acc=new Account(stu.getId(), stu.getmPassword(), 0, stu.getId());
		DealWithAccount dc=new DealWithAccount();
		dc.insert(acc);
		return b;
	}
	
	public boolean delete(String sid){
		boolean b=false;
		c=DatabaseHelper.getConnection();
		String sql="delete from student where ѧ��="+sid;
		try {
			s=c.createStatement();
			b=s.execute(sql);
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DealWithAccount dc=new DealWithAccount();
		dc.delete(sid);
		return b;
	}
	
	public Student search(String sid){
		c=DatabaseHelper.getConnection();
		String sql="select * from student where ѧ��="+sid;
		Student stu = null;
		try {
			s=c.createStatement();
			rs=s.executeQuery(sql);
			while(rs.next()){
				String pId=rs.getString("ѧ��");
				String pName=rs.getString("����");
				String pSex=rs.getString("�Ա�");
				String pMajor=rs.getString("רҵ");
				String pPassword=rs.getString("����");
				stu=new Student(pId, pName, pSex, pMajor, pPassword);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stu;
	}
	public boolean  modify(Student stu){
		boolean b=false;
		c=DatabaseHelper.getConnection();
		String sql="update student set ����="+stu.getName()
				+",�Ա�="+stu.getSex()+",����="+stu.getmPassword()+" where ѧ��="+stu.getId();
		try {
			s=c.createStatement();
			b=s.execute(sql);
			close();
		} catch (SQLException e) {
			e.printStackTrace();
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
