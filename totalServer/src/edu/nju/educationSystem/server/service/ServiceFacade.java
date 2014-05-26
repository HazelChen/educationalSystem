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
		case CommandConstants.COURSE_WITHDRAWAL:
			return courseWithdraw(xml);
		
		case CommandConstants.ELECTIVE_RECORD:
			return getElectiveRecord(major);
			
		case CommandConstants.GET_COURSE_INFORMATION_BY_ID:
			return askForCourse(xml);
			
		case CommandConstants.NOT_SELECTED_COURSE_A:
			return notSelectedCourseA(xml);
			
		case CommandConstants.NOT_SELECTED_COURSE_B:
			return notSelectedCourseB(xml);
			
		case CommandConstants.NOT_SELECTED_COURSE_C:
			return notSelectedCourseC(xml);
			
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
	
	private String notSelectedCourseA(String sid) {
		ArrayList<Course> courses = courseService.notSelectedCourseA(sid);
		
		XMLGenerater generater = new XMLGenerater(ConfigConstant.COURSE_ROOT, 
				ConfigConstant.COURSE_ELEMENT, Course.class, new Course());
		for (Course course : courses) {
			generater.addElement(course);
		}
		return generater.getXmlString();
	}
	
	private String notSelectedCourseB(String sid) {
		ArrayList<Course> courses = courseService.notSelectedCourseB(sid);
		
		XMLGenerater generater = new XMLGenerater(ConfigConstant.COURSE_ROOT, 
				ConfigConstant.COURSE_ELEMENT, Course.class, new Course());
		for (Course course : courses) {
			generater.addElement(course);
		}
		return generater.getXmlString();
	}
	
	private String notSelectedCourseC(String sid) {
		ArrayList<Course> courses = courseService.notSelectedCourseC(sid);
		
		XMLGenerater generater = new XMLGenerater(ConfigConstant.COURSE_ROOT, 
				ConfigConstant.COURSE_ELEMENT, Course.class, new Course());
		for (Course course : courses) {
			generater.addElement(course);
		}
		return generater.getXmlString();
	}
	
	private String askForCourse(String cid) {
		Course course = courseService.getCourse(cid);
		
		XMLGenerater xmlGenerater = new XMLGenerater(ConfigConstant.COURSE_ROOT, 
				ConfigConstant.COURSE_ELEMENT, Course.class, new Course());
		xmlGenerater.addElement(course);
		return xmlGenerater.getXmlString();
	}
	
	private String courseWithdraw(String electiveXml) {
		ArrayList<Elective> electives = electiveService.getElectives(electiveXml);
		boolean result = electiveService.courseWithdraw(electives);
		return result + "";
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
		boolean result = electiveService.addElectives(electives);
		return result + "";
	}
}
