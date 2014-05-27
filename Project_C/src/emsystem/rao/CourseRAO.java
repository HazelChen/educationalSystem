package emsystem.rao;

import java.util.ArrayList;

import emsystem.data.Course;
import emsystem.socket.CommandConstants;
import emsystem.socket.CommunicationWithServer;
import emsystem.xml.ConfigConstant;
import emsystem.xml.XMLAnalyzer;
import emsystem.xml.XMLGenerater;

public class CourseRAO {

	public Course find(String id) {
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String xml = communicationWithServer.communicate(CommandConstants.GET_COURSE_INFORMATION_BY_ID, id);
		
		XMLAnalyzer analyzer = new XMLAnalyzer(xml);
		if (analyzer.hasNext()) {
			ArrayList<String> values = analyzer.next();
			Course course = new Course(values.get(0), values.get(1), 
					Integer.parseInt(values.get(2)), Integer.parseInt(values.get(3)), 
					values.get(4), values.get(5), values.get(6));
			return course;
		} else {
			return new Course();
		}
	}
	
	public ArrayList<Course> getNotSelectedInA(String sid) {
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String xml = communicationWithServer.communicate(CommandConstants.NOT_SELECTED_COURSE_A, sid);
		
		return manyCourseXmlAnalyze(xml);
	}
	
	public ArrayList<Course> getNotSelectedInB(String sid) {
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String xml = communicationWithServer.communicate(CommandConstants.NOT_SELECTED_COURSE_B, sid);
		return manyCourseXmlAnalyze(xml);
	}
	
	public ArrayList<Course> getNotSelectedInC(String sid) {
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String xml = communicationWithServer.communicate(CommandConstants.NOT_SELECTED_COURSE_C, sid);
		return manyCourseXmlAnalyze(xml);
	}
	
	public void add(ArrayList<Course> courses) {
		XMLGenerater xmlGenerater = new XMLGenerater(ConfigConstant.COURSE_ROOT, 
				ConfigConstant.COURSE_ELEMENT, Course.class, new Course());
		for (Course course : courses) {
			xmlGenerater.addElement(course);
		}
		String xml = xmlGenerater.getXmlString();
				
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		communicationWithServer.communicate(CommandConstants.SHARE_COURSE, xml);
	}
	
	private ArrayList<Course> manyCourseXmlAnalyze(String xml) {
		ArrayList<Course> courses = new ArrayList<>();
		XMLAnalyzer analyzer = new XMLAnalyzer(xml);
		while (analyzer.hasNext()) {
			ArrayList<String> values = analyzer.next();
			Course course = new Course(values.get(0), values.get(1), 
					Integer.parseInt(values.get(2)), Integer.parseInt(values.get(3)), 
					values.get(4), values.get(5), values.get(6));
			courses.add(course);
		}
		return courses;
	}
}
