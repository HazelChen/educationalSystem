package emsystem.ui.admin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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
	private JScrollPane courseScrollPane;
	private JScrollPane studentScrollPane;
	
	private JTable mCourseTable;
	private JTable mStudentTable;
	
	private JButton mButton;
	
	private String[] coursesColumnName = new String[]{"课程编号","课程名"};
	private String[] studentColumnName = new String[]{"学生编号","姓名","所属院系"};
	
	private int courseIdIndex = 0;
	private MainFrame mFrame;
	
	public ManageChoicePanel(MainFrame pFrame) {
		mFrame = pFrame;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel infoTablePanel = new JPanel();
		infoTablePanel.setLayout(new BorderLayout());
		
		JPanel coursePanel = new JPanel();
		coursePanel.setLayout(new BoxLayout(coursePanel, BoxLayout.Y_AXIS));
		JLabel courseLabel = new JLabel("课程");
		courseLabel.setBounds(83, 59, 54, 15);
		coursePanel.add(courseLabel);
		
		courseScrollPane = new JScrollPane();
		courseScrollPane.setPreferredSize(new Dimension(350, 400));
		coursePanel.add(courseScrollPane);

		JPanel studentPanel = new JPanel();
		studentPanel.setLayout(new BoxLayout(studentPanel, BoxLayout.Y_AXIS));
		JLabel studentLabel = new JLabel("学生");
		studentLabel.setBounds(468, 59, 54, 15);
		studentPanel.add(studentLabel);
		
		studentScrollPane = new JScrollPane();
		studentScrollPane.setPreferredSize(new Dimension(350, 400));
		studentPanel.add(studentScrollPane);
		
		infoTablePanel.add(coursePanel, BorderLayout.WEST);
		infoTablePanel.add(studentPanel, BorderLayout.EAST);
		
		add(infoTablePanel);
		
		generateCourseTable();
	}
	
	private void generateCourseTable(){
		mCourseTable = new JTable(getCourseData(), coursesColumnName){
			/**
			 * 
			 */
			private static final long serialVersionUID = -6797344357042781916L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		mCourseTable.getTableHeader().setReorderingAllowed(false);
		
		mCourseTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int sr;
                if ((sr = mCourseTable.getSelectedRow()) == -1) {
                    return;
                }
                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1){
                	String id = (String) mCourseTable.getValueAt(mCourseTable.getSelectedRow(), courseIdIndex);
                	generateStudentTable(id);
                	validate();
                	repaint();
                	
                }
            }
        });
		courseScrollPane.setViewportView(mCourseTable);
	}
	
	private void generateStudentTable(String pCourseId){
		mStudentTable = new JTable(getStudentData(pCourseId), studentColumnName){
			/**
			 * 
			 */
			private static final long serialVersionUID = -4155819880040959665L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		mStudentTable.getTableHeader().setReorderingAllowed(false);
		studentScrollPane.setViewportView(mStudentTable);
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
			data[i][2] = students.get(i).getMajor();
		}
		return data;
	}
}
