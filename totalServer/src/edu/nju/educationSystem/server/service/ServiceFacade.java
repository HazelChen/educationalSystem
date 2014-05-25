package edu.nju.educationSystem.server.service;

import java.util.ArrayList;

import edu.nju.educationSystem.server.model.Course;
import edu.nju.educationSystem.server.model.Elective;
import edu.nju.educationSystem.server.model.Major;
import edu.nju.educationSystem.server.model.Student;
import edu.nju.educationSystem.server.network.CommandConstants;
import edu.nju.educationSystem.server.xmlHandler.ConfigConstant;
import edu.nju.educationSystem.server.xmlHandler.XMLGenerater;

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
		//TODO xml转换 return 之前也要转换
		
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
	
	private String askForCourse(String cid) {
		Course course = courseService.getCourse(cid);
		
		XMLGenerater xmlGenerater = new XMLGenerater(ConfigConstant.COURSE_ROOT, 
				ConfigConstant.COURSE_ELEMENT, Course.class, new Course());
		return xmlGenerater.getXmlString();
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
