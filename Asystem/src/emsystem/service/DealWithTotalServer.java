package emsystem.service;

import java.util.ArrayList;

import emsystem.data.Choice;
import emsystem.data.Course;
import emsystem.data.Student;
import emsystem.socket.CommandConstants;
import emsystem.socket.CommunicationWithServer;

public class DealWithTotalServer {
	
	public ArrayList<Course> getShareCourses() {
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String xml = communicationWithServer.communicate(CommandConstants.SHARE_COURSE);
		//TODO
		return new ArrayList<>();
	}
	
	public void choiceOtherMajor(Choice choice) {
		//TODO
		String xml  = "";
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		communicationWithServer.communicate(CommandConstants.STUDENT_ELECTIVE, xml);
	}
	
	public void dropOtherMajor(Choice choice) {
		//TODO
		String xml  = "";
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		communicationWithServer.communicate(CommandConstants.COURSE_WITHDRAWAL, xml);
	}
	
	public Course getOtherMajorCourse(String id) {
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String xml = communicationWithServer.communicate(CommandConstants.ASK_FOR_COURSE_INFORMATION, id);
		//TODO
		return new Course();
	}
	
	public ArrayList<Choice> getAllChoices() {
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String xml = communicationWithServer.communicate(CommandConstants.ELECTIVE_RECORD);
		//TODO
		return new ArrayList<>();
	}
	
	public void shareStudents(ArrayList<Student> students) {
		//TODO
		String xml = "";
				
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		communicationWithServer.communicate(CommandConstants.STUDENT_DATA, xml);
	}
	
	public void shareCourse(ArrayList<Course> courses) {
		//TODO
		String xml = "";
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		communicationWithServer.communicate(CommandConstants.SHARE_COURSE, xml);
	}
	
}
