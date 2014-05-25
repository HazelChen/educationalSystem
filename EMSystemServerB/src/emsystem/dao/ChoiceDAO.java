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
		String sql="select * from " + TABLE_NAME + " where 学生编号="+sid;
		
		try {
			java.sql.Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				String studentId=resultSet.getString("学生编号");
				String courseId=resultSet.getString("课程编号");
				int score=Integer.parseInt(resultSet.getString("成绩"));
				Choice choice=new Choice(studentId, courseId, score);
				choices.add(choice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return choices;
	}
}
