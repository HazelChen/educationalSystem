package emsystem.ui.student;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import emsystem.model.Course;
import emsystem.rmi.StudentServiceAdapter;
import emsystem.ui.widget.CustomedTable;

public class StudentCoursesPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7093934596570571594L;
	/**
	 * Create the panel.
	 */
	String[] classColumnName = new String[]{"课程编号","课程名称","课时","学分","授课老师","授课地点","课程成绩"};
	
	private int idIndex = 0, nameIndex =1, timeIndex = 2, creditIndex = 3, teacherIndex = 4, addressIndex = 5, scoreIndex = 6;
	private int tableColumnNums = 7;
	private CustomedTable mInfoTable;
	private String mAccount;
	
	public StudentCoursesPanel(String pAccount) {
		mAccount = pAccount;
		
		mInfoTable = new CustomedTable(getData(), classColumnName);
		
		JScrollPane scrollPane = new JScrollPane(mInfoTable);
		scrollPane.setPreferredSize(new Dimension(500, 350));
		add(scrollPane);
	}
	
	private Object[][] getData(){
		StudentServiceAdapter adapter = StudentServiceAdapter.getInstance();
		HashMap<Course, Integer>  coursesMap= adapter.getMyCourses(mAccount);
		Object[][] data = new Object[][]{};
		if (coursesMap != null) {
			Set<Course> courses = coursesMap.keySet();
			data = new Object[courses.size()][tableColumnNums];
			int i = 0;
			Iterator<Course> iterator = courses.iterator();
			while (iterator.hasNext()) {
				Course course = iterator.next();
				data[i][idIndex] = course.getId();
				data[i][nameIndex] = course.getCourseName();
				data[i][timeIndex] = course.getCourseTime();
				data[i][creditIndex] = course.getCredit();
				data[i][teacherIndex] = course.getTeacher();
				data[i][addressIndex] = course.getAddress();
				data[i][scoreIndex] = coursesMap.get(course);
				
				i++;
			}
				
		}
		return data;
	}

}
