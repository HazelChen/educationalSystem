package emsystem.rmi;

import java.rmi.RemoteException;

import emsystem.service.AdminServiceImp;
import emsystem.service.StudentServiceImp;

public class RMI {
	static String ip;
	static boolean isDirty;
	static Config c = new Config();
	
	
	static{
		// TODO 从配置文件中读取IP.初始化ip
		ip = "rmi://"+c.getADataIP();
	}

	public static String getIp() {
		return ip;
	}
	
	public static StudentService getStudentService() {
		
			StudentService s = null;
			try {
				s= new StudentServiceImp();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return s;
	}

	public static AdminService getAdminService(){
		AdminService as=null;
		as=new AdminServiceImp();
		return as;
	}
	
	public static void setIp(String pIp) {
		ip = pIp;
		isDirty = true;
	}
}
