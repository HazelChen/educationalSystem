package emsystem.ui.admin;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import emsystem.model.Student;
import emsystem.rmi.AdminServiceAdapter;
import emsystem.ui.MainFrame;

public class ManageStudentInfoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7844157562610687848L;

	/**
	 * Create the panel.
	 */
	private JTable mTable;
	private JButton mEditButton;
	private JButton mDeleteButton;
	private JButton mAddButton;
	
	private JScrollPane scrollPane;

	private String[] infoColumnsName = new String[] { "学号", "姓名","密码", "性别", "院系" };

	private int columnNums = 5;
	private int idIndex = 0, nameIndex =1, passwordIndex = 2, sexIndex = 3, majorIndex = 4 ;
	
	private MainFrame mFrame;
	public ManageStudentInfoPanel(MainFrame pFrame) {
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

		mTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		scrollPane = new JScrollPane(mTable);
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
		ArrayList<Student> students = adapter.getStudents();
		Object[][] data = new Object[][]{};
		if (students != null) {
			data = new Object[students.size()][columnNums];
			for (int i = 0; i < data.length; i++) {
				Student student = students.get(i);
				data[i][idIndex] = student.getId();
				data[i][nameIndex] = student.getName();
				data[i][passwordIndex] = student.getmPassword();
				data[i][sexIndex] = student.getSex();
				data[i][majorIndex] = student.getMajor();
			}
		}
		return data;
	}

	private void setListeners() {
		mAddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EditStudentInfoPanel editStudentInfoPanel = new EditStudentInfoPanel(mFrame);
				mFrame.setContentPane(editStudentInfoPanel);
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
					String password = (String) mTable.getValueAt(row, passwordIndex);
					String sex = (String) mTable.getValueAt(row, sexIndex);
					String major = (String) mTable.getValueAt(row, majorIndex);
					
					Student student = new Student(id, name, sex, major, password);
					EditStudentInfoPanel editStudentInfoPanel = new EditStudentInfoPanel(mFrame,student);
					mFrame.setContentPane(editStudentInfoPanel);
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
		if (adapter.deleteStudent(pId)) {
			JOptionPane.showMessageDialog(null, "操作成功");
			refresh();
		}
		else
			JOptionPane.showMessageDialog(null, "删除失败");
	}
	
	private void showAlertMessage(){
		JOptionPane.showMessageDialog(null, "请选择要操作的行!");
	}
	
	private void refresh(){
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
		scrollPane.setViewportView(mTable);
	}
	
}
