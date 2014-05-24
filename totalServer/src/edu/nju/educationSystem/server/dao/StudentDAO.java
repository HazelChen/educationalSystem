package edu.nju.educationSystem.server.dao;

import edu.nju.educationSystem.server.model.Student;

public class StudentDAO {
	private final static String TABLE_NAME = "student";
	private final static String[] COLUMN = {"id", "name", "sex", "major"};
	
	private DatabaseUtils databaseUtils;
	
	public StudentDAO() {
		databaseUtils = new DatabaseUtils();
	}
	
	public void add(Student student) {
		String order = "INSERT INTO " + TABLE_NAME + " VALUES ('"
				+ student.getId() + "','" + student.getName() + "','" 
				+ student.getSex() + "','" + student.getMajor() + "')";
		databaseUtils.excute(order);
	}
}
