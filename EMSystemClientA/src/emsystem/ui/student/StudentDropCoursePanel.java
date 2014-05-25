package emsystem.ui.student;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.TableColumn;

import emsystem.data.Course;
import emsystem.rmi.StudentServiceAdapter;
import emsystem.ui.widget.CustomedTable;

public class StudentDropCoursePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7071721970040736891L;
	/**
	 * Create the panel.
	 */
	private String dropClassString = "确认退课";
	private String[] dropClassColumnName = new String[] { "课程编号", "课程名称", "课时",
			"学分", "授课老师", "授课地点", "退课" };
	private int columnNums = 7;
	private int idIndex = 0, nameIndex = 1, timeIndex = 2, creditIndex = 3,
			teacherIndex = 4, addressIndex = 5, dropIndex = 6;

	private JScrollPane scrollPane;
	private CustomedTable mInfoTable;
	private JButton dropButton;

	private static int checkPosition = 6;

	/**
	 * Create the panel.
	 */
	private String mAccount;

	public StudentDropCoursePanel(String pAccount) {
		mAccount = pAccount;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		scrollPane = new JScrollPane();
		// scrollPane.setPreferredSize(new Dimension(500, 350));

		showTable();

		dropButton = new JButton(dropClassString);
		add(scrollPane);
		add(dropButton);

		addListeners();
	}

	private void showTable() {

		mInfoTable = new CustomedTable(getData(), dropClassColumnName) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -40319070391013926L;

			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == checkPosition) {
					return true;
				}
				return false;
			}
		};
		TableColumn aColumn = mInfoTable.getColumnModel().getColumn(
				checkPosition); // 设置第几列
		aColumn.setCellEditor(mInfoTable.getDefaultEditor(Boolean.class));
		aColumn.setCellRenderer(mInfoTable.getDefaultRenderer(Boolean.class));

		scrollPane.setViewportView(mInfoTable);
		scrollPane.invalidate();
		scrollPane.repaint();
		scrollPane.setPreferredSize(new Dimension(500, 350));

	}

	private void addListeners() {

		dropButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (getCheckedIds().size() == 0) {
					JOptionPane.showMessageDialog(null, "未选择任何课程");
				}
				else {
					doPost();
					JOptionPane.showMessageDialog(null, "退课成功");
				}
			}
		});

	}

	private Object[][] getData() {
		StudentServiceAdapter adapter = StudentServiceAdapter.getInstance();
		HashMap<Course, Integer>  coursesMap= adapter.getMyCourses(mAccount);
		Object[][] data = new Object[][]{};
		if (coursesMap != null) {
			Set<Course> courses = coursesMap.keySet();
			data = new Object[courses.size()][columnNums];
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
				
				i++;
			}
				
		}
		return data;
	}
	private ArrayList<String> getCheckedIds() {
		ArrayList<String> indexes = new ArrayList<>();
		for (int i = 0; i < getData().length; i++) {
			if (((Boolean) mInfoTable.getValueAt(i, checkPosition))
					.booleanValue()) {// 选中
				indexes.add((String) mInfoTable.getValueAt(i, idIndex));
			}
		}
		return indexes;
	}
	
	private void doPost(){
		StudentServiceAdapter adapter = StudentServiceAdapter.getInstance();
		adapter.dropCourses(mAccount, getCheckedIds());
	}
}
