package emsystem.service;

import java.util.ArrayList;

import emsystem.dao.CourseDAO;
import emsystem.model.Course;
import emsystem.rao.CourseRAO;

public class CourceService {
	private CourseDAO courseDAO;
	private CourseRAO courseRAO;
	
	public CourceService() {
		courseDAO = new CourseDAO();
		courseRAO = new CourseRAO();
	}
	
	public Course findCourse(String id) {
		Course course = null;
		if (id.startsWith("2")) {
			course = courseDAO.findCourse(id);
		} else {
			course = courseRAO.find(id);
		}
		return course;
	}
	
	public ArrayList<Course> getCourseInB() {
		ArrayList<Course> result = courseDAO.getNotSharedNotSelectedCourses();
		ArrayList<Course> allNotSelectedCourses = courseRAO.getNotSelectedCourses();
		for (int i = 0; i < allNotSelectedCourses.size(); i++) {
			Course course = allNotSelectedCourses.get(i);
			if (course.getId().startsWith("2")) {
				result.add(course);
			}
		}
		return result;
	}
	
}
