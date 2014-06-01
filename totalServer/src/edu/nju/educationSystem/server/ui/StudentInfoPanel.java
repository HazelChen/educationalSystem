package edu.nju.educationSystem.server.ui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
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
	private int idIndex = 0, nameIndex =1, sexIndex = 2, majorIndex = 3;
	
	public StudentInfoPanel(){
		table = new CustomedTable(getData(), infoColumnsName);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 350));
		add(scrollPane);
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
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.add(new StudentInfoPanel());
		frame.setSize(600, 500);
		frame.setVisible(true);
	}
}
