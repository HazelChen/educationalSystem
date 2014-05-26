package edu.nju.educationSystem.server.network;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SocketServer extends TextArea{
	private static final long serialVersionUID = -830484049023135473L;
	
	private ServerRun[] serverRuns = new ServerRun[3];
	
	public SocketServer() {
		this.setEditable(false);
		this.append("��( ���գ��������ܷ������ִ��塣\n");
		this.append("����" + new Date() + "��������\n");
		this.append("���ڵȴ�һ��С����\n");
	}
	
	public void run() {
		clientAccepted();
	}
	
	public void close() {
		for (ServerRun serverRun : serverRuns) {
			if (serverRun != null) {
				serverRun.close();
			}
		}
	}
	
	private void clientAccepted() {
		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(8000);
			int acceptedIndex = 0;
			while (acceptedIndex < serverRuns.length) {
				Socket socket = serverSocket.accept();
				this.append("һ��С���������\n");
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
