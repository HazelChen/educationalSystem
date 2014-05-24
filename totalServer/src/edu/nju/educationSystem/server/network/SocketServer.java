package edu.nju.educationSystem.server.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	private BufferedReader[] input;
	private PrintWriter[] output;
	
	public void run() {
		clientAccepted();
	}
	
	public void close() {
		for (int i = 0; i < input.length; i++) {
			try {
				input[i].close();
				output[i].close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void clientAccepted() {
		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(8000);
			int acceptedIndex = 0;
			while (acceptedIndex < input.length) {
				Socket socket = serverSocket.accept();
				input[acceptedIndex] = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				output[acceptedIndex] = new PrintWriter(socket.getOutputStream());
				
				ServerRun serverRun = new ServerRun(input[acceptedIndex], output[acceptedIndex]);
				Thread thread = new Thread(serverRun);
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
