package emsystem.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import emsystem.dao.DaoHelper;
import emsystem.rmi.NetworkInit;
import emsystem.socket.CommunicationWithServer;

public class ServerFrame extends JFrame{
	private static final long serialVersionUID = 2143872594203727023L;
	
	private JButton startButton;//��ʼ
	private JButton endButton;//����
	
	public ServerFrame() {
		this.setTitle("������B");
		this.setLayout(new FlowLayout());
		
		startButton = new JButton("����������");
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startButton.setEnabled(false);
				endButton.setEnabled(true);
				new NetworkInit().netWorkInit();
			}
		});
		
		endButton = new JButton("�رշ�����");
		endButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
				communicationWithServer.close();
				
				DaoHelper daoHelper = DaoHelper.getInstance();
				daoHelper.closeConnection();
				
				ServerFrame.this.dispose();
				System.exit(0);
			}
		});
		endButton.setEnabled(false);
		
		add(startButton);
		add(endButton);
	}
	
	public static void main(String[] a) {
		ServerFrame serverRunner = new ServerFrame();
		serverRunner.pack();
		serverRunner.setDefaultCloseOperation(EXIT_ON_CLOSE);
		serverRunner.setVisible(true);
		serverRunner.setLocationRelativeTo(null);
		serverRunner.setName("Voyager Server");
	}
	
}
