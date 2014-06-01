package edu.nju.educationSystem.server.service;

import java.util.ArrayList;

import edu.nju.educationSystem.server.dao.CourseDAO;
import edu.nju.educationSystem.server.dao.ElectiveDAO;
import edu.nju.educationSystem.server.model.Course;
import edu.nju.educationSystem.server.model.Elective;
import edu.nju.educationSystem.server.model.Major;
import edu.nju.educationSystem.server.xmlHandler.ConfigConstant;
import edu.nju.educationSystem.server.xmlHandler.XMLAnalyzer;
import edu.nju.educationSystem.server.xmlHandler.XMLGenerater;

public class ElectiveService {
	private ElectiveDAO electiveDAO;
	private CourseDAO courseDAO;
	
	public ElectiveService() {
		electiveDAO = new ElectiveDAO();
		courseDAO = new CourseDAO();
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
	
	public boolean courseWithdraw(ArrayList<Elective> electives) {
		boolean result = false;
		for (Elective elective : electives) {
			result = electiveDAO.remove(elective);
		}
		return result;
	}
	
	public ArrayList<Elective> getAll(){
		return electiveDAO.getAllElectives();
	}
	
	public ArrayList<Elective> getElectives(String electiveXml) {
		ArrayList<Elective> electives = new ArrayList<>();
		
		XMLAnalyzer analyzer = new XMLAnalyzer(electiveXml);
		while (analyzer.hasNext()) {
			ArrayList<String> values = analyzer.next();
			Elective elective = new Elective(values.get(0), values.get(1), Integer.parseInt(values.get(2)));
			electives.add(elective);
		}
		return electives;
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
		XMLGenerater xmlGenerater = new XMLGenerater(ConfigConstant.ELECTIVE_ROOT, 
				ConfigConstant.ELECTIVE_ELEMENT, Elective.class, new Elective());
		for (Elective elective : electives) {
			xmlGenerater.addElement(elective);
		}
		String xml =  xmlGenerater.getXmlString();
		return xml;
	}
	
	public boolean addElectives(ArrayList<Elective> electives) {
		boolean result = false;
		for (Elective elective : electives) {
			result = electiveDAO.add(elective);
		}
		return result;
	}

	public ArrayList<Elective> getStudentsChoise(String sid) {
		return electiveDAO.getElectiveByStudentId(sid);
	}
}
