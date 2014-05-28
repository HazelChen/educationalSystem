package emsystem.rao;

import java.util.ArrayList;

import emsystem.data.Choice;
import emsystem.data.Course;
import emsystem.data.Student;

public class RAOFacade {
	private ChoiceRAO choiceRAO;
	private CourseRAO courseRAO;
	private StudentRAO studentRAO;
	
	public RAOFacade() {
		choiceRAO = new ChoiceRAO();
		courseRAO = new CourseRAO();
		studentRAO = new StudentRAO();
	}
	
	public boolean add(Choice choice) {
		return choiceRAO.add(choice);
	}
	
	public boolean remove(Choice choice) {
		return choiceRAO.remove(choice);
	}
	
	public ArrayList<Choice> getServerChoises() {
		return choiceRAO.getServerChoises();
	}

	public ArrayList<Choice> getStudentChoice(String sid) {
		return choiceRAO.getStudentChoice(sid);
	}
	
	public Course findCourse(String id) {
		return courseRAO.find(id);
	}
	
	public ArrayList<Course> getNotSelectedCoursesInA(String sid) {
		return courseRAO.getNotSelectedInA(sid);
	}
	
	public ArrayList<Course> getNotSelectedCoursesInB(String sid) {
		return courseRAO.getNotSelectedInB(sid);
	}
	
	public ArrayList<Course> getNotSelectedCoursesC(String sid) {
		return courseRAO.getNotSelectedInC(sid);
	}
	
	public void addCourses(ArrayList<Course> courses) {
		courseRAO.add(courses);
	}
	
	public void addStudents(ArrayList<Student> students) {
		studentRAO.add(students);
	}
	
	public Student getStudent(String sid) {
		return studentRAO.getStudent(sid);
	}
}
