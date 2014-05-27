package emsystem.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import emsystemimp.AdminServiceImp;
import emsystemimp.StudentServiceImp;

public class Main {
	public static void main(String[] a)throws RemoteException{
		LocateRegistry.createRegistry(1099);
		AdminServiceImp asi = new AdminServiceImp();
		StudentServiceImp aai = new StudentServiceImp();
		String s="rmi://localhost";
		try {
			Naming.rebind(s+":1099/student", aai);
			Naming.rebind(s+":1099/admin", asi);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new ServiceUI();
		
	}

}
