package emsystem.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;




public class RMI {
	private static String ip = new Config().getADataIP();
	
	private static StudentService studentService;
	private static AdminService adminService;
	
	public static void init () {
		try {
			studentService = (StudentService)Naming.lookup("rmi://" + ip + "/student");
			adminService = (AdminService)Naming.lookup("rmi://" + ip + "/admin");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static StudentService getStudentService() {
		return studentService;
	}
	

	public static AdminService getAdminService(){
		return adminService;
	}
}
