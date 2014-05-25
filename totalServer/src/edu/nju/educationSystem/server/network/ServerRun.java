package edu.nju.educationSystem.server.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import edu.nju.educationSystem.server.factory.FacadeFactory;
import edu.nju.educationSystem.server.service.ServiceFacade;

public class ServerRun implements Runnable{
	
	public BufferedReader input;
	public PrintWriter output;
	
	public ServerRun(BufferedReader input, PrintWriter output) {
		this.input = input;
		this.output = output;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				String major = input.readLine();
				String command = input.readLine();
				String xml = input.readLine();
				ServiceFacade serviceFacade = FacadeFactory.getInstance().getServiceFacade();
				String returned = serviceFacade.networkCommandExecute(major, command, xml);
				output.println(returned);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close() {
		try {
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
