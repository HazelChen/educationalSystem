package edu.nju.educationSystem.server.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

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
				String option = input.readLine();
				//TODO
				String xml = input.readLine();
				//TODO
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

}
