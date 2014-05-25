package emsystem.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import emsystem.data.Account;
import emsystem.data.Student;

public class DealWithAccount {
	Connection c;
	Statement s;
	ResultSet rs;
	
	public ArrayList<Account> getAllAccount(){
		ArrayList<Account> list=new ArrayList<Account>();
		c=DatabaseHelper.getConnection();
		String sql="select * from account";
		try {
			s=c.createStatement();
			rs=s.executeQuery(sql);
			while(rs.next()){
				String keti=rs.getString("����");
				int jibie=rs.getInt("����");
				String name=rs.getString("�˻���");
				String password=rs.getString("����");
				Account account=new Account(name, password, jibie, keti);
				list.add(account);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
			close();
		}
		return list;
	}
	
	public boolean insert(Account acc){
		boolean b=false;
		c=DatabaseHelper.getConnection();
		String sql="insert into account(�˻���,����,����,����) values('"+acc.getName()+"','"
				+acc.getPassword()+"','"+acc.getJibie()+"','"+acc.getKeti()+"')";
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
	
	public boolean delete(String aid){
		boolean b=false;
		c=DatabaseHelper.getConnection();
		String sql="delete from account where �˻���='"+aid+"'";
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
	
	public Account search(String aid){
		c=DatabaseHelper.getConnection();
		String sql="select * from account where �˻���='"+aid+"'";
		Account account=null;
		try {
			s=c.createStatement();
			rs=s.executeQuery(sql);
			while(rs.next()){
//				String keti=rs.getString("����");
				int jibie=rs.getInt("����");
				String name=rs.getString("�˻���");
				String password=rs.getString("����");
				account=new Account(name, password, jibie, name);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
			close();
		}
		return account;
	}
	
//	public boolean  modify(Account acc){
//		boolean b=false;
//		c=DatabaseHelper.getConnection();
//		String sql="update account set ="+stu.getName()
//				+",�Ա�="+stu.getSex()+",����="+stu.getmPassword()+" where ѧ��="+stu.getId();
//		try {
//			s=c.createStatement();
//			b=s.execute(sql);
//			close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return b;
//	}
	
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
