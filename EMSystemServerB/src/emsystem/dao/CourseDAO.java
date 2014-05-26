package emsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import emsystem.model.Course;

public class CourseDAO {
	private DaoHelper daoHelper;
	
	public CourseDAO() {
		daoHelper = DaoHelper.getInstance();
	}

	public Course findCourse(String cid) {
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Course course = null;

		try {
			connection = daoHelper.getConnection();
			statement = connection
					.prepareStatement("select * from course where 课程编号 = ?");
			statement.setString(1, cid);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				course = new Course(cid, resultSet.getString(2),
						Integer.parseInt(resultSet.getString(3)),
						resultSet.getString(4), resultSet.getString(5),
						resultSet.getString(6));
			}

			daoHelper.closePreparedStatement(statement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}

	public ArrayList<Course> getNotSharedNotSelectedCourses(String sid) {
		ArrayList<Course> courses = new ArrayList<>();

		Connection connection = daoHelper.getConnection();
		String sql = "select * from course where 共享=0 and 课程编号 not in("
				+ "select 课程编号 from choice where 学生编号='" + sid + "')";

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Course course = new Course(resultSet.getString(1),
						resultSet.getString(2), Integer.parseInt(resultSet
								.getString(3)), resultSet.getString(4),
						resultSet.getString(5), resultSet.getString(6));
				courses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}

	public ArrayList<Course> getScoreZeroCourses(String sid) {
		ArrayList<Course> courses = new ArrayList<>();

		Connection connection = daoHelper.getConnection();
		String sql = "select * from course where 课程编号 in("
				+ "select 课程编号 from choice where 学生编号='" + sid + "' and 成绩=0)";

		try {
			java.sql.Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Course course = new Course(resultSet.getString(1),
						resultSet.getString(2), Integer.parseInt(resultSet
								.getString(3)), resultSet.getString(4),
						resultSet.getString(5), resultSet.getString(6));
				courses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}

	public ArrayList<Course> getAllCourses() {
		ArrayList<Course> courses = new ArrayList<>();

		Connection connection = daoHelper.getConnection();
		String sql = "select * from course";

		try {
			java.sql.Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Course course = new Course(resultSet.getString(1),
						resultSet.getString(2), Integer.parseInt(resultSet
								.getString(3)), resultSet.getString(4),
						resultSet.getString(5), resultSet.getString(6));
				courses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}
	
	public boolean add(Course course) {
		try {
			Connection connection = daoHelper.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into course values(?,?,?,?,?,?)");
			statement.setString(1, course.getId());
			statement.setString(2, course.getName());
			statement.setInt(3, course.getCredit());
			statement.setString(4, course.getTeacher());
			statement.setString(5, course.getAddress());
			statement.setString(6, course.getShareFlag());
			statement.execute();
		
			daoHelper.closePreparedStatement(statement);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Course course) {
		try {
			Connection connection  = daoHelper.getConnection();
			PreparedStatement statement = connection.prepareStatement("update course set 课程名称=?,学分=?,授课老师=?,授课地点=?,共享=? where 课程编号=?");
			statement.setString(1, course.getName());
			statement.setInt(2, course.getCredit());
			statement.setString(3, course.getTeacher());
			statement.setString(4, course.getAddress());
			statement.setString(5, course.getShareFlag());
			statement.setString(6, course.getId());
			statement.execute();
			
			daoHelper.closePreparedStatement(statement);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean remove(String cid) {
		try {
			Connection connection = daoHelper.getConnection();
			PreparedStatement statement = connection.prepareStatement("delete from course where 课程编号 = ?");
			statement.setString(1, cid);
			statement.execute();
			
			daoHelper.closePreparedStatement(statement);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Course> getUnsharedCourses() {
		ArrayList<Course> courses = new ArrayList<>();

		Connection connection = daoHelper.getConnection();
		String sql = "select * from course where 共享=0";

		try {
			java.sql.Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Course course = new Course(resultSet.getString(1),
						resultSet.getString(2), Integer.parseInt(resultSet
								.getString(3)), resultSet.getString(4),
						resultSet.getString(5), resultSet.getString(6));
				courses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}
	
	public ArrayList<Course> getSharedCourses() {
		ArrayList<Course> courses = new ArrayList<>();
		
		Connection connection = daoHelper.getConnection();
		String sql = "select * from course where 共享=1";
		
		try {
			java.sql.Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Course course = new Course(resultSet.getString(1),
						resultSet.getString(2), Integer.parseInt(resultSet
								.getString(3)), resultSet.getString(4),
								resultSet.getString(5), resultSet.getString(6));
				courses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}
}
