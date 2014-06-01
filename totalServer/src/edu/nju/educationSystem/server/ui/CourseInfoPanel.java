package edu.nju.educationSystem.server.ui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import edu.nju.educationSystem.server.model.Course;
import edu.nju.educationSystem.server.service.CourseService;

public class CourseInfoPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * create the panel
	 */
	String[] infoColumnsName = new String[]{"课程编号","课程名称","课时","学分","授课老师","授课地点"};

	private CustomedTable table;
	private int idIndex = 0, nameIndex =1, timeIndex = 2, creditIndex = 3, teacherIndex = 4 , addressIndex = 5;
	
	public CourseInfoPanel(){
		table = new CustomedTable(getData(), infoColumnsName);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 350));
		add(scrollPane);
	}

	private String[][] getData() {
		CourseService cs = new CourseService();
		ArrayList<Course> courses = cs.getAll();
		Course course = null;
		String[][] data = new String[courses.size()][infoColumnsName.length];
		for(int i=0; i< courses.size(); i++){
			course = courses.get(i);
			if(course!=null){
				data[i][idIndex] = course.getId();
				data[i][nameIndex] = course.getName();
				data[i][timeIndex] 	=	String.valueOf(course.getTime());
				data[i][creditIndex] = String.valueOf(course.getScore());
				data[i][teacherIndex] = course.getTeacher();
				data[i][addressIndex] = course.getLocation();
			}
		}
		return data;
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.add(new CourseInfoPanel());
		frame.setSize(600, 500);
		frame.setVisible(true);
	}
}
