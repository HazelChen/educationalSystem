package emsystem.database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import emsystem.data.Course;
import emsystem.data.Student;


public class Course_logic {
	//对课程信息的增删改查
	conn_mysql cm = new conn_mysql();
	Statement st;
	public boolean addCourse(String cnm,int ctm,int cpt,String tec,String pla,String share){
		Connection conn = cm.getConnection();
		String s = getMaxCno();
		int cno = Integer.parseInt(s);
		cno++;
		String sql = "INSERT INTO classc(Cno,Cnm,Ctm,Cpt,Tec,Pla,Share)" + " VALUES ('" +cno+""+"','"+ cnm +"',"+ctm+","+cpt+",'"+tec+"','"+pla+"','"+share+"')";
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
			return true;
			
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
		return false;
	}
	
	public void setShareState(String cno){
		Connection conn = cm.getConnection();
		String sql = "UPDATE classc set Share = 'y' WHERE Cno='"+cno+"'";
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean addCourse(Course c){
		boolean l = false;
		String sql=null;
		Connection conn = cm.getConnection();
		System.out.println(c.getId()+" "+c.getAddress()+" "
				+c.getCourseName()+" "+c.getCourseTime()+" "
				+c.getCredit()+" "+c.getTeacher()+" "+c.getShareFlag());
		if(c.getShareFlag().equals("是")){
			sql = "INSERT INTO classc(Cno,Cnm,Ctm,Cpt,Tec,Pla,Share)" + 
					" VALUES ('" +c.getId()+"','"+ c.getCourseName()
					+"',"+c.getCourseTime()+","+c.getCredit()+",'"+c.getTeacher()
					+"','"+c.getAddress()+"','y')";
		}else{
			sql = "INSERT INTO classc(Cno,Cnm,Ctm,Cpt,Tec,Pla,Share)" + 
					" VALUES ('" +c.getId()+"','"+ c.getCourseName()
					+"',"+c.getCourseTime()+","+c.getCredit()+",'"+c.getTeacher()
					+"','"+c.getAddress()+"','n')";
		}
		
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
	private String getMaxCno(){
		Connection conn = cm.getConnection();
		String id = "9";
		String sql = "SELECT Max(Cno) from classc";
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
	public ArrayList<Course> listCourse(){
		ArrayList<Course> list = new ArrayList<Course>();
		Connection conn = cm.getConnection();
		try{
			String sql = "select * from classc";
			st = (Statement)conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) { // 判断是否还有下一个数据  
                // 根据字段名获取相应的值  
                String id = rs.getString("Cno");  
                String name = rs.getString("Cnm");
                int ctm = rs.getInt("Ctm");
                int cpt = rs.getInt("Cpt");
                String tec = rs.getString("Tec");  
                String pla = rs.getString("Pla");  
                String share = rs.getString("Share");  
                  
                Course course = new Course(id, name, ctm, cpt,  tec,pla, share);
                list.add(course);
            }
			conn.close();
		}catch(SQLException e){
			System.out.println("query fails");
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean deleteACourse(String cno){
		Connection conn = cm.getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
            String sql = "delete from classc  where Cno = "+cno;// 删除数据的sql语句  
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
//            st.executeQuery(sql);
            st.executeUpdate(sql);
            conn.close();   //关闭数据库连接  
            return true;  
        } catch (SQLException e) {  
            System.out.println("删除数据失败"+e.toString());  
        }  
          
		return false;
	}
	
	public Course queryCourseByCno(String cno){
		Connection conn = cm.getConnection();
		Course co = null;
		String sql = "SELECT * from classc WHERE Cno = "+cno;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				String s1 = rs.getString("Cno");
				String s2 = rs.getString("Cnm");
				int i1 = rs.getInt("Ctm");
				int i2 = rs.getInt("Cpt");
				String s3 = rs.getString("Tec");
				String s4 = rs.getString("Pla");
				String s5 = rs.getString("Share");
				co = new Course(s1, s2 , i1 , i2 , s3, s4, s5);
				return co;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return co;
	}
	
	
	
	public boolean updateCourse(Course course){//没检查= =有点困
		Connection conn = cm.getConnection();
		String sql = "UPDATE classc set Cnm='"+course.getCourseName()+"',Ctm="+
		course.getCourseTime()+",Cpt="+course.getCredit()
				+",Tec='"+course.getTeacher()
				+"',Pla='"+course.getAddress()+"',Share='"+course.getShareFlag()
				+"' where Cno='"+course.getId()+"'";
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
			conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean createTableAccount(){
		return false;
	}
	
	public boolean isCCourse(String cno){
		if(cno.startsWith("3")){
			return true;
		}else
			return false;
	}
	
	public ArrayList<Student> getStudentByCno(String cno){
		Connection conn = cm.getConnection();
		Student_logic sl = new Student_logic();
		ArrayList<Student> list = new ArrayList<Student>();
		String sql = "SELECT * from choicec WHERE Cno = "+cno;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Student s = sl.queryStudentBySno(rs.getString("Sno"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Course> getUnsharedCourse(){
		ArrayList<Course> list = new ArrayList<Course>();
		Connection conn = cm.getConnection();
		String sql = "SELECT * from classc where Share = 'n'";
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Course c = new Course(rs.getString("Cno"), rs.getString("Cnm"), rs.getInt("Ctm"), rs.getInt("Cpt"), rs.getString("Tec"), rs.getString("Pla"), rs.getString("Share"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
