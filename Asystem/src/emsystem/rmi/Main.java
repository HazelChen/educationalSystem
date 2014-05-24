package emsystem.rmi;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import emsystem.service.StudentServiceImp;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws RemoteException {
		String s="rmi://localhost";
//		String s="rmi://172.25.65.100";
		 try  
	        {  //��������ע��Զ�̶���   
			    StudentServiceImp student=new StudentServiceImp();
			    LocateRegistry.createRegistry(8888);
	            Naming.rebind (s+":8888/student", student);   
	            
	        	new ServerUI(); 
	        }   
	        catch(MalformedURLException mue)   
	        {   
	            mue.printStackTrace ();   
	        }   
	    }   
		
	}


