package emsystem.ui.admin;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditStudentInfoPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public EditStudentInfoPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel.setBounds(60, 68, 103, 32);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(191, 68, 206, 35);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("ËÎÌו", Font.PLAIN, 15));
		textField_1.setBounds(191, 146, 206, 32);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("New label");
		label.setFont(new Font("Arial Black", Font.PLAIN, 15));
		label.setBounds(60, 146, 103, 32);
		add(label);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(191, 220, 206, 35);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(191, 286, 206, 35);
		add(textField_3);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		label_1.setBounds(60, 220, 103, 32);
		add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setFont(new Font("Arial Black", Font.PLAIN, 15));
		label_2.setBounds(60, 286, 103, 32);
		add(label_2);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(262, 350, 93, 23);
		add(btnNewButton);

	}
}
