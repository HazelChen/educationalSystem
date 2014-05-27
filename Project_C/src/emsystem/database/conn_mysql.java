package emsystem.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;





public class conn_mysql {
	static Connection conn;
	
	static Statement st;
	
	public static void insertAccount(){
		int acc = 321250001;
		String pwd = "000000";
		Date date;
		Timestamp ts;
		conn = getConnection();
		for(int i=0;i<51;i++){
			date = new Date();
			ts = new Timestamp(date.getTime());
			String sql = "INSERT INTO accountc(acc,passwd,CreateDate)"+"VALUES('"+
			acc+""+"','"+pwd+"','"+ts+"')";
			try {
				st = (Statement)conn.createStatement();
				st.executeUpdate(sql);
				acc++;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insertChoice(){//初始化选课信息
		int sno = 321250001;
		String[] cnos = new String[]{"3001","3002","3003","3004","3005",
				"3006","3007","3008","3009","3010"};
		conn = getConnection();
		for(int i=0;i<50;i++){
		try{
//			String sql = "INSERT INTO choicec(Cno,Sno,Grd)" + " VALUES ('2','3',4)";
			String sql = "INSERT INTO choicec(Cno,Sno,Grd)" + 
                         " VALUES ('"+cnos[(int) (Math.random()*10)]+"','"+sno+"',"+Math.random()*100+1+")";
			st = (Statement)conn.createStatement();
			st.executeUpdate(sql);
			sno++;
		}catch(SQLException e){
			System.out.println("insert fails:"+e.getMessage());
		}
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
/*	public static void insertStudent(){//初始化学生信息
		conn = getConnection();
		int sno = 321250001;
		String sde = "软件工程";
		
		for(int i=1;i<51;i++){
		try{
//			String sql = "INSERT INTO studentc(Sno,Snm,Sex,Sde,Pwd)" + " VALUES ('111250026','dyw','f','soft','d')";
			String sql = "INSERT INTO studentc(Sno,Snm,Sex,Sde,Pwd)" + " VALUES ('" +sno+""+"','"+ s.getAName() +"','"+"f"+"','"+sde+"','"+"000000"+"')";
			st = (Statement)conn.createStatement();
			st.executeUpdate(sql);
			sno++;
		}catch(SQLException e){
			System.out.println("insert fails:"+e.getMessage()+sno+i);
		}
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
		
	
	public static void insertClass(){//初始化课程表信息
		conn = getConnection();
		String[] cnms = new String[]{"计算机网络","应用集成原理与工具",
				"嵌入式系统设计","高级电子商务","管理信息系统",
				"数字图像处理","敏捷软件开发","软件工程统计方法",
				"计算机组织结构","计算与软件工程"};
		String[] tecs = new String[]{"赵志宏 刘峰","刘峰","刘海涛",
				"WangJinqing","王浩然",
				"高阳","邵栋","陈振宇",
				"任桐炜","邵栋 刘钦"};
		int cno = 3001;
		for(int i=0;i<10;i++){
		try{
//			String sql = "INSERT INTO classc(Cno,Cnm,Ctm,Cpt,Tec,Pla,Share)" +
//			" VALUES ('s','ss',1,2,'a','aa','y')";
			String sql = "INSERT INTO classc(Cno,Cnm,Ctm,Cpt,Tec,Pla,Share)" + 
            " VALUES ('"+cno+""+"','"+cnms[i]+"',"
					+20+","+2+",'"+tecs[i]+"','"+"教学楼"+"','"+"y"+"')";
			st = (Statement)conn.createStatement();
			st.executeUpdate(sql);
			cno++;
		}catch(SQLException e){
			System.out.println("insert fails:"+e.getMessage());
		}
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void queryStudent(){
		conn = getConnection();
		try{
			String sql = "select * from studentc";
			st = (Statement)conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			System.out.print("result ret is:"+rs.toString());
			
		/*	while (rs.next()) { // 判断是否还有下一个数据  
                
                // 根据字段名获取相应的值  
                String name = rs.getString("name");  
                int age = rs.getInt("age");  
                String sex = rs.getString("sex");  
                String address = rs.getString("address");  
                String depart = rs.getString("depart");  
                String worklen = rs.getString("worklen");  
                String wage = rs.getString("wage");  
                  
                //输出查到的记录的各个字段的值  
                System.out.println(name + " " + age + " " + sex + " " + address  
                        + " " + depart + " " + worklen + " " + wage);  
              
            }*/
			conn.close();
		}catch(SQLException e){
			System.out.println("query fails");
		}
	}
	
	
	
	/* 更新符合要求的记录，并返回更新的记录数目*/  
 /*   public static void updateStudent() {  
        conn = getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
            String sql = "update staff set wage='2200' where name = 'lucy'";// 更新数据的sql语句  
              
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
              
            int count = st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数  
              
            System.out.println("staff表中更新 " + count + " 条数据");      //输出更新操作的处理结果  
              
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) {  
            System.out.println("更新数据失败");  
        }  
    }*/
	
	public static Connection getConnection(){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/c",
					 "root",
					 "root");
		}catch(Exception e){
			System.out.println("connect fails "+e.getMessage());
		}
		return con;
	}

}
