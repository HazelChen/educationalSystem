package emsystem.socket;

import emsystem.rmi.Config;

public class SocketConfig {
	static Config config=new Config();
	/*package*/ static final String IP =config.getTotalIP();
	/*package*/ static final int PORT = 8000;
	
}
