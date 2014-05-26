package emsystem.service;

import java.util.ArrayList;

import emsystem.data.Choice;
import emsystem.data.Course;
import emsystem.data.Student;
import emsystem.socket.CommandConstants;
import emsystem.socket.CommunicationWithServer;
import emsystem.xml.ConfigConstant;
import emsystem.xml.XMLAnalyzer;
import emsystem.xml.XMLGenerater;

public class DealWithTotalServer {
	
	public void choiceOtherMajor(Choice choice) {
		XMLGenerater generater = new XMLGenerater(ConfigConstant.ELECTIVE_ROOT, 
				ConfigConstant.ELECTIVE_ELEMENT, Choice.class, new Choice());
		generater.addElement(choice);
		String xml = generater.getXmlString();
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		communicationWithServer.communicate(CommandConstants.STUDENT_ELECTIVE, xml);
	}
	
	public void dropOtherMajor(Choice choice) {
		XMLGenerater generater = new XMLGenerater(ConfigConstant.ELECTIVE_ROOT, 
				ConfigConstant.ELECTIVE_ELEMENT, Choice.class, new Choice());
		generater.addElement(choice);
		String xml = generater.getXmlString();
		
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		communicationWithServer.communicate(CommandConstants.COURSE_WITHDRAWAL, xml);
	}
	
	public Course getOtherMajorCourse(String cid) {
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String xml = communicationWithServer.communicate(CommandConstants.GET_COURSE_INFORMATION_BY_ID, cid);
		
		XMLAnalyzer analyzer = new XMLAnalyzer(xml);
		if (analyzer.hasNext()) {
			ArrayList<String> values = analyzer.next();
			Course course = new Course(values.get(0), values.get(1), 
					Integer.parseInt(values.get(2)), values.get(3), 
					values.get(4), values.get(5), values.get(6));
			return course;
		} else {
			return new Course();
		}
	}
	
	public ArrayList<Choice> getAllChoices() {
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String xml = communicationWithServer.communicate(CommandConstants.ELECTIVE_RECORD);
		
		XMLAnalyzer analyzer = new XMLAnalyzer(xml);
		ArrayList<Choice> choices = new ArrayList<>();
		while (analyzer.hasNext()) {
			ArrayList<String> values = analyzer.next();
			Choice choice = new Choice(values.get(0), values.get(1), Integer.parseInt(values.get(2)));
			choices.add(choice);
		}
		return choices;
	}
	
	public void shareStudents(ArrayList<Student> students) {
		XMLGenerater xmlGenerater = new XMLGenerater(ConfigConstant.STUDENT_ROOT, 
				ConfigConstant.STUDENT_ELEMENT, Student.class, new Student());
		for (Student student : students) {
			xmlGenerater.addElement(student);
		}
		String xml = xmlGenerater.getXmlString();
				
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		communicationWithServer.communicate(CommandConstants.STUDENT_DATA, xml);
	}
	
	public void shareCourse(ArrayList<Course> courses) {
		XMLGenerater xmlGenerater = new XMLGenerater(ConfigConstant.COURSE_ROOT, 
				ConfigConstant.COURSE_ELEMENT, Course.class, new Course());
		for(Course course : courses) {
			xmlGenerater.addElement(course);
		}
		String xml = xmlGenerater.getXmlString();
		
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		communicationWithServer.communicate(CommandConstants.SHARE_COURSE, xml);
	}
	
	public ArrayList<Course> getNotSelectedInC(String sid) {
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String xml = communicationWithServer.communicate(CommandConstants.NOT_SELECTED_COURSE_C, sid);
		return manyCourseXmlAnalyze(xml);
	}
	
	public ArrayList<Course> getNotSelectedInB(String sid) {
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String xml = communicationWithServer.communicate(CommandConstants.NOT_SELECTED_COURSE_B, sid);
		return manyCourseXmlAnalyze(xml);
	}
	
	private ArrayList<Course> manyCourseXmlAnalyze(String xml) {
		ArrayList<Course> courses = new ArrayList<>();
		XMLAnalyzer analyzer = new XMLAnalyzer(xml);
		while (analyzer.hasNext()) {
			ArrayList<String> values = analyzer.next();
			Course course = new Course(values.get(0), values.get(1), 
					Integer.parseInt(values.get(2)), values.get(3), 
					values.get(4), values.get(5), values.get(6));
			courses.add(course);
		}
		return courses;
	}
	
}
