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
		XMLGenerater xmlGenerater = new XMLGenerater(ConfigConstant.COURSE_ROOT, 
				ConfigConstant.COURSE_ELEMENT, Course.class, new Course());
		for(Course course : courses) {
			xmlGenerater.addElement(course);
		}
		return xmlGenerater.getXmlString();
	}
	
	public String toCourseXml(Course course) {
		XMLGenerater xmlGenerater = new XMLGenerater(ConfigConstant.COURSE_ROOT, 
				ConfigConstant.COURSE_ELEMENT, Course.class, new Course());
		xmlGenerater.addElement(course);
		String xml = xmlGenerater.getXmlString();
		return xml;
	}
	
	public ArrayList<Course> getCourses(String courseXml) {
		ArrayList<Course> courses = new ArrayList<>();
		
		XMLAnalyzer analyzer = new XMLAnalyzer(courseXml);
		while (analyzer.hasNext()) {
			ArrayList<String> values = analyzer.next();
			int time = 0;
			if (!values.get(2).equals("")) {
				time = Integer.parseInt(values.get(2));
			}
			Course course = new Course(values.get(0), values.get(1), 
					time, Integer.parseInt(values.get(3)), 
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
	
	public Course getCourse(String cid) {
		Course course = courseDAO.getCoursesById(cid);
		return course;
	}
	
	public ArrayList<Course> notSelectedCourseA(String sid) {
		return courseDAO.getNotSelectedCourse("1", sid);
	}
	
	public ArrayList<Course> notSelectedCourseB(String sid) {
		return courseDAO.getNotSelectedCourse("2", sid);
	}
	
	public ArrayList<Course> notSelectedCourseC(String sid) {
		return courseDAO.getNotSelectedCourse("3", sid);
	}
	
	public ArrayList<Course> getAll(){
		return courseDAO.getAllCourses();
	}
}