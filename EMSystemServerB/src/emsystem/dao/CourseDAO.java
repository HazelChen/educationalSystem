package emsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import emsystem.model.Course;

public class CourseDAO {
	private DaoHelper daoHelper;

	public Course findCourse(String cid) {
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Course course = null;

		try {
			connection = daoHelper.getConnection();
			statement = connection
					.prepareStatement("select * from course where ¿Î³Ì±àºÅ = ?");
			statement.setString(1, cid);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				course = new Course(cid, resultSet.getString(2), Integer.parseInt(resultSet.getString(3)),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
			}

			daoHelper.closePreparedStatement(statement);
			daoHelper.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}
}
