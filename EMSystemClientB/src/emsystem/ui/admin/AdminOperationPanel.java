package emsystem.ui.admin;

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

public class AdminOperationPanel extends JPanel implements MenuListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5302362514907356299L;

	private String mLogout = "<html><u>退出登录</u></html>";

	private String mTitle = "教务系统";
	private String mStudentInfoString = "学生信息";
	private String mCourseInfoString = "课程信息";
	private String mChooseCourseInfo = "选课信息";
	private String mCrossChooseString = "跨专业选课管理"; 

	private JMenuBar menuBar;
	private JMenu mStudentInfoMenu;
	private JMenu mCourseInfoMenu;
	private JMenu mChooseCourseInfoMenu;
	private JMenu mCrossChooseManageMenu;

	private JPanel contentPanel;

	private MainFrame mFrame;


	public AdminOperationPanel(MainFrame pFrame) {
		mFrame = pFrame;
		setLayout(null);
		setBounds(0, 0, 800, 600);

		JLabel lblLogout = new JLabel(mLogout);
		lblLogout.setBounds(10, 0, 54, 27);
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginPanel loginPanel = new LoginPanel(mFrame);
				mFrame.setContentPane(loginPanel);
				mFrame.validate();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		add(lblLogout);

		menuBar = new JMenuBar();
		menuBar.setBounds(30, 50, 750, 30);

		mStudentInfoMenu = new JMenu(mStudentInfoString);
		mStudentInfoMenu.setBounds(54, 41, 111, 22);
		mStudentInfoMenu.addMenuListener(this);
		menuBar.add(mStudentInfoMenu);

		mCourseInfoMenu = new JMenu(mCourseInfoString);
		mCourseInfoMenu.setBounds(191, 41, 111, 22);
		mCourseInfoMenu.addMenuListener(this);
		menuBar.add(mCourseInfoMenu);

		 mChooseCourseInfoMenu = new JMenu(mChooseCourseInfo);
		 mChooseCourseInfoMenu.setBounds(322, 41, 111, 22);
		 mChooseCourseInfoMenu.addMenuListener(this);
		 menuBar.add(mChooseCourseInfoMenu);
		 
		 mCrossChooseManageMenu = new JMenu(mCrossChooseString);
		 mCrossChooseManageMenu.setBounds(440, 41, 111, 22);
		 mCrossChooseManageMenu.addMenuListener(this);
		 menuBar.add(mCrossChooseManageMenu);
		 
		 add(menuBar);

		contentPanel = new JPanel();
		contentPanel.setBounds(40, 99, 740, 475);
		add(contentPanel);

		JLabel lblNewLabel = new JLabel(mTitle);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel.setBounds(322, 3, 181, 37);
		add(lblNewLabel);

	}

	@Override
	public void menuSelected(MenuEvent e) {
		if (e.getSource().equals(mStudentInfoMenu)) {
			contentPanel.removeAll();
			ManageStudentInfoPanel studentInfoPanel = new ManageStudentInfoPanel(mFrame);
			contentPanel.add(studentInfoPanel);
			this.add(contentPanel, BorderLayout.CENTER);
			repaint();
			validate();
		}

		else if (e.getSource().equals(mCourseInfoMenu)) {
			contentPanel.removeAll();
			ManageCourseInfoPanel courseInfoPanel = new ManageCourseInfoPanel(mFrame);
			contentPanel.add(courseInfoPanel);
			this.add(contentPanel, BorderLayout.CENTER);
			repaint();
			validate();

		}

		else if (e.getSource().equals(mChooseCourseInfoMenu)) {
			contentPanel.removeAll();
			ManageChoicePanel choicePanel = new ManageChoicePanel(mFrame);
			contentPanel.add(choicePanel);
			this.add(contentPanel, BorderLayout.CENTER);
			repaint();
			validate();
		}
		else if (e.getSource().equals(mCrossChooseManageMenu)) {
			contentPanel.removeAll();
			ManageCrossChoosePanel choicePanel = new ManageCrossChoosePanel();
			contentPanel.add(choicePanel);
			this.add(contentPanel, BorderLayout.CENTER);
			repaint();
			validate();
		}

	}

	@Override
	public void menuDeselected(MenuEvent e) {
	}

	@Override
	public void menuCanceled(MenuEvent e) {
	}

}
