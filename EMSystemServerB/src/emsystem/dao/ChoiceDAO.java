package emsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import emsystem.model.Choice;

public class ChoiceDAO {
	private static final String TABLE_NAME = "choice";

	private DaoHelper daoHelper;

	public ChoiceDAO() {
		daoHelper = DaoHelper.getInstance();
	}

	public ArrayList<Choice> getStudentChoice(String sid) {
		ArrayList<Choice> choices = new ArrayList<>();

		Connection connection = daoHelper.getConnection();
		String sql = "select * from " + TABLE_NAME + " where ѧ�����=" + sid;

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String studentId = resultSet.getString("ѧ�����");
				String courseId = resultSet.getString("�γ̱��");
				int score = Integer.parseInt(resultSet.getString("�ɼ�"));
				Choice choice = new Choice(studentId, courseId, score);
				choices.add(choice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return choices;
	}

	public boolean add(Choice choice) {
		Connection connection = daoHelper.getConnection();
		String sql = "insert into choice values('" + choice.getCourseId()
				+ "','" + choice.getStudentId() + "'," + choice.getScore()
				+ ")";
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean remove(Choice choice) {
		Connection connection = daoHelper.getConnection();
		String sql = "delete from choice where ѧ�����=" + choice.getStudentId()
				+ "and �γ̱��=" + choice.getCourseId();
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

}
