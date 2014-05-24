package edu.nju.educationSystem.server.service;

import java.util.ArrayList;

import edu.nju.educationSystem.server.dao.StudentDAO;
import edu.nju.educationSystem.server.model.Student;

public class StudentService {
	private StudentDAO studentDAO;
	
	public StudentService() {
		studentDAO = new StudentDAO();
	}
	
	public String getStudentId(String studentXml) {
		//TODO
		return "123";
	}
	
	public ArrayList<Student> getStudents(String studentXml) {
		//TODO
		return new ArrayList<>();
	}
	
	public void addStudents(ArrayList<Student> students) {
		for (Student student : students) {
			studentDAO.add(student);
		}
	}
}
