package emsystem.ui.admin;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdminStudentInfoPanel extends JPanel {

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

	private String[] infoColumnsName = new String[] { "学号", "姓名", "性别", "院系" };

	private int idColumnNum = 0;
	
	public AdminStudentInfoPanel() {
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

		JScrollPane scrollPane = new JScrollPane(mTable);
		add(scrollPane);

		JPanel operatePanel = new JPanel();
		operatePanel.setLayout(new FlowLayout());
		mEditButton = new JButton("修改");

		mDeleteButton = new JButton("删除");

		operatePanel.add(mEditButton);
		operatePanel.add(mDeleteButton);
		add(operatePanel);

	}

	private Object[][] getData() {
		Object[][] data = new Object[][] { { "1", "2", "3", "4" } };
		return data;
	}

	private void setListeners() {
		mEditButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (mTable.getSelectedRow() == -1) {
					showAlertMessage();
				}else {
					//TODO
					EditStudentInfoPanel editStudentInfoPanel = new EditStudentInfoPanel();
					
					showSucessMessage();
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
					showSucessMessage();
				}
			}
		});
	}
	
	private void showAlertMessage(){
		JOptionPane.showMessageDialog(null, "请选择要操作的行!");
	}
	
	private void showSucessMessage(){
		JOptionPane.showMessageDialog(null, "操作成功");
	}
	
	private void delete(){
		String pId = (String) mTable.getValueAt(mTable.getSelectedRow(), idColumnNum);
		
	}
}
