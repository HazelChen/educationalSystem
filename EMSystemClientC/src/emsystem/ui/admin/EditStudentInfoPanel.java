package emsystem.ui.admin;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import emsystem.data.Student;
import emsystem.rmi.AdminServiceAdapter;
import emsystem.ui.MainFrame;

public class EditStudentInfoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8548611503087071673L;

	private String backToMainString = "<html><u>·µ»Ø²Ù×÷½çÃæ</u></html>";
	private String idString = "Ñ§Éú±àºÅ";
	private String nameString = "Ñ§ÉúÐÕÃû";
	private String passwordString = "ÃÜÂë";
	private String sexString = "ÐÔ±ð";
	private String majorString = "×¨Òµ";

	private String okButtonString = "È·ÈÏ";
	/**
	 * Create the panel.
	 */

	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton okButton;
	private MainFrame mFrame;

	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField passwrodField;
	private ButtonGroup sexButtonGroup;
	private JRadioButton maleButton;
	private JRadioButton femaleButton;

	private JTextField majorTextField;

	private Student mStudent;

	public EditStudentInfoPanel(MainFrame pFrame) {
		mFrame = pFrame;
		initAdd();
	}

	public EditStudentInfoPanel(MainFrame pFrame, Student pStudent) {
		mFrame = pFrame;
		mStudent = pStudent;
		initEdit();

	}

	private void init() {
		setLayout(null);

		idTextField = new JTextField();
		idTextField.setBounds(303, 68, 206, 35);
		add(idTextField);
		idTextField.setColumns(10);

		JLabel label = new JLabel(idString);
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		label.setBounds(190, 69, 103, 32);
		add(label);

		JLabel label_1 = new JLabel(nameString);
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		label_1.setBounds(190, 133, 103, 32);
		add(label_1);

		JLabel label_2 = new JLabel(sexString);
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		label_2.setBounds(214, 253, 103, 32);
		add(label_2);

		lblNewLabel = new JLabel(majorString);
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		lblNewLabel.setBounds(214, 306, 103, 32);
		add(lblNewLabel);

		okButton = new JButton(okButtonString);
		okButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		okButton.setBounds(350, 361, 115, 32);
		add(okButton);

		lblNewLabel_1 = new JLabel(backToMainString);
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));

		lblNewLabel_1.setBounds(24, 21, 103, 20);
		add(lblNewLabel_1);

		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(303, 133, 206, 35);
		add(nameTextField);

		majorTextField = new JTextField();
		majorTextField.setColumns(10);
		majorTextField.setEditable(false);
		majorTextField.setBounds(303, 306, 206, 35);
		add(majorTextField);

		sexButtonGroup = new ButtonGroup();
		maleButton = new JRadioButton("ÄÐ");
		maleButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		maleButton.setBounds(303, 253, 100, 35);
		add(maleButton);

		femaleButton = new JRadioButton("Å®");
		femaleButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		femaleButton.setBounds(405, 252, 100, 35);
		add(femaleButton);

		sexButtonGroup.add(maleButton);
		sexButtonGroup.add(femaleButton);

		JLabel label_3 = new JLabel(passwordString);
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		label_3.setBounds(214, 196, 103, 32);
		add(label_3);

		passwrodField = new JTextField();
		passwrodField.setColumns(10);
		passwrodField.setBounds(303, 196, 206, 35);
		add(passwrodField);

		lblNewLabel_1.addMouseListener(new MouseAdapter() {
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

	}

	private void initAdd() {
		init();
		maleButton.setSelected(true);
		majorTextField.setText(AdminServiceAdapter.getInstance().getMajorName());
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getNewInfo() != null) {
					AdminServiceAdapter adapter = AdminServiceAdapter
							.getInstance();
					if (adapter.addStudent(getNewInfo()))
						showSuccessMessage();
					else
						showFailMessage();
				}
			}
		});
	}

	private void initEdit() {
		init();

		idTextField.setText(mStudent.getId());
		nameTextField.setText(mStudent.getName());
		passwrodField.setText(mStudent.getPwd());
		if (mStudent.getSex().equals("ÄÐ")) {
			maleButton.setSelected(true);
		} else {
			femaleButton.setSelected(true);
		}
		majorTextField.setText(mStudent.getMajor());

		idTextField.setEditable(false);
		majorTextField.setEditable(false);
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getNewInfo() != null) {
					AdminServiceAdapter adapter = AdminServiceAdapter
							.getInstance();
					if (adapter.modifyStudent(getNewInfo())){
						showSuccessMessage();
						clear();
					}
					else
						showFailMessage();
				}
			}
		});
	}

	private Student getNewInfo() {
		Student student = null;
		String newId = idTextField.getText();
		String newPassword = passwrodField.getText();
		String newName = nameTextField.getText();
		String newSex = maleButton.isSelected() ? "ÄÐ" : "Å®";
		String newMajor = majorTextField.getText();

		if (newId.equals("") || newName.equals("") || newPassword.equals("")
				|| newMajor.equals("")) {
			showAlertMessage();
		} else
			student = new Student(newId, newName, newSex, newMajor, newPassword);

		return student;

	}

	private void showAlertMessage() {
		JOptionPane.showMessageDialog(null, "ÐÅÏ¢ÌîÐ´²»ÍêÕû");
	}

	private void showSuccessMessage() {
		JOptionPane.showMessageDialog(null, "²Ù×÷³É¹¦");
	}

	private void showFailMessage() {
		JOptionPane.showMessageDialog(null, "²Ù×÷Ê§°Ü");
	}
	
	private void clear(){
		idTextField.setText("");
		passwrodField.setText("");
		maleButton.setSelected(true);
		femaleButton.setSelected(false);
	}
}
