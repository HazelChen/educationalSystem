package emsystem.rmi;

import emsystem.rmi.mock.MockAdminService;
import emsystem.rmi.mock.MockStudentService;



public class RMI {
	static String ip;
	static boolean isDirty;
	
	static{
		// TODO 从配置文件中读取IP.初始化ip
		ip = "127.0.0.1";
	}

	public static String getIp() {
		return ip;
	}
	
	public static StudentService getStudentService() {
//		if (service == null || isDirty) {
//			try {
//				service = (IBusinessService) Naming.lookup("rmi://" + ip + "/Service");
//				isDirty = false;
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		try {
//			return (StudentService) Naming.lookup("rmi://" + ip + "/Service");
//		} catch (MalformedURLException | RemoteException | NotBoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return new MockStudentService();
	}

	public static AdminService getAdminService(){
		
		return new MockAdminService();
	}
	
	public static void setIp(String pIp) {
		ip = pIp;
		isDirty = true;
	}
}
