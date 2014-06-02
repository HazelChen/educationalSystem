package edu.nju.educationSystem.server.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.educationSystem.server.network.SocketServer;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel startPanel;
	private JButton startButton;
	private SocketServer socketServer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);

		startPanel = new JPanel();
		startButton = new JButton("¿ªÆô·þÎñÆ÷");
//		startButton.addActionListener(this);
		startPanel.add(startButton, BorderLayout.NORTH);

		socketServer = new SocketServer();
//		socketServer.run();
		MainPanel mainPanel = new MainPanel(socketServer);
		setContentPane(mainPanel);
	}

	

}
