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
	
	public static void insertChoice(){//��ʼ��ѡ����Ϣ
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
	
/*	public static void insertStudent(){//��ʼ��ѧ����Ϣ
		conn = getConnection();
		int sno = 321250001;
		String sde = "�������";
		
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
		
	
	public static void insertClass(){//��ʼ���γ̱���Ϣ
		conn = getConnection();
		String[] cnms = new String[]{"���������","Ӧ�ü���ԭ���빤��",
				"Ƕ��ʽϵͳ���","�߼���������","������Ϣϵͳ",
				"����ͼ����","�����������","�������ͳ�Ʒ���",
				"�������֯�ṹ","�������������"};
		String[] tecs = new String[]{"��־�� ����","����","������",
				"WangJinqing","����Ȼ",
				"����","�۶�","������",
				"��ͩ�","�۶� ����"};
		int cno = 3001;
		for(int i=0;i<10;i++){
		try{
//			String sql = "INSERT INTO classc(Cno,Cnm,Ctm,Cpt,Tec,Pla,Share)" +
//			" VALUES ('s','ss',1,2,'a','aa','y')";
			String sql = "INSERT INTO classc(Cno,Cnm,Ctm,Cpt,Tec,Pla,Share)" + 
            " VALUES ('"+cno+""+"','"+cnms[i]+"',"
					+20+","+2+",'"+tecs[i]+"','"+"��ѧ¥"+"','"+"y"+"')";
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
			
		/*	while (rs.next()) { // �ж��Ƿ�����һ������  
                
                // �����ֶ�����ȡ��Ӧ��ֵ  
                String name = rs.getString("name");  
                int age = rs.getInt("age");  
                String sex = rs.getString("sex");  
                String address = rs.getString("address");  
                String depart = rs.getString("depart");  
                String worklen = rs.getString("worklen");  
                String wage = rs.getString("wage");  
                  
                //����鵽�ļ�¼�ĸ����ֶε�ֵ  
                System.out.println(name + " " + age + " " + sex + " " + address  
                        + " " + depart + " " + worklen + " " + wage);  
              
            }*/
			conn.close();
		}catch(SQLException e){
			System.out.println("query fails");
		}
	}
	
	
	
	/* ���·���Ҫ��ļ�¼�������ظ��µļ�¼��Ŀ*/  
 /*   public static void updateStudent() {  
        conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
        try {  
            String sql = "update staff set wage='2200' where name = 'lucy'";// �������ݵ�sql���  
              
            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����  
              
            int count = st.executeUpdate(sql);// ִ�и��²�����sql��䣬���ظ������ݵĸ���  
              
            System.out.println("staff���и��� " + count + " ������");      //������²����Ĵ�����  
              
            conn.close();   //�ر����ݿ�����  
              
        } catch (SQLException e) {  
            System.out.println("��������ʧ��");  
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
