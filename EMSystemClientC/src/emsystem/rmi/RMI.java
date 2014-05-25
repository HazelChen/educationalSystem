package emsystem.rmi;

import emsystem.rmi.mock.MockAdminService;
import emsystem.rmi.mock.MockStudentService;



public class RMI {
	static String ip;
	static boolean isDirty;
	
	static{
		// TODO 从配置文件中读取IP.初始化ip
		ip = "rmi://localhost";
	}

	public static String getIp() {
		return ip;
	}
	
	public static StudentService getStudentService() {
			StudentService s = null;
			s= new MockStudentService() ;
			return s;
	}

	public static AdminService getAdminService(){
		AdminService as=null;
		as=new MockAdminService();
		return as;
	}
	
	public static void setIp(String pIp) {
		ip = pIp;
		isDirty = true;
	}
}
