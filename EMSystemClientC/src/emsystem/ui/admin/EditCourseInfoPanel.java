package emsystem.ui.admin;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import emsystem.data.Course;
import emsystem.rmi.AdminServiceAdapter;
import emsystem.ui.MainFrame;

public class EditCourseInfoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4741102403219896539L;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField timeTextField;
	private JTextField creditTextField;
	private JTextField teacherTextField;
	private JTextField addressTextField;

	private JCheckBox shareCheck;
	JButton okButton;

	private String idString = "课程编号";
	private String nameString = "课程名称";
	private String timeString = "课时";
	private String creditString = "学分";
	private String teacherString = "老师";
	private String addressString = "地点";
	private String shareString = "共享";

	private String backString = "<html><u>返回操作界面</u></html>";
	/**
	 * Create the panel.
	 */
	private MainFrame mFrame;
	private Course mCourse;

	public EditCourseInfoPanel(MainFrame pFrame) {
		mFrame = pFrame;
		initAdd();
		
	}

	public EditCourseInfoPanel(MainFrame pFrame, Course pCourse) {
		mFrame = pFrame;
		mCourse = pCourse;
		initEdit();
	}

	private void init(){
		setLayout(null);

		JLabel idLable = new JLabel(idString);
		idLable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		idLable.setBounds(163, 107, 89, 36);
		add(idLable);

		idTextField = new JTextField();
		idTextField.setBounds(262, 109, 136, 36);
		add(idTextField);
		idTextField.setColumns(10);

		JLabel nameLabel = new JLabel(nameString);
		nameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		nameLabel.setBounds(163, 170, 89, 36);
		add(nameLabel);

		JLabel timeLabel = new JLabel(timeString);
		timeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		timeLabel.setBounds(192, 225, 89, 36);
		add(timeLabel);

		JLabel creditLabel = new JLabel(creditString);
		creditLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		creditLabel.setBounds(192, 285, 89, 36);
		add(creditLabel);

		JLabel addressLlabel = new JLabel(addressString);
		addressLlabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		addressLlabel.setBounds(468, 225, 89, 36);
		add(addressLlabel);

		JLabel teacherLabel = new JLabel(teacherString);
		teacherLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		teacherLabel.setBounds(468, 170, 89, 36);
		add(teacherLabel);

		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(262, 172, 136, 36);
		add(nameTextField);

		timeTextField = new JTextField();
		timeTextField.setColumns(10);
		timeTextField.setBounds(262, 227, 136, 36);
		add(timeTextField);

		creditTextField = new JTextField();
		creditTextField.setColumns(10);
		creditTextField.setBounds(262, 287, 136, 36);
		add(creditTextField);

		teacherTextField = new JTextField();
		teacherTextField.setColumns(10);
		teacherTextField.setBounds(514, 172, 136, 36);
		add(teacherTextField);

		addressTextField = new JTextField();
		addressTextField.setColumns(10);
		addressTextField.setBounds(514, 227, 136, 36);
		add(addressTextField);

		okButton = new JButton("确认");
		okButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		okButton.setBounds(387, 382, 93, 36);
		add(okButton);

		shareCheck = new JCheckBox(shareString);
		shareCheck.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		shareCheck.setBounds(474, 293, 103, 23);
		add(shareCheck);

		JLabel backLabel = new JLabel(backString);
		backLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminOperationPanel operationPanel = new AdminOperationPanel(
						mFrame);
				mFrame.setContentPane(operationPanel);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		backLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		backLabel.setBounds(35, 24, 103, 29);
		add(backLabel);
		
		

	}
	private void initAdd() {
		init();
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (getCourseInfo() != null) {

					AdminServiceAdapter adapter = AdminServiceAdapter
							.getInstance();
					if (adapter.addCourse(getCourseInfo())) {
						showSuccessMessage();
						clear();
					} else
						showFailMessage();
				}
			}
		});
	}

	private void initEdit() {
		init();
		idTextField.setEditable(false);
		if (mCourse.getShareFlag().equals("是")) {
			shareCheck.setEnabled(false);
		}

		idTextField.setText(mCourse.getId());
		nameTextField.setText(mCourse.getCourseName());
		timeTextField.setText(mCourse.getCourseTime()+"");
		teacherTextField.setText(mCourse.getTeacher());
		addressTextField.setText(mCourse.getAddress());
		creditTextField.setText(mCourse.getCredit()+"");
		shareCheck.setSelected(mCourse.getShareFlag().equals("是"));
		
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (getCourseInfo() != null) {
					AdminServiceAdapter adapter = AdminServiceAdapter.getInstance();

					if (adapter.modifyCourse(getCourseInfo())) {
						showSuccessMessage();
					} else
						showFailMessage();
				}
			}
		});
	}

	private Course getCourseInfo() {
		Course course = null;
		String courseId = idTextField.getText().trim();
		String courseName = nameTextField.getText().trim();
		String timeString = timeTextField.getText().trim();
		String teacher = teacherTextField.getText().trim();
		String address = addressTextField.getText().trim();
		String creditString = creditTextField.getText().trim();

		if (courseId.equals("") || courseName.equals("") || timeString.equals("")
				|| teacher.equals("") || address.equals("")
				|| creditString.equals("")) {
			showAlertMessage();
		} else if (!isDigit(creditString) || !isDigit(timeString)) {
			showCreditError();
		} else {
			int credit, time;
			credit = Integer.valueOf(creditString);
			time  = Integer.valueOf(timeString);
			
			String shareFlag = shareCheck.isSelected() ? "是" : "否";

			course = new Course(courseId, courseName, credit, time, teacher,
					address, shareFlag);
		}
		return course;
	}

	private void clear() {
		idTextField.setText("");
		nameTextField.setText("");
		nameTextField.setText("");
		timeTextField.setText("");
		teacherTextField.setText("");
		addressTextField.setText("");
		creditTextField.setText("");
		shareCheck.setSelected(false);

	}

	private void showAlertMessage() {
		JOptionPane.showMessageDialog(null, "信息填写不完全");
	}

	private void showCreditError() {
		JOptionPane.showMessageDialog(null, "学分务必为数字");
	}

	private void showSuccessMessage() {
		JOptionPane.showMessageDialog(null, "操作成功");
	}

	private void showFailMessage() {
		JOptionPane.showMessageDialog(null, "操作失败");
	}

	private boolean isDigit(String credit) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(credit).matches();
	}
}
