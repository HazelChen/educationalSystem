package emsystem.ui.student;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import emsystem.data.Course;
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
		Course[] courses = adapter.getMyCourses(mAccount);
		int[] scores = adapter.getScores(mAccount);
		Object[][] data = new Object[][]{};
		if (courses != null && scores != null) {
			data = new Object[courses.length][tableColumnNums];
			for (int i = 0; i < courses.length; i++) {
				data[i][idIndex] = courses[i].getId();
				data[i][nameIndex] = courses[i].getCourseName();
				data[i][timeIndex] = courses[i].getCourseTime();
				data[i][creditIndex] = courses[i].getCredit();
				data[i][teacherIndex] = courses[i].getTeacher();
				data[i][addressIndex] = courses[i].getAddress();
				data[i][scoreIndex] = scores[i];
			}
		}
		return data;
	}

}
