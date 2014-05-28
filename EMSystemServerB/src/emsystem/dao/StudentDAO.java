package emsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import emsystem.model.Student;

public class StudentDAO {
	private static final String TABLE_NAME = "student";

	private DaoHelper daoHelper;

	public StudentDAO() {
		daoHelper = DaoHelper.getInstance();
	}

	public Student getStudent(String id) {
		Student student = new Student();

		try {
			Connection connection = daoHelper.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select * from " + TABLE_NAME
							+ " where ѧ�� = ?");
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				student = new Student(id, resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5));
			}

			daoHelper.closePreparedStatement(statement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	public ArrayList<Student> getStudents() {
		ArrayList<Student> list = new ArrayList<Student>();

		Connection connection = daoHelper.getConnection();
		String sql = "select * from student";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String pId = resultSet.getString("ѧ��");
				String pName = resultSet.getString("����");
				String pSex = resultSet.getString("�Ա�");
				String pMajor = resultSet.getString("Ժϵ");
				String pPassword = resultSet.getString("�����˻�");
				Student stu = new Student(pId, pName, pSex, pMajor, pPassword);
				list.add(stu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean add(Student student) {
		try {
			Connection connection = daoHelper.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into student values(?,?,?,?,?)");
			statement.setString(1, student.getId());
			statement.setString(2, student.getName());
			statement.setString(3, student.getSex());
			statement.setString(4, student.getMajor());
			statement.setString(5, student.getAccountId());
			statement.execute();
		
			daoHelper.closePreparedStatement(statement);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Student student) {
		try {
			Connection connection  = daoHelper.getConnection();
			PreparedStatement statement = connection.prepareStatement("update student set ����=?,�Ա�=?,Ժϵ=?,�����˻�=? where ѧ��=?");
			statement.setString(1, student.getName());
			statement.setString(2, student.getSex());
			statement.setString(3, student.getMajor());
			statement.setString(4, student.getAccountId());
			statement.setString(5, student.getId());
			statement.execute();
			
			daoHelper.closePreparedStatement(statement);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean remove(String sid) {
		try {
			Connection connection = daoHelper.getConnection();
			PreparedStatement statement = connection.prepareStatement("delete from student where ѧ�� = ?");
			statement.setString(1, sid);
			statement.execute();
			
			daoHelper.closePreparedStatement(statement);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Student> getChoosedStudents(String cid) {
		ArrayList<Student> list = new ArrayList<Student>();

		Connection connection = daoHelper.getConnection();
		String sql = "select * from student where ѧ�� in(" + 
				"select ѧ����� from choice where �γ̱��='" + cid + "')";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String pId = resultSet.getString("ѧ��");
				String pName = resultSet.getString("����");
				String pSex = resultSet.getString("�Ա�");
				String pMajor = resultSet.getString("Ժϵ");
				String pPassword = resultSet.getString("�����˻�");
				Student stu = new Student(pId, pName, pSex, pMajor, pPassword);
				list.add(stu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<String> getRemoteChoosedStudentIds(String cid) {
		ArrayList<String> list = new ArrayList<>();

		Connection connection = daoHelper.getConnection();
		String sql = "select ѧ����� from choice where �γ̱��='" + cid + "' and ѧ����� not in("
				+ "select ѧ�� from student)";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String id = resultSet.getString("ѧ�����");
				list.add(id);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
