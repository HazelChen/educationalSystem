package emsystem.ui.student;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import emsystem.data.Student;
import emsystem.rmi.StudentServiceAdapter;
import emsystem.ui.widget.CustomedTable;

public class StudentInfoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	String[] infoColumnsName = new String[]{"学号","姓名","性别","院系"};	
	private CustomedTable table;
	private String mAccount;
	
	public StudentInfoPanel(String pAccount) {
		table = new CustomedTable(getData(), infoColumnsName);
		mAccount = pAccount;
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 350));
		add(scrollPane);
		
	}
	
	private String[][] getData(){
		StudentServiceAdapter adapter = StudentServiceAdapter.getInstance();
		Student student = adapter.getStudentInfo(mAccount);

		String[][] data = new String[][]{};
		if (student != null) {
			data = new String[][]{{student.getId(), student.getName(), student.getSex(), student.getMajor()}};
		}
		return data;
	}

}
