package edu.nju.educationSystem.server.service;

import java.util.ArrayList;

import edu.nju.educationSystem.server.model.Course;
import edu.nju.educationSystem.server.model.Elective;
import edu.nju.educationSystem.server.model.Major;
import edu.nju.educationSystem.server.model.Student;
import edu.nju.educationSystem.server.network.CommandConstants;

public class ServiceFacade {
	private StudentService studentService;
	private CourseService courseService;
	private ElectiveService electiveService;
	
	public ServiceFacade() {
		studentService = new StudentService();
		courseService = new CourseService();
		electiveService = new ElectiveService();
	}
	
	public String networkCommandExecute(String major, String command, String xml) {
		//TODO xml×ª»»
		
		switch (command) {
		
		case CommandConstants.ASK_FOR_COURSE_INFORMATION:
			return askForCourse(xml);
			
		case CommandConstants.COURSE_WITHDRAWAL:
			return courseWithdraw(xml);
			
		case CommandConstants.ELECTIVE_RECORD:
			return getElectiveRecord(major);
			
		case CommandConstants.SHARE_COURSE:
			return addCourse(xml);
			
		case CommandConstants.STUDENT_DATA:
			return addStudents(xml);
			
		case CommandConstants.STUDENT_ELECTIVE:
			return addElective(xml);
			
		default:
			System.err.println("error:wrong command:" + command);
			return "useless return";
		}
		
	}
	
	private String askForCourse(String studentXml) {
		String studentId = studentService.getStudentId(studentXml);
		ArrayList<Course> courses = electiveService.getStudentsCourse(studentId);
		String courseXml = courseService.toCourseXml(courses);
		return courseXml;
	}
	
	private String courseWithdraw(String electiveXml) {
		ArrayList<Elective> electives = electiveService.getElectives(electiveXml);
		electiveService.courseWithdraw(electives);
		return "useless return";
	}
	
	private String getElectiveRecord(String majorString) {
		Major major = Major.valueOf(majorString);
		ArrayList<Elective> electives = electiveService.getAllElective(major);
		String electivesXml = electiveService.getElectivesXml(electives);
		return electivesXml;
	}
	
	private String addCourse(String courseXml) {
		ArrayList<Course> courses = courseService.getCourses(courseXml);
		courseService.addCourses(courses);
		return "useless return";
	}
	
	private String addStudents(String studentXml) {
		ArrayList<Student> students = studentService.getStudents(studentXml);
		studentService.addStudents(students);
		return "useless return";
	}
	
	private String addElective(String electiveXml) {
		ArrayList<Elective> electives = electiveService.getElectives(electiveXml);
		electiveService.addElectives(electives);
		return "useless return";
	}
}
