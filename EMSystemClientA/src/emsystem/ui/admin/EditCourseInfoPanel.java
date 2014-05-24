package emsystem.ui.admin;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditCourseInfoPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public EditCourseInfoPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		lblNewLabel.setBounds(58, 37, 89, 36);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(159, 39, 136, 36);
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("New label");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		label.setBounds(58, 97, 89, 36);
		add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		label_1.setBounds(58, 152, 89, 36);
		add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		label_2.setBounds(58, 208, 89, 36);
		add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		label_3.setBounds(352, 152, 89, 36);
		add(label_3);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		label_4.setBounds(352, 97, 89, 36);
		add(label_4);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		label_5.setBounds(352, 208, 89, 36);
		add(label_5);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(159, 106, 136, 36);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(159, 161, 136, 36);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(159, 217, 136, 36);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(461, 106, 136, 36);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(461, 161, 136, 36);
		add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(461, 217, 136, 36);
		add(textField_6);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(284, 315, 93, 23);
		add(btnNewButton);

	}

}
