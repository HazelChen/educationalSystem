package emsystem.rmi;



public class RMI {
	static String ip;
	static boolean isDirty;
	
	static{
		// TODO �������ļ��ж�ȡIP.��ʼ��ip
		ip = "127.0.0.1";
	}

	public static String getIp() {
		return ip;
	}
	
	public static StudentService getService() {
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
		return new MockService();
	}

	public static void setIp(String pIp) {
		ip = pIp;
		isDirty = true;
	}
}