package emsystem.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import emsystem.service.AdminServiceImp;
import emsystem.service.StudentServiceImp;

public class NetworkInit {
	
	public void netWorkInit(){
		try {
			LocateRegistry.createRegistry(1099);
			StudentService studentService = new StudentServiceImp();
			AdminService adminService = new AdminServiceImp();
			Naming.rebind("student", studentService);
			Naming.rebind("admin", adminService);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
