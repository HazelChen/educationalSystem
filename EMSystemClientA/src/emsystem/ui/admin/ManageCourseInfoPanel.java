package emsystem.ui.admin;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import emsystem.data.Course;
import emsystem.rmi.AdminServiceAdapter;
import emsystem.ui.MainFrame;

public class ManageCourseInfoPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5382239487717069420L;
	/**
	 * Create the panel.
	 */
	private JTable mTable;
	private JButton mEditButton;
	private JButton mDeleteButton;
	private JButton mAddButton;

	String[] infoColumnsName = new String[]{"课程编号","课程名称","课时","学分","授课老师","授课地点","是否共享"};

	private int columnNums = 7;
	private int idIndex = 0, nameIndex =1, timeIndex = 2, creditIndex = 3, teacherIndex = 4 , addressIndex = 5, shareIndex = 6;
	
	private MainFrame mFrame;
	public ManageCourseInfoPanel(MainFrame pFrame) {
		mFrame = pFrame;
		initView();
		setListeners();
	}

	private void initView() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		mTable = new JTable(getData(), infoColumnsName){
			/**
			 * 
			 */
			private static final long serialVersionUID = -4155819880040959665L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		mTable.getTableHeader().setReorderingAllowed(false);

		JScrollPane scrollPane = new JScrollPane(mTable);
		add(scrollPane);

		JPanel operatePanel = new JPanel();
		operatePanel.setLayout(new FlowLayout());
		
		mAddButton = new JButton("添加");
		
		mEditButton = new JButton("修改");

		mDeleteButton = new JButton("删除");

		operatePanel.add(mAddButton);
		operatePanel.add(mEditButton);
		operatePanel.add(mDeleteButton);
		add(operatePanel);

	}

	private Object[][] getData() {
		AdminServiceAdapter adapter = AdminServiceAdapter.getInstance();
		ArrayList<Course> courses = adapter.getCourses();
		Object[][] data = new Object[][]{};
		if (courses != null) {
			data = new Object[courses.size()][columnNums];
			for (int i = 0; i < data.length; i++) {
				Course course = courses.get(i);
				data[i][idIndex] = course.getId();
				data[i][nameIndex] = course.getCourseName();
				data[i][timeIndex] = course.getCourseTime();
				data[i][creditIndex] = course.getCredit();
				data[i][teacherIndex] = course.getTeacher();
				data[i][addressIndex] = course.getAddress();
				data[i][shareIndex] = course.getShareFlag();
			}
		}
		return data;
	}

	private void setListeners() {
		mAddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EditCourseInfoPanel editCourseInfoPanel = new EditCourseInfoPanel(mFrame);
				mFrame.setContentPane(editCourseInfoPanel);
				mFrame.validate();
				mFrame.repaint();
			}
		});
		mEditButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (mTable.getSelectedRow() == -1) {
					showAlertMessage();
				}else {
					int row = mTable.getSelectedRow();
					String id = (String) mTable.getValueAt(row, idIndex);
					String name = (String) mTable.getValueAt(row, nameIndex);
//					String password = (String) mTable.getValueAt(row, passwordIndex);
//					String sex = (String) mTable.getValueAt(row, sexIndex);
//					String major = (String) mTable.getValueAt(row, majorIndex);
					
//					String[] info = new String[]{id, name, password, sex, major};
//					EditStudentInfoPanel editStudentInfoPanel = new EditStudentInfoPanel(mFrame,info);
//					mFrame.setContentPane(editStudentInfoPanel);
					mFrame.validate();
					mFrame.repaint();
				}
			}
		});
		mDeleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (mTable.getSelectedRow() == -1) {
					showAlertMessage();
				}else {
					delete();
				}
			}
		});
	}
	
	private void delete(){
		String pId = (String) mTable.getValueAt(mTable.getSelectedRow(), idIndex);
		AdminServiceAdapter adapter = AdminServiceAdapter.getInstance();
		if (adapter.deleteStudent(pId)) 
			JOptionPane.showMessageDialog(null, "操作成功");
		else
			JOptionPane.showMessageDialog(null, "删除失败");
	}
	
	private void showAlertMessage(){
		JOptionPane.showMessageDialog(null, "请选择要操作的行!");
	}
	
}
