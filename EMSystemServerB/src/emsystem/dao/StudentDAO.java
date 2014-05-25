package emsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import emsystem.model.Student;

public class StudentDAO {
	private static final String TABLE_NAME = "student";

	private DaoHelper daoHelper;

	public StudentDAO() {
		daoHelper = new DaoHelper();
	}

	public Student getStudent(String id) {
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Student student = null;

		try {
			connection = daoHelper.getConnection();
			statement = connection.prepareStatement("select * from "
					+ TABLE_NAME + " where Ñ§ºÅ = ?");
			statement.setString(1, id);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				student = new Student(id, resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5));
			}

			daoHelper.closePreparedStatement(statement);
			daoHelper.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

}
