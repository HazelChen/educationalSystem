package edu.nju.educationSystem.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.educationSystem.server.model.Course;
import edu.nju.educationSystem.server.model.Major;
import edu.nju.educationSystem.server.model.Student;

public class CourseDAO {
	private static final String TABLE_NAME = "course";
	private static final String[] COLUMNS = { "id", "name", "time", "score",
			"teacher", "location" };

	private DatabaseUtils databaseUtils;

	public CourseDAO() {
		databaseUtils = new DatabaseUtils();
	}

	public void addCourse(Course course) {
		String order = "INSERT INTO " + TABLE_NAME + " VALUES ('"
				+ course.getId() + "','" + course.getName() + "','"
				+ course.getTime() + "','" + course.getScore() + "','"
				+ course.getTeacher() + "','" + course.getLocation() + "')";

		databaseUtils.excute(order);
	}

	public Course getCoursesById(String cid) {
		Course course = new Course();

		ResultSet resultSet = databaseUtils.getResultSetByWholeWord(TABLE_NAME,
				COLUMNS[0], cid);
		try {
			if (resultSet.next()) {
				String id = resultSet.getString(COLUMNS[0]);
				String name = resultSet.getString(COLUMNS[1]);
				int time = resultSet.getInt(COLUMNS[2]);
				int score = resultSet.getInt(COLUMNS[3]);
				String teacher = resultSet.getString(COLUMNS[4]);
				String location = resultSet.getString(COLUMNS[5]);

				course.setId(id);
				course.setName(name);
				course.setTime(time);
				course.setScore(score);
				course.setTeacher(teacher);
				course.setLocation(location);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return course;
	}
	
	public ArrayList<String> getCourseIdsByMajor(Major major) {
		ArrayList<String> courseIds = new ArrayList<>();
		
		ResultSet resultSet = databaseUtils.getResultSetByPrefix(TABLE_NAME, COLUMNS[0], major.getPrefix());
		
		try {
			while (resultSet.next()) {
				String id = resultSet.getString(COLUMNS[0]);
				courseIds.add(id);
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return courseIds;
	}
	
	public ResultSet getAllCourseResultSet(){
		String order = "SELECT * FROM " + TABLE_NAME;
		ResultSet resultSet = databaseUtils.searchResultSet(order);
		return resultSet;
	}
	
	public ArrayList<Course> getAllCourses () {
		String order = "SELECT * FROM " + TABLE_NAME;
		ResultSet resultSet = databaseUtils.searchResultSet(order);
		ArrayList<Course> courses = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Course course = new Course(resultSet.getString(COLUMNS[0]),
						resultSet.getString(COLUMNS[1]), resultSet.getInt(COLUMNS[2]), 
						resultSet.getInt(COLUMNS[3]), resultSet.getString(COLUMNS[4]), 
						resultSet.getString(COLUMNS[5]));
				courses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}


	public ArrayList<Course> getNotSelectedCourse(String prefix, String sid) {
		String sql = "select * from course where id like '" + prefix + "%' and id not in("
				+ "select cid from elective where sid='" + sid + "')";
		
		ArrayList<Course> courses = new ArrayList<>();
		ResultSet resultSet = databaseUtils.searchResultSet(sql);
		try {
			while (resultSet.next()) {
				Course course = new Course(resultSet.getString(COLUMNS[0]),
						resultSet.getString(COLUMNS[1]), resultSet.getInt(COLUMNS[2]), 
						resultSet.getInt(COLUMNS[3]), resultSet.getString(COLUMNS[4]), 
						resultSet.getString(COLUMNS[5]));
				courses.add(course);
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}
}
