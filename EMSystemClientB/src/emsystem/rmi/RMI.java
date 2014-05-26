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
//			StudentService s = null;
//			try {
//				s= new StudentServiceImp();
//			} catch (RemoteException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return s;
		return new MockStudentService();
	}
	

	public static AdminService getAdminService(){
//		AdminService as=null;
//		as=new AdminServiceImp();
//		return as;
		return new MockAdminService();
	}
	
	public static void setIp(String pIp) {
		ip = pIp;
		isDirty = true;
	}
}
