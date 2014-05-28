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
				System.out.println("in:" + major);
				String command = input.readLine();
				System.out.println("in:" + command);
				
				StringBuffer xmlBuffer = new StringBuffer();
				String tempString = "";
				while (!(tempString = input.readLine()).equals("finish")) {
					xmlBuffer.append(tempString);
				}
				String xml = xmlBuffer.toString();
				System.out.println("in:" + xml);
				
				ServiceFacade serviceFacade = FacadeFactory.getInstance().getServiceFacade();
				String returned = serviceFacade.networkCommandExecute(major, command, xml);
				output.println(returned);
				System.out.println("out:" + returned);
				output.println("finish");
				output.flush();
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
