package emsystem.ui.student;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.TableColumn;

import emsystem.data.Course;
import emsystem.logic.Inform;
import emsystem.rmi.StudentServiceAdapter;
import emsystem.ui.widget.CustomedTable;

public class StudentChooseCoursePanel extends JPanel {
	private static final long serialVersionUID = -6488970245233729067L;

	private String chooseClassString = "确认选课";
	private String[] chooseClassColumnName = new String[] { "课程编号", "课程名称",
			"课时", "学分", "授课老师", "授课地点", "选课" };
	private int columnNums = 7;
	private int idIndex = 0, nameIndex = 1, timeIndex = 2, creditIndex = 3,
			teacherIndex = 4, addressIndex = 5, chooseindex = 6;
	private String[] options = new String[] { "请选择院系", "院系A", "院系B", "院系C" };

	private JComboBox<String> comboBox;

	private JScrollPane scrollPane;
	private CustomedTable mInfoTable;
	private JButton chooseButton;

	private static int checkPosition = 6;

	/**
	 * Create the panel.
	 */
	private String mAccount;

	public StudentChooseCoursePanel(String pAccount) {
		mAccount = pAccount;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		comboBox = new JComboBox<String>(options);
		comboBox.setPreferredSize(new Dimension(150, 30));
		comboBox.setSelectedIndex(0);
		add(comboBox);

		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(500, 350));
		scrollPane.setVisible(false);

		chooseButton = new JButton(chooseClassString);
		chooseButton.setVisible(false);
		add(scrollPane);
		add(chooseButton);

		addListeners();
	}

	private void addListeners() {
		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == e.SELECTED) {
					switch (comboBox.getSelectedIndex()) {
					case 0:
						break;
					case 1:
						showMajorA();
						break;
					case 2:
						showMajorB();
						break;
					case 3:
						showMajorC();
						break;
					default:
						break;
					}
				}
			}
		});

		chooseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (getCheckedIds().size() == 0) {
					JOptionPane.showMessageDialog(null, "未选择任何课程");
					return;
				}
				doPost();
			}
		});

	}

	private void showMajorA() {
		scrollPane.setVisible(true);

		chooseButton.setVisible(true);

		mInfoTable = new CustomedTable(getAData(), chooseClassColumnName) {
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

	private void showMajorB() {
		scrollPane.setVisible(true);
		chooseButton.setVisible(true);

		mInfoTable = new CustomedTable(getBData(), chooseClassColumnName) {
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

	private void showMajorC() {
		scrollPane.setVisible(true);
		chooseButton.setVisible(true);

		mInfoTable = new CustomedTable(getCData(), chooseClassColumnName) {
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

	private Object[][] getAData() {

		StudentServiceAdapter adapter = StudentServiceAdapter.getInstance();
		ArrayList<Course> courses = adapter.getCoursesFromA(mAccount);
		
		return getInitData(courses);
	}

	private Object[][] getBData() {
		StudentServiceAdapter adapter = StudentServiceAdapter.getInstance();
		ArrayList<Course> courses = adapter.getCoursesFromB(mAccount);
		
		return getInitData(courses);
	}

	private Object[][] getCData() {
		StudentServiceAdapter adapter = StudentServiceAdapter.getInstance();
		ArrayList<Course> courses = adapter.getCoursesFromC(mAccount);
		
		return getInitData(courses);
	}

	private Object[][] getInitData(ArrayList<Course> courses){
		Object[][] data = new Object[][]{};
		if (courses != null) {
			data = new Object[courses.size()][columnNums];
			for (int i = 0; i < courses.size(); i++) {
				Course course = courses.get(i);
				data[i][idIndex] = course.getId();
				data[i][nameIndex] = course.getCourseName();
				data[i][timeIndex] = course.getCourseTime();
				data[i][creditIndex] = course.getCredit();
				data[i][teacherIndex] = course.getTeacher();
				data[i][addressIndex] = course.getAddress();
				data[i][chooseindex] = false;
			}
		}
		return data;
	}
	
	private ArrayList<String> getCheckedIds() {
		ArrayList<String> indexes = new ArrayList<>();
		for (int i = 0; i < getAData().length; i++) {
			if (((Boolean) mInfoTable.getValueAt(i, checkPosition))
					.booleanValue()) {// 选中
				indexes.add((String) mInfoTable.getValueAt(i, idIndex));
			}
		}
		return indexes;
	}
	
	private void doPost(){
		JOptionPane.showMessageDialog(null, "已提交选课请求，稍后查看选课结果通知:D");
		HashMap<String, ArrayList<String>> messages = new HashMap<String, ArrayList<String>>();
		messages.put(mAccount, getCheckedIds());
		Inform.setMessages(messages);
	}

}
