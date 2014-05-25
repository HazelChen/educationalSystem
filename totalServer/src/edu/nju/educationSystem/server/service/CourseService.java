package edu.nju.educationSystem.server.service;

import java.util.ArrayList;

import edu.nju.educationSystem.server.dao.CourseDAO;
import edu.nju.educationSystem.server.model.Course;
import edu.nju.educationSystem.server.xmlHandler.ConfigConstant;
import edu.nju.educationSystem.server.xmlHandler.XMLAnalyzer;
import edu.nju.educationSystem.server.xmlHandler.XMLGenerater;

public class CourseService {
	private CourseDAO courseDAO;
	
	public CourseService() {
		courseDAO = new CourseDAO();
	}
	
	public String toCourseXml(ArrayList<Course> courses) {
		XMLGenerater xmlGenerater = new XMLGenerater(ConfigConstant.COURSE_ROOT, ConfigConstant.COURSE_ELEMENT);
		xmlGenerater.generateDocumentBaseInfo(Course.class);
		for(Course course : courses) {
			xmlGenerater.addElement(course);
		}
		return xmlGenerater.getXmlString();
	}
	
	public ArrayList<Course> getCourses(String courseXml) {
		ArrayList<Course> courses = new ArrayList<>();
		
		XMLAnalyzer analyzer = new XMLAnalyzer(courseXml);
		while (analyzer.hasNext()) {
			ArrayList<String> values = analyzer.next();
			Course course = new Course(values.get(0), values.get(1), 
					Integer.parseInt(values.get(2)), Integer.parseInt(values.get(3)), 
					values.get(4), values.get(5));
			courses.add(course);
		}
		return courses;
	}
	
	public void addCourses(ArrayList<Course> courses) {
		for (Course course : courses) {
			courseDAO.addCourse(course);
		}
	}
	
}
