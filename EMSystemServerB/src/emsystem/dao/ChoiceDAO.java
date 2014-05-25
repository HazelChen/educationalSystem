package emsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import emsystem.model.Choice;

public class ChoiceDAO {
	private static final String TABLE_NAME = "choice";
	
	private DaoHelper daoHelper;
	
	public ChoiceDAO() {
		daoHelper = new DaoHelper();
	}
	
	public ArrayList<Choice> getStudentChoice(String sid) {
		ArrayList<Choice> choices = new ArrayList<>();
		
		Connection connection = daoHelper.getConnection();
		String sql="select * from " + TABLE_NAME + " where ѧ�����="+sid;
		
		try {
			java.sql.Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				String studentId=resultSet.getString("ѧ�����");
				String courseId=resultSet.getString("�γ̱��");
				int score=Integer.parseInt(resultSet.getString("�ɼ�"));
				Choice choice=new Choice(studentId, courseId, score);
				choices.add(choice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return choices;
	}
}
