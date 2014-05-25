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
				String keti=rs.getString("客体");
				int jibie=rs.getInt("级别");
				String name=rs.getString("账户名");
				String password=rs.getString("密码");
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
		String sql="insert into account(账户名,密码,级别,客体) values('"+acc.getName()+"','"
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
		String sql="delete from account where 账户名='"+aid+"'";
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
		String sql="select * from account where 账户名='"+aid+"'";
		Account account=null;
		try {
			s=c.createStatement();
			rs=s.executeQuery(sql);
			while(rs.next()){
//				String keti=rs.getString("客体");
				int jibie=rs.getInt("级别");
				String name=rs.getString("账户名");
				String password=rs.getString("密码");
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
//				+",性别="+stu.getSex()+",密码="+stu.getmPassword()+" where 学号="+stu.getId();
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
