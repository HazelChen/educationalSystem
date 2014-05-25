package emsystem.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import emsystem.rmi.AdminServiceAdapter;
import emsystem.rmi.StudentServiceAdapter;
import emsystem.ui.admin.AdminOperationPanel;
import emsystem.ui.student.StudentOperationPanel;

public class LoginPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7651119794013460637L;
	private static String systemName = "教务系统C"; 
	private String mTypeString = "身份";
	private String mAccountString = "账号";
	private String mPasswordString = "密码";
	private String mStudentString = "学生";
	private String mAdminString = "管理员";
	private String mButtonString = "登录";
	/**
	 * Create the panel.
	 */
	private MainFrame mFrame;
	private JComboBox<String> comboBox;
	private JTextField textField_1;
	private JPasswordField textField;
	public LoginPanel(MainFrame pFrame) {
		mFrame = pFrame;
		setLayout(null);
		setBounds(0, 0, 800, 600);
		JLabel nameLabel = new JLabel(systemName);
		nameLabel.setBounds(349, 63, 134, 24);
		nameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 23));
		add(nameLabel);
		
		JLabel label = new JLabel(mTypeString);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label.setBounds(291, 168, 46, 15);
		add(label);
		
		
		comboBox = new JComboBox<String>();
		comboBox.addItem(mStudentString);
		comboBox.addItem(mAdminString);
		comboBox.setSelectedItem(mStudentString);
		comboBox.setBounds(349, 166, 134, 21);
		
		
		add(comboBox);
		
		JLabel label_1 = new JLabel(mAccountString);
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_1.setBounds(291, 222, 54, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel(mPasswordString);
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_2.setBounds(291, 276, 54, 15);
		add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(349, 219, 134, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JPasswordField();
		textField.setColumns(10);
		textField.setBounds(349, 273, 134, 24);
		add(textField);
		
		JButton btnNewButton = new JButton(mButtonString);
		btnNewButton.setBounds(370, 331, 93, 30);
		add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String account = textField_1.getText().trim();
				String password = new String(textField.getPassword());
				
				if (comboBox.getSelectedIndex() == 0) {
					StudentServiceAdapter adapter = StudentServiceAdapter.getInstance();
					if (adapter.studentLogin(account, password)) {
						StudentOperationPanel studentOperationPanel = new StudentOperationPanel(mFrame, account);
						mFrame.setContentPane(studentOperationPanel);
						mFrame.validate();
					}
					else 
						showMessage();
				}
				else if (comboBox.getSelectedIndex() == 1) {
					AdminServiceAdapter adapter = AdminServiceAdapter.getInstance();
					if (adapter.adminLogin(account, password)) {
						
						AdminOperationPanel operationPanel = new AdminOperationPanel(mFrame);
						mFrame.setContentPane(operationPanel);
						mFrame.validate();
					}
					else {
						showMessage();
					}
				}
				
			}
		});
	}
	
	private void showMessage(){
		JOptionPane.showMessageDialog(null, "用户名或密码错误");
	}
}
