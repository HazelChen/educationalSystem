package edu.nju.educationSystem.server.service;

import java.util.ArrayList;

import edu.nju.educationSystem.server.model.Course;
import edu.nju.educationSystem.server.model.Elective;
import edu.nju.educationSystem.server.model.Major;
import edu.nju.educationSystem.server.model.Student;
import edu.nju.educationSystem.server.network.CommandConstants;
import edu.nju.educationSystem.server.xmlHandler.XMLTransform;
import edu.nju.educationSystem.server.xmlHandler.XMLValidate;

public class ServiceFacade {
	private StudentService studentService;
	private CourseService courseService;
	private ElectiveService electiveService;
	
	private XMLTransform xmlTransform;
	private XMLValidate xmlValidate;
	
	public ServiceFacade() {
		studentService = new StudentService();
		courseService = new CourseService();
		electiveService = new ElectiveService();
		
		xmlTransform = new XMLTransform();
		xmlValidate = new XMLValidate();
	}
	
	public String networkCommandExecute(String major, String command, String xml) {
		switch (command) {
		case CommandConstants.COURSE_WITHDRAWAL:
			return courseWithdraw(major, xml);
		
		case CommandConstants.ELECTIVE_RECORD:
			return getElectiveRecord(major);
			
		case CommandConstants.GET_COURSE_INFORMATION_BY_ID:
			return askForCourse(major, xml);
			
		case CommandConstants.NOT_SELECTED_COURSE_A:
			return notSelectedCourseA(major, xml);
			
		case CommandConstants.NOT_SELECTED_COURSE_B:
			return notSelectedCourseB(major, xml);
			
		case CommandConstants.NOT_SELECTED_COURSE_C:
			return notSelectedCourseC(major, xml);
			
		case CommandConstants.SHARE_COURSE:
			return addCourse(major, xml);
			
		case CommandConstants.STUDENT_DATA:
			return addStudents(major, xml);
			
		case CommandConstants.STUDENT_ELECTIVE:
			return addElective(major, xml);
			
		case CommandConstants.GET_STUDENT_ELECTIVES:
			return getStudentElectives(major, xml);
			
		default:
			System.err.println("error:wrong command:" + command);
			return "useless return";
		}
		
	}
	
	private String getStudentElectives(String major, String sid) {
		ArrayList<Elective> electives = electiveService.getStudentsChoise(sid);
		String electiveXML = electiveService.getElectivesXml(electives);
		String out = tranformOut(major, electiveXML, "choice");
		return out;
	}

	private String notSelectedCourseA(String major, String sid) {
		ArrayList<Course> courses = courseService.notSelectedCourseA(sid);
		String xml = courseService.toCourseXml(courses);
		String out = tranformOut(major, xml, "class");
		return out;
	}
	
	private String notSelectedCourseB(String major, String sid) {
		ArrayList<Course> courses = courseService.notSelectedCourseB(sid);
		String xml = courseService.toCourseXml(courses);
		String out = tranformOut(major, xml, "class");
		return out;
	}
	
	private String notSelectedCourseC(String major, String sid) {
		ArrayList<Course> courses = courseService.notSelectedCourseC(sid);
		String xml = courseService.toCourseXml(courses);
		String out = tranformOut(major, xml, "class");
		return out;
	}
	
	private String askForCourse(String major, String cid) {
		Course course = courseService.getCourse(cid);
		String xml = courseService.toCourseXml(course);
		String out = tranformOut(major, xml, "class");
		return out;
	}
	
	private String courseWithdraw(String major, String electiveXml) {
		String standardXml = tranformIn(major, electiveXml, "choice");
		ArrayList<Elective> electives = electiveService.getElectives(standardXml);
		boolean result = electiveService.courseWithdraw(electives);
		return result + "";
	}
	
	private String getElectiveRecord(String majorString) {
		Major major = Major.广告学;
		switch (majorString) {
		case "B":
			major = Major.物理;
			break;
		case "C":
			major = Major.软件工程;
		}
		
		ArrayList<Elective> electives = electiveService.getAllElective(major);
		String electivesXml = electiveService.getElectivesXml(electives);
		String out = tranformOut(majorString, electivesXml, "choice");
		return out;
	}
	
	private String addCourse(String major, String courseXml) {
		String in = tranformIn(major, courseXml, "class");
		ArrayList<Course> courses = courseService.getCourses(in);
		courseService.addCourses(courses);
		return "useless return";
	}
	
	private String addStudents(String major, String studentXml) {
		String in = tranformIn(major, studentXml, "student");
		ArrayList<Student> students = studentService.getStudents(in);
		studentService.addStudents(students);
		return "useless return";
	}
	
	private String addElective(String major, String electiveXml) {
		String in = tranformIn(major, electiveXml, "choice");
		ArrayList<Elective> electives = electiveService.getElectives(in);
		boolean result = electiveService.addElectives(electives);
		return result + "";
	}
	
	private String tranformIn(String major, String source, String type) {
		//xmlValidate.validateXml(type + major, source);
		String result = xmlTransform.transform(source, type + "ToT");
		//xmlValidate.validateXml(type + "T", result);
		return result;
	}
	
	private String tranformOut(String major, String source, String type) {
		//xmlValidate.validateXml(type + "T", source);
		String result = xmlTransform.transform(source, type + "To" + major);
		
		//xmlValidate.validateXml(type + major, result);
		return result;
	}
}
