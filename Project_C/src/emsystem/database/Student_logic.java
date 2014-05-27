package emsystem.database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import emsystem.data.Student;


public class Student_logic {
//对学生信息的增删改查
	conn_mysql cm = new conn_mysql();
	Statement st;
	public boolean addStudent(String snm,String sex,String sde){
		//密码默认，编号自动添加
		boolean l = false;
		Connection conn = cm.getConnection();
		String s = getMaxSno();
		int sno = Integer.parseInt(s);
		sno++;
		String sql = "INSERT INTO studentc(Sno,Snm,Sex,Sde,Pwd)" + " VALUES ('" +sno+""+"','"+ snm +"','"+sex+"','"+sde+"','"+"000000"+"')";

		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
			l = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}
	public boolean addStudent(Student s){
		boolean l = false;
		Connection conn = cm.getConnection();
		String sql = "INSERT INTO studentc(Sno,Snm,Sex,Sde,Pwd)" + 
		" VALUES ('" +s.getId()+""+"','"+ s.getName() +"','"+s.getSex()
		+"','"+s.getMajor()+"','"+s.getPassword()+"')";
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
			l = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	private String getMaxSno(){
		Connection conn = cm.getConnection();
		String id = "9";
		String sql = "SELECT Max(Sno) from studentc";
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
//			System.out.print(rs.toString());
			while(rs.next()){
				id = rs.getString(1);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public ArrayList<Student> listStudent(){
		ArrayList<Student> list = new ArrayList<Student>();
		Connection conn = cm.getConnection();
		try{
			String sql = "select * from studentc";
			st = (Statement)conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) { // 判断是否还有下一个数据  
                // 根据字段名获取相应的值  
                String id = rs.getString("Sno");  
                String name = rs.getString("Snm");
                String sex = rs.getString("Sex");  
                String sde = rs.getString("Sde");  
                String pwd = rs.getString("Pwd");  
                
                Student s = new Student(id, name, sex, sde, pwd);
                list.add(s);
                 
            }
			conn.close();
		}catch(SQLException e){
			System.out.println("query fails");
		}
		return list;
	}
	
	public Student queryStudentBySno(String sno){
//		System.out.println("sno:"+sno);
		Connection conn = cm.getConnection();
		Student stu = null;
		String sql = "SELECT * from studentc WHERE Sno = "+sno;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				String s1 = rs.getString("Sno");
				String s2 = rs.getString("Snm");
				String s3 = rs.getString("Sex");
				String s4 = rs.getString("Sde");
				String s5 = rs.getString("Pwd");
				stu = new Student(s1, s2, s3, s4, s5);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}
	
	public boolean deleteAStudent(String sno){
		boolean l = false;  
        Connection conn = cm.getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
            String sql = "delete from studentc  where Sno = "+sno;// 删除数据的sql语句  
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
//            st.executeQuery(sql);
            st.executeUpdate(sql);
            conn.close();   //关闭数据库连接  
            l = true; 
        } catch (SQLException e) {  
            System.out.println("删除数据失败"+e.toString());  
        }  
          
		return l;
	}
	public boolean deleteAStudent(Student s){
		boolean l = false;
		l = deleteAStudent(s.getId());
		return l;
	}
	
	public boolean updateStudent(Student stu){
		boolean l = false;
		Connection conn = cm.getConnection();
		String sql = "UPDATE studentc set Snm='"+stu.getName()+"',Sex='"+stu.getSex()+"',Pwd='"+stu.getPassword()+"' where Sno='"+stu.getId()+"'";
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
			conn.close();
			l = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	
	
}
