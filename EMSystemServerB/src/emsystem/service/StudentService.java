package emsystem.service;

import emsystem.dao.StudentDAO;
import emsystem.model.Student;

public class StudentService {
	private StudentDAO studentDAO;
	
	public StudentService() {
		studentDAO = new StudentDAO();
	}
	
	public Student getStudent(String id) {
		return studentDAO.getStudent(id);
	}
	
}
