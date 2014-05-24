package edu.nju.educationSystem.server.service;

import java.util.ArrayList;

import edu.nju.educationSystem.server.dao.CourseDAO;
import edu.nju.educationSystem.server.model.Course;

public class CourseService {
	private CourseDAO courseDAO;
	
	public CourseService() {
		courseDAO = new CourseDAO();
	}
	
	public String toCourseXml(ArrayList<Course> courses) {
		//TODO
		return "";
	}
	
	public ArrayList<Course> getCourses(String courseXml) {
		//TODO
		return new ArrayList<>();
	}
	
	public void addCourses(ArrayList<Course> courses) {
		for (Course course : courses) {
			courseDAO.addCourse(course);
		}
	}
	
}
