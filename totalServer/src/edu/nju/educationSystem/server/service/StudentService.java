package edu.nju.educationSystem.server.service;

import java.util.ArrayList;

import edu.nju.educationSystem.server.dao.StudentDAO;
import edu.nju.educationSystem.server.model.Major;
import edu.nju.educationSystem.server.model.Sex;
import edu.nju.educationSystem.server.model.Student;
import edu.nju.educationSystem.server.xmlHandler.ConfigConstant;
import edu.nju.educationSystem.server.xmlHandler.XMLAnalyzer;
import edu.nju.educationSystem.server.xmlHandler.XMLGenerater;

public class StudentService {
	private StudentDAO studentDAO;
	
	public StudentService() {
		studentDAO = new StudentDAO();
	}
	
	public Student getStudent(String sid) {
		return studentDAO.find(sid);
	}
	
	public String toStudentXML(Student student) {
		XMLGenerater generater = new XMLGenerater(ConfigConstant.STUDENT_ROOT, 
				ConfigConstant.STUDENT_ELEMENT, Student.class, new Student());
		generater.addElement(student);
		return generater.getXmlString();
	}
	
	public String getStudentId(String studentXml) {
		XMLAnalyzer analyzer = new XMLAnalyzer(studentXml);
		ArrayList<String> values = analyzer.next();
		String id = values.get(0); 
		return id;
	}
	
	public ArrayList<Student> getStudents(String studentXml) {
		ArrayList<Student> students = new ArrayList<>();
		
		XMLAnalyzer analyzer = new XMLAnalyzer(studentXml);
		while (analyzer.hasNext()) {
			ArrayList<String> values = analyzer.next();
			Student student = new Student(values.get(0), values.get(1), 
					Sex.valueOf(values.get(2)), Major.valueOf(values.get(3)));
			students.add(student);
		}
		return students;
	}
	
	public ArrayList<Student> getAll() {
		return studentDAO.getAll();
	}
	
	public void addStudents(ArrayList<Student> students) {
		for (Student student : students) {
			studentDAO.add(student);
		}
	}
}
