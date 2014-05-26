package emsystem.ui.admin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.TableColumn;

import emsystem.model.Course;
import emsystem.rmi.AdminServiceAdapter;
import emsystem.ui.widget.CustomedTable;

public class ManageCrossChoosePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4499218856650261870L;
	/**
	 * Create the panel.
	 * 
	 */
	
	private static boolean chooseEnable = true;

	private JButton shareStudentButton;
	private JButton shareCourseButton;
	private JButton finishCrossChooseButton;
	
//	private JButton startButton;
	
	private JLabel tipMessage;
	
	private JScrollPane scrollPane;
	private CustomedTable mInfoTable;
	private String[] courseHeader  = new String[]{"课程编号", "课程名", "共享"};
	private int checkPosition = 2;
	private int idIndex = 0;

	public ManageCrossChoosePanel() {
		tipMessage = new JLabel("选课已结束");
		tipMessage.setVisible(false);
		add(tipMessage);
//		startButton = new JButton("点击开始选课");
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

		finishCrossChooseButton = new JButton("点击结束选课");
		finishCrossChooseButton.setPreferredSize(new Dimension(150, 30));
		finishCrossChooseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonsPanel.add(finishCrossChooseButton);

		buttonsPanel.add(new JLabel("          "));
		shareStudentButton = new JButton("共享学生信息");
		shareStudentButton.setPreferredSize(new Dimension(150, 30));
		buttonsPanel.add(shareStudentButton);
		

		add(buttonsPanel);

		add(new JLabel("       "));
		
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
		
		scrollPane = new JScrollPane();
		showTable();
		tablePanel.add(scrollPane);
		
		shareCourseButton = new JButton("共享课程");
		tablePanel.add(new JLabel("             "));
		tablePanel.add(shareCourseButton);
		
		add(tablePanel);

		addListeners();
		
		if (!chooseEnable) {
			disableChooose();
		}
	}

	private void addListeners() {
		shareStudentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminServiceAdapter adapter = AdminServiceAdapter.getInstance();
				adapter.postShareStudentAction();
				JOptionPane.showMessageDialog(null, "共享学生信息成功");
			}
		});

		finishCrossChooseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminServiceAdapter adapter = AdminServiceAdapter.getInstance();
				adapter.postFinishChooseAction();
				disableChooose();
			}
		});

		shareCourseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (getCheckedIds().size() == 0) {
					JOptionPane.showMessageDialog(null, "未选择任何课程");
					return;
				}
				AdminServiceAdapter adapter = AdminServiceAdapter.getInstance();
				adapter.postShareCourseAction(getCheckedIds());
				JOptionPane.showMessageDialog(null, "共享课程成功");
				showTable();
			}
		});
	}
	
	private void showTable(){
		mInfoTable = new CustomedTable(getData(), courseHeader) {
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
		scrollPane.setPreferredSize(new Dimension(500, 300));
	}
	
	private Object[][] getData(){
		Object[][] data = new Object[][]{{"1","2", false}};
		AdminServiceAdapter adapter = AdminServiceAdapter.getInstance();
		ArrayList<Course> courses = adapter.getUnsharedCourses();
		
		if (courses != null) {
			data = new Object[courses.size()][courseHeader.length];
			for (int i = 0; i < data.length; i++) {
				data[i][0] = courses.get(i).getId();
				data[i][1] = courses.get(i).getName();
				data[i][2] = false;
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
	

	private void disableChooose(){
		finishCrossChooseButton.setVisible(false);
		shareCourseButton.setVisible(false);
		shareStudentButton.setVisible(false);
		scrollPane.setVisible(false);
		
		tipMessage.setVisible(true);
		
		chooseEnable = false;
	}
	
	private void enableChooose(){
		finishCrossChooseButton.setVisible(true);
		shareCourseButton.setVisible(true);
		shareStudentButton.setVisible(true);
		scrollPane.setVisible(true);
		
		tipMessage.setVisible(false);
		
		chooseEnable = true;
	}
}
