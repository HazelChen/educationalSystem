package edu.nju.educationSystem.server.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import edu.nju.educationSystem.server.model.Elective;
import edu.nju.educationSystem.server.service.ElectiveService;

public class ElectiveInfoPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * create the panel
	 */
	String[] infoColumnsName = new String[]{"学号","课程编号","分数"};	
	
	private CustomedTable table;
	private JScrollPane scrollPane;
	private int sidIndex = 0, cidIndex = 1, scoreIndex = 2;
	
	public ElectiveInfoPanel(){
		JButton button = new JButton("刷新");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table = new CustomedTable(getData(), infoColumnsName);
				scrollPane.setViewportView(table);
				scrollPane.invalidate();
				scrollPane.repaint();
				ElectiveInfoPanel.this.repaint();
			}
		});
		this.setLayout(new BorderLayout());
		this.add(button, BorderLayout.NORTH);
		table = new CustomedTable(getData(), infoColumnsName);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 300));
		add(scrollPane, BorderLayout.CENTER);
	}

	private String[][] getData() {
		ElectiveService es = new ElectiveService();
		ArrayList<Elective> electives = es.getAll();
		Elective elective = null;
		String[][] data = new String[electives.size()][infoColumnsName.length];
		for(int i=0; i< electives.size(); i++){
			elective = electives.get(i);
			if(elective!=null){
				data[i][sidIndex] = elective.getStudentId();
				data[i][cidIndex] = elective.getCourseId();
				data[i][scoreIndex] = String.valueOf(elective.getScore());
			}
		}
		return data;
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.add(new ElectiveInfoPanel());
		frame.setSize(600, 500);
		frame.setVisible(true);
	}
}
