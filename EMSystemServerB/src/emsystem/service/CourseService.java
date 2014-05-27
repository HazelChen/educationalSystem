package emsystem.service;

import java.util.ArrayList;

import emsystem.dao.CourseDAO;
import emsystem.model.Course;
import emsystem.rao.CourseRAO;

public class CourseService {
	private CourseDAO courseDAO;
	private CourseRAO courseRAO;
	
	public CourseService() {
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
	
	public ArrayList<Course> getCourseNotChoiceInB(String sid) {
		ArrayList<Course> result = courseDAO.getNotSharedNotSelectedCourses(sid);
		ArrayList<Course> sharedNotSelectedCourses = courseRAO.getNotSelectedInB(sid);
		result.addAll(sharedNotSelectedCourses);
		return result;
	}
	
	public ArrayList<Course> getCourseNotChoiceInA(String sid) {
		ArrayList<Course> sharedNotSelectedCourses = courseRAO.getNotSelectedInA(sid);
		return sharedNotSelectedCourses;
	}
	
	public ArrayList<Course> getCourseNotChoiceInC(String sid) {
		ArrayList<Course> sharedNotSelectedCourses = courseRAO.getNotSelectedInC(sid);
		return sharedNotSelectedCourses;
	}
	
	public ArrayList<Course> getCanDropCources(String sid) {
		return courseDAO.getScoreZeroCourses(sid);
	}
	
	public ArrayList<Course> getThisMajorCourses() {
		return courseDAO.getAllCourses();
	}
	
	public boolean add(Course course) {
		return courseDAO.add(course);
	}
	
	public boolean update(Course course) {
		return courseDAO.update(course);
	}
	
	public boolean remove(String cid) {
		return courseDAO.remove(cid);
	}
	
	public ArrayList<Course> getUnsharedCourses() {
		return courseDAO.getUnsharedCourses();
	}
	
	public ArrayList<Course> getSharedCourses() {
		return courseDAO.getSharedCourses();
	}
	
	public void shareCoursesToServer(ArrayList<Course> courses) {
		courseRAO.add(courses);
	}

	public void shareInDB(ArrayList<String> pCourseIds) {
		for (String cid : pCourseIds) {
			courseDAO.shareCourse(cid);
		}
	}
	
}
