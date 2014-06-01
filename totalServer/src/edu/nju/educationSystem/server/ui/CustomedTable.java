package edu.nju.educationSystem.server.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;

public class CustomedTable extends JTable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6404363945643426447L;

	public CustomedTable(Object[][] data, String[] columns){
		super(data, columns);
		setProperties();
	}
	
	private void setProperties(){
		getTableHeader().setReorderingAllowed(false);   //不可整列移动   
		getTableHeader().setResizingAllowed(false); 
		setSelectionBackground(Color.white);
		setRowHeight(30);
		setMaximumSize(new Dimension(400,300));
	}
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

}
