package emsystem.service;

import java.util.ArrayList;

import emsystem.dao.StudentDAO;
import emsystem.model.Student;
import emsystem.rao.StudentRAO;

public class StudentService {
	private StudentDAO studentDAO;
	private StudentRAO studentRAO;
	
	public StudentService() {
		studentDAO = new StudentDAO();
		studentRAO = new StudentRAO();
	}
	
	public Student getStudent(String id) {
		return studentDAO.getStudent(id);
	}
	
	public ArrayList<Student> getStudents() {
		return studentDAO.getStudents();
	}
	
	public boolean add(Student student) {
		return studentDAO.add(student);
	}
	
	public boolean update(Student student) {
		return studentDAO.update(student);
	}
	
	public boolean remove(String sid) {
		return studentDAO.remove(sid);
	}
	
	public ArrayList<Student> getChoosedStudents(String cid) {
		return studentDAO.getChoosedStudents(cid);
	}
	
	public void shareStudent(ArrayList<Student> students) {
		studentRAO.add(students);
	}
	
	public ArrayList<String> getRemoteChoosedStudentIds(String cid) {
		return studentDAO.getRemoteChoosedStudentIds(cid);
	}

	public Student getRemoteStudent(String sid) {
		return studentRAO.getStudent(sid);
	}
	
}
