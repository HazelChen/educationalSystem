package edu.nju.educationSystem.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.educationSystem.server.model.Elective;

public class ElectiveDAO {
	private final static String TABLE_NAME = "elective";
	private final static String[] COLUMN = new String[] { "sid", "cid", "score" };

	private DatabaseUtils databaseUtils;

	public ElectiveDAO() {
		databaseUtils = new DatabaseUtils();
	}

	public ArrayList<Elective> getElectiveByStudentId(String studentId) {
		ResultSet resultSet = databaseUtils.getResultSetByWholeWord(TABLE_NAME,
				COLUMN[0], studentId);
		ArrayList<Elective> electives = getElectivesByResultSet(resultSet);
		return electives;
	}

	public ArrayList<Elective> getElectiveByCourseId(String cId) {
		ResultSet resultSet = databaseUtils.getResultSetByWholeWord(TABLE_NAME,
				COLUMN[1], cId);
		ArrayList<Elective> electives = getElectivesByResultSet(resultSet);
		return electives;
	}

	public boolean remove(Elective elective) {
		String order = "delete from " + TABLE_NAME + " where " + COLUMN[0]
				+ " = '" + elective.getStudentId() + "' and " + COLUMN[1]
				+ " = '" + elective.getCourseId() + "'";

		boolean result = databaseUtils.excute(order);
		return result;
	}

	public boolean add(Elective elective) {
		String order = "INSERT INTO " + TABLE_NAME + " VALUES ('"
				+ elective.getStudentId() + "','" + elective.getCourseId()
				+ "','" + elective.getScore() + "')";

		boolean result = databaseUtils.excute(order);
		return result;
	}

	private ArrayList<Elective> getElectivesByResultSet(ResultSet resultSet) {
		ArrayList<Elective> electives = new ArrayList<>();
		try {
			while (resultSet.next()) {
				String studentId = resultSet.getString(COLUMN[0]);
				String courseId = resultSet.getString(COLUMN[1]);
				int score = resultSet.getInt(COLUMN[2]);
				Elective elective = new Elective(studentId, courseId, score);
				electives.add(elective);
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return electives;
	}
}
