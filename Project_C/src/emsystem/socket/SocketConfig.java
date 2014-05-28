package emsystem.socket;

import emsystem.rmi.Config;

public class SocketConfig {
	static Config c = new Config();
	/*package*/ static final String IP =c.getTotalIP();
	/*package*/ static final int PORT = 8000;
	
}
