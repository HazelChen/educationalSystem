package edu.nju.educationSystem.server.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	private ServerRun[] serverRuns;
	
	public void run() {
		clientAccepted();
	}
	
	public void close() {
		for (int i = 0; i < serverRuns.length; i++) {
			serverRuns[i].close();
		}
	}
	
	
	
	private void clientAccepted() {
		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(8000);
			int acceptedIndex = 0;
			while (acceptedIndex < serverRuns.length) {
				Socket socket = serverSocket.accept();
				BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter output = new PrintWriter(socket.getOutputStream());
				
				ServerRun serverRun = new ServerRun(input, output);
				Thread thread = new Thread(serverRun);
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
