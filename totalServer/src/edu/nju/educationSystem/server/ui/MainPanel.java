package edu.nju.educationSystem.server.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import edu.nju.educationSystem.server.network.SocketServer;


public class MainPanel extends JPanel implements MenuListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9053525914273572780L;

	/**
	 * Create the panel.
	 */
	private JMenu studentMenu;
	private JMenu courseMenu;
	private JMenu electiveMenu;
	private JButton endButton;
	
	private JPanel contentPanel;
	private MainFrame mainFrame;
	private SocketServer socketServer;
	
	public MainPanel(SocketServer pSocketServer) {
		socketServer = pSocketServer;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("集成教务系统");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblNewLabel.setBounds(345, 13, 500, 26);
		add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(50, 50, 750, 26);
		add(menuBar);
		
		studentMenu= new JMenu("学生信息");
		studentMenu.addMenuListener(this);
		studentMenu.setBounds(50, 50, 229, 24);
		menuBar.add(studentMenu);
		
		courseMenu= new JMenu("课程信息");
		courseMenu.addMenuListener(this);
		courseMenu.setBounds(279, 50, 229, 24);
		menuBar.add(courseMenu);
		
		electiveMenu = new JMenu("选课信息");
		electiveMenu.addMenuListener(this);
		electiveMenu.setBounds(408, 50, 229, 24);
		menuBar.add(electiveMenu);
		
		contentPanel = new JPanel();
		contentPanel.setBounds(60, 80, 668, 326);
		add(contentPanel);
		
		endButton = new JButton("关闭服务器");
		endButton.addActionListener(this);
		endButton.setBounds(347, 523, 113, 27);
		add(endButton);
	}
	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(studentMenu)) {
			contentPanel.removeAll();
			StudentInfoPanel studentInfoPanel = new StudentInfoPanel();
			contentPanel.add(studentInfoPanel);
			this.add(contentPanel, BorderLayout.CENTER);
			repaint();
			validate();
		} else if (e.getSource().equals(courseMenu)) {
			contentPanel.removeAll();
			CourseInfoPanel courseInfoPanel = new CourseInfoPanel();
			contentPanel.add(courseInfoPanel);
			this.add(contentPanel, BorderLayout.CENTER);
			repaint();
			validate();

		} else if (e.getSource().equals(electiveMenu)) {
			contentPanel.removeAll();
			ElectiveInfoPanel electiveInfoPanel = new ElectiveInfoPanel();
			contentPanel.add(electiveInfoPanel);
			this.add(contentPanel, BorderLayout.CENTER);
			repaint();
			validate();
		}
	}

	@Override
	public void menuCanceled(MenuEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuDeselected(MenuEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
			socketServer.close();
			contentPanel.removeAll();		
			repaint();
			validate();

	}
}
