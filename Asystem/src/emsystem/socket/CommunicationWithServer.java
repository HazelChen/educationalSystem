package emsystem.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class CommunicationWithServer {
	private static CommunicationWithServer self;
	
	private BufferedReader input;
	private PrintWriter output;
	
	private CommunicationWithServer() {}
	
	public static CommunicationWithServer getInstance() {
		if (self == null) {
			self = new CommunicationWithServer();
		}
		return self;
	}
	
	public String communicate(String command, String xml) {
		init();
		
		output.print("A");
		output.println(command);
		output.println(xml);
		
		String resultXml = "";
		try {
			resultXml = input.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultXml;
	}
	
	public String communicate(String command) {
		init();
		
		output.println("A");
		output.println(command);
		
		String resultXml = "";
		try {
			resultXml = input.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultXml;
	}
	
	public void close() {
		if (input != null && output != null) {
			try {
				input.close();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void init() {
		if (input == null) {
			try {
				@SuppressWarnings("resource")
				Socket socket = new Socket(SocketConfig.IP, SocketConfig.PORT);
				input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				output = new PrintWriter(socket.getOutputStream());
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
