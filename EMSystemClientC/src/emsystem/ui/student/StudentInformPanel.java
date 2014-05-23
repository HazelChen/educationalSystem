package emsystem.ui.student;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import emsystem.logic.Inform;
import emsystem.rmi.StudentServiceAdapter;
import emsystem.ui.MainFrame;

public class StudentInformPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6585168159770973869L;
	/**
	 * Create the panel.
	 */
	private MainFrame mFrame;
	private String mAccount;
	public StudentInformPanel(MainFrame pFrame, String pAccount) {
		mFrame = pFrame;
		mAccount = pAccount;
		init();
	}
	
	private void init(){
		JPanel contentPanel = new JPanel();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		
		
		HashMap<String, ArrayList<String>> map = Inform.getInforMessages(mAccount);
		ArrayList<String> messages = map.get(mAccount);
		
		if (messages.size() == 0) {
			removeAll();
			JLabel label = new JLabel("当前没有通知消息！");
			contentPanel.add(label);
			
			
		}
		else {
			removeAll();
			StudentServiceAdapter adapter = StudentServiceAdapter.getInstance();
			boolean[] results = adapter.chooseCourses(mAccount, messages);
			for (int i = 0; i < messages.size(); i++) {
//				String message = adapter.get
				String result = results[i] ? "成功":"失败";
				JLabel label = new JLabel("课程编号为" + messages.get(i) + "选课" + result);
				contentPanel.add(label);
			}
		}
		JButton backButton = new JButton("返回主界面");
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				StudentOperationPanel operationPanel = new StudentOperationPanel(mFrame, mAccount);
				mFrame.setContentPane(operationPanel);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(200, 300));
		scrollPane.setViewportView(contentPanel);
		
		add(scrollPane);
		add(backButton);
		
		mFrame.setContentPane(this);
		mFrame.validate();
		mFrame.repaint();
		
	}

	
}
