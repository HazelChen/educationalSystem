package emsystem.ui.student;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import emsystem.ui.LoginPanel;
import emsystem.ui.MainFrame;

public class StudentOperationPanel extends JPanel implements MenuListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2422365424600897975L;
	/**
	 * Create the panel.
	 */
	private String mLogout = "<html><u>退出登录</u></html>";
	private String mInform = "<html><u>查看通知</u></html>";
	
	private String mTitle = "教务系统";
	private String mPersonlInfoString = "个人信息";
	private String mMyClassesString = "我的课程";
	private String mAllClassesString = "学期选课";
	
	private JMenuBar menuBar;
	private JMenu personInfoMenu;
	private JMenu myClassMenu;
	private JMenu allClassMenu;
	
	private JPanel contentPanel;
	
	private MainFrame mFrame;
	private JLabel label;
	
	private String mAccount;
	public StudentOperationPanel(MainFrame pFrame, String pAccount) {
		mFrame = pFrame;
		mAccount = pAccount;
		setLayout(null);
		setBounds(0, 0, 800, 600);

		JLabel lblLogout = new JLabel(mLogout);
		lblLogout.setBounds(10, 0, 54, 27);
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginPanel loginPanel = new LoginPanel(mFrame);
				mFrame.setContentPane(loginPanel);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		add(lblLogout);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(30, 50, 750, 30);
		
		personInfoMenu = new JMenu(mPersonlInfoString);
		personInfoMenu.setBounds(54, 41, 111, 22);
		personInfoMenu.addMenuListener(this);
		menuBar.add(personInfoMenu);
		
		myClassMenu = new JMenu(mMyClassesString);
		myClassMenu.setBounds(191, 41, 111, 22);
		myClassMenu.addMenuListener(this);
		menuBar.add(myClassMenu);
		
		allClassMenu = new JMenu(mAllClassesString);
		allClassMenu.setBounds(322, 41, 111, 22);
		allClassMenu.addMenuListener(this);
		menuBar.add(allClassMenu);
		add(menuBar);
		
		contentPanel = new JPanel();
		contentPanel.setBounds(40, 99, 740, 475);
		add(contentPanel);
		
		label = new JLabel(mInform);
		label.setBounds(698, 0, 79, 27);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StudentInformPanel informPanel = new StudentInformPanel(mFrame, mAccount);
				mFrame.setContentPane(informPanel);
				mFrame.repaint();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		add(label);
		
		JLabel lblNewLabel = new JLabel(mTitle);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel.setBounds(322, 3, 181, 37);
		add(lblNewLabel);
		
	}
	
	@Override
	public void menuSelected(MenuEvent e){
		if(e.getSource().equals(personInfoMenu)){
			contentPanel.removeAll();
			StudentInfoPanel panel = new StudentInfoPanel(mAccount);
			contentPanel.add(panel);
			this.add(contentPanel, BorderLayout.CENTER);
			repaint();
			validate();
		}
		
		else if (e.getSource().equals(myClassMenu)) {
			contentPanel.removeAll();
			StudentClassesPanel studentClassesPanel = new StudentClassesPanel(mAccount);
			contentPanel.add(studentClassesPanel);
			this.add(contentPanel, BorderLayout.CENTER);
			repaint();
			validate();
			
		}
		
		else if (e.getSource().equals(allClassMenu)) {
			contentPanel.removeAll();
			StudentChooseClassPanel chooseClassPanel = new StudentChooseClassPanel(mAccount);
			contentPanel.add(chooseClassPanel);
			this.add(contentPanel, BorderLayout.CENTER);
			repaint();
			validate();
		}
			
	}
	
	@Override
	public void menuDeselected(MenuEvent e) {}
	@Override
	public void menuCanceled(MenuEvent e) {}
}
