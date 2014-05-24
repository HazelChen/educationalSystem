package emsystem.ui.admin;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import emsystem.data.Course;
import emsystem.data.Student;
import emsystem.rmi.AdminServiceAdapter;
import emsystem.ui.MainFrame;

public class ManageChoicePanel extends JPanel {

	private static final long serialVersionUID = -2731729423693467706L;
	/**
	 * Create the panel.
	 */
	
	private JLabel backLabel;
	private JScrollPane courseScrollPane;
	private JScrollPane studentScrollPane;
	
	private JTable mCourseTable;
	private JTable mStudentTable;
	
	private String[] coursesColumnName = new String[]{"课程编号","课程名"};
	private String[] studentColumnName = new String[]{"学生编号","姓名"};
	
	private MainFrame mFrame;
	public ManageChoicePanel(MainFrame pFrame) {
		setLayout(null);
		
		backLabel = new JLabel("<html><u>返回操作界面</u></html>");
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
		backLabel.setBounds(41, 34, 54, 15);
		add(backLabel);
		
		JLabel courseLabel = new JLabel("课程");
		courseLabel.setBounds(86, 82, 54, 15);
		add(courseLabel);
		
		JLabel studentLabel = new JLabel("学生");
		studentLabel.setBounds(470, 82, 54, 15);
		add(studentLabel);
		
		courseScrollPane = new JScrollPane();
		courseScrollPane.setBounds(274, 459, 252, 342);
		add(courseScrollPane);
		
		studentScrollPane = new JScrollPane();
		studentScrollPane.setBounds(404, 448, 225,320);
		add(studentScrollPane);
	}
	
	private void generateCourseTable(){
		mCourseTable = new JTable(getCourseData(), coursesColumnName){
			/**
			 * 
			 */
			private static final long serialVersionUID = -4155819880040959665L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		mCourseTable.getTableHeader().setReorderingAllowed(false);
	}
	
	private Object[][] getCourseData(){
		Object[][] data = new Object[][]{};
		AdminServiceAdapter adapter = AdminServiceAdapter.getInstance();
		ArrayList<Course> courses = adapter.getCourses();
		data = new Object[courses.size()][coursesColumnName.length];
		
		for (int i = 0; i < data.length; i++) {
			data[i][0] = courses.get(i).getId();
			data[i][1] = courses.get(i).getCourseName();
		}
		return data;
	}
	
	private Object[][] getStudentData(String pCourseId){
		Object[][] data = new Object[][]{};
		AdminServiceAdapter adapter = AdminServiceAdapter.getInstance();
		ArrayList<Student> students = adapter.getChoosedStudents(pCourseId);
		data = new Object[students.size()][studentColumnName.length];
		
		for (int i = 0; i < data.length; i++) {
			data[i][0] = students.get(i).getId();
			data[i][1] = students.get(i).getName();
		}
		return data;
	}
}
