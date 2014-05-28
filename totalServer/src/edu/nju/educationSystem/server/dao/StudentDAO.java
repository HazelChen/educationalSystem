package edu.nju.educationSystem.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.nju.educationSystem.server.model.Major;
import edu.nju.educationSystem.server.model.Sex;
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
	
	public Student find(String sid) {
		Student student = new Student();

		ResultSet resultSet = databaseUtils.getResultSetByWholeWord(TABLE_NAME,
				COLUMN[0], sid);
		try {
			if (resultSet.next()) {
				String name = resultSet.getString(COLUMN[1]);
				Sex sex = Sex.valueOf(resultSet.getString(COLUMN[2]));
				Major major = Major.valueOf(resultSet.getString(COLUMN[3]));

				student.setId(sid);
				student.setName(name);
				student.setSex(sex);
				student.setMajor(major);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return student;
	}
}
