package edu.nju.educationSystem.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		ResultSet resultSet = databaseUtils.getResultSetByWholeWord(TABLE_NAME,
				COLUMN[0], sid);
		try {
			if (resultSet.next()) {
				Student student = getStudent(resultSet);
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new Student();
	}

	public ArrayList<Student> getAll() {
		ResultSet resultSet = databaseUtils.searchResultSet("select * from " + TABLE_NAME);
		ArrayList<Student> students = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Student student = getStudent(resultSet);
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	
	private Student getStudent(ResultSet resultSet) throws SQLException {
		Student student = new Student();
		String id = resultSet.getString(COLUMN[0]);
		String name = resultSet.getString(COLUMN[1]);
		Sex sex = Sex.valueOf(resultSet.getString(COLUMN[2]));
		Major major = Major.valueOf(resultSet.getString(COLUMN[3]));

		student.setId(id);
		student.setName(name);
		student.setSex(sex);
		student.setMajor(major);
		return student;
	}
}
