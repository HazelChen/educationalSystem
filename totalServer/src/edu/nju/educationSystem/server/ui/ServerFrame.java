package edu.nju.educationSystem.server.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import edu.nju.educationSystem.server.network.SocketServer;

public class ServerFrame extends JFrame {
	private static final long serialVersionUID = -2059689373381823243L;
	
	private JButton endButton;// ����
	private SocketServer socketServer;

	public ServerFrame() {
		this.setTitle("�ܷ�����");
		this.setLayout(new FlowLayout());

		socketServer = new SocketServer();
//		this.add(new JScrollPane(socketServer));
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		endButton = new JButton("�رշ�����");
		endButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				socketServer.close();
				ServerFrame.this.dispose();
				System.exit(0);
			}
		});
		add(endButton);
		
		socketServer.run();
	}

//	public static void main(String[] a) {
//		ServerFrame serverRunner = new ServerFrame();	
//	}

}
