package edu.nju.educationSystem.server.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import edu.nju.educationSystem.server.model.Student;
import edu.nju.educationSystem.server.service.StudentService;

public class StudentInfoPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * create the panel
	 */
	String[] infoColumnsName = new String[]{"学号","姓名","性别","院系"};	

	private CustomedTable table;
	private JScrollPane scrollPane;
	private int idIndex = 0, nameIndex =1, sexIndex = 2, majorIndex = 3;
	
	public StudentInfoPanel(){
		JButton button = new JButton("刷新");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table = new CustomedTable(getData(), infoColumnsName);
				scrollPane.setViewportView(table);
				scrollPane.invalidate();
				scrollPane.repaint();
				StudentInfoPanel.this.repaint();
			}
		});
		this.setLayout(new BorderLayout());
		this.add(button, BorderLayout.NORTH);
		table = new CustomedTable(getData(), infoColumnsName);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 300));
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private String[][] getData(){
		StudentService ss = new StudentService();
		ArrayList<Student> students = ss.getAll();
		Student student = null;
		String[][] data = new String[students.size()][infoColumnsName.length];
		for(int i=0; i< students.size(); i++){
			student = students.get(i);
			if (student != null) {
				data[i][idIndex] = student.getId();
				data[i][nameIndex] = student.getName();
				data[i][sexIndex] = student.getSex().toString();
				data[i][majorIndex] = student.getMajor().toString();
			}
		}
		return data;
	}
	
}
