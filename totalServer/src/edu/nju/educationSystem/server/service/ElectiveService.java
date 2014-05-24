package edu.nju.educationSystem.server.service;

import java.util.ArrayList;

import edu.nju.educationSystem.server.dao.CourseDAO;
import edu.nju.educationSystem.server.dao.ElectiveDAO;
import edu.nju.educationSystem.server.model.Course;
import edu.nju.educationSystem.server.model.Elective;
import edu.nju.educationSystem.server.model.Major;

public class ElectiveService {
	private ElectiveDAO electiveDAO;
	private CourseDAO courseDAO;
	
	public ElectiveService() {
		electiveDAO = new ElectiveDAO();
	}
	
	public ArrayList<Course> getStudentsCourse(String studentId) {
		ArrayList<Elective> electives = electiveDAO.getElectiveByStudentId(studentId);
		
		ArrayList<Course> courses = new ArrayList<>();
		for(Elective elective : electives) {
			String cid = elective.getCourseId();
			Course course = courseDAO.getCoursesById(cid);
			courses.add(course);
		}
		return courses;
	}
	
	public void courseWithdraw(ArrayList<Elective> electives) {
		for (Elective elective : electives) {
			electiveDAO.remove(elective);
		}
	}
	
	public ArrayList<Elective> getElectives(String electiveXml) {
		//TODO
		return new ArrayList<>();
	}
	
	public ArrayList<Elective> getAllElective(Major major) {
		ArrayList<String> courseIds = courseDAO.getCourseIdsByMajor(major);
		
		ArrayList<Elective> electives = new ArrayList<>();
		for (String cid : courseIds) {
			ArrayList<Elective> electivesWithId = electiveDAO.getElectiveByCourseId(cid);
			electives.addAll(electivesWithId);
		}
		return electives;
	}
	
	public String getElectivesXml(ArrayList<Elective> electives) {
		//TODO
		return "";
	}
	
	public void addElectives(ArrayList<Elective> electives) {
		for (Elective elective : electives) {
			electiveDAO.add(elective);
		}
	}
}
