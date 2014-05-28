package emsystem.service;

import java.util.ArrayList;

import emsystem.dao.CourseDAO;
import emsystem.model.Choice;
import emsystem.model.Course;
import emsystem.rao.ChoiceRAO;
import emsystem.rao.CourseRAO;

public class CourseService {
	private CourseDAO courseDAO;
	private CourseRAO courseRAO;
	
	private ChoiceRAO choiceRAO;
	
	public CourseService() {
		courseDAO = new CourseDAO();
		courseRAO = new CourseRAO();
		choiceRAO = new ChoiceRAO();
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
		ArrayList<Course> myMajorCanDropCources = courseDAO.getScoreZeroCourses(sid);
		
		ArrayList<Choice> myOtherMajorChoices = choiceRAO.getStudentChoice(sid);
		ArrayList<Course> result = new ArrayList<Course>();
		for (Choice choice : myOtherMajorChoices) {
			String cid = choice.getCourseId();
			if (choice.getScore() == 0) {
				Course course = courseRAO.find(cid);
				result.add(course);
			}
		}
		result.addAll(myMajorCanDropCources);
		return result;
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
