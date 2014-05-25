package emsystem.rao;

import java.util.ArrayList;

import emsystem.model.Course;
import emsystem.socket.CommandConstants;
import emsystem.socket.CommunicationWithServer;
import emsystem.xml.XMLAnalyzer;

public class CourseRAO {

	public Course find(String id) {
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String xml = communicationWithServer.communicate(CommandConstants.ASK_FOR_COURSE_INFORMATION, id);
		
		XMLAnalyzer analyzer = new XMLAnalyzer(xml);
		if (analyzer.hasNext()) {
			ArrayList<String> values = analyzer.next();
			Course course = new Course(values.get(0), values.get(1), 
					Integer.parseInt(values.get(2)), values.get(3), values.get(4), values.get(4));
			return course;
		} else {
			return new Course();
		}
	}
}
