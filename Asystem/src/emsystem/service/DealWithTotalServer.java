package emsystem.service;

import java.util.ArrayList;

import emsystem.data.Choice;
import emsystem.data.Course;
import emsystem.socket.CommandConstants;
import emsystem.socket.CommunicationWithServer;

public class DealWithTotalServer {
	
	public ArrayList<Course> getShareCourses() {
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String xml = communicationWithServer.read(CommandConstants.SHARE_COURSE);
		//TODO
		return new ArrayList<>();
	}
	
	public void choiceOtherMajor(Choice choice) {
		//TODO
		String xml  = "";
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		communicationWithServer.write(CommandConstants.STUDENT_ELECTIVE, xml);
	}
	
	public void dropOtherMajor(Choice choice) {
		//TODO
		String xml  = "";
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		communicationWithServer.write(CommandConstants.COURSE_WITHDRAWAL, xml);
	}
	
	public Course getOtherMajorCourse(String id) {
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String xml = communicationWithServer.read(CommandConstants.ASK_FOR_COURSE_INFORMATION, id);
		//TODO
		return new Course();
	}
}