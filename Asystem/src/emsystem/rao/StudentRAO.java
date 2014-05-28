package emsystem.rao;

import java.util.ArrayList;

import emsystem.data.Student;
import emsystem.socket.CommandConstants;
import emsystem.socket.CommunicationWithServer;
import emsystem.xml.ConfigConstant;
import emsystem.xml.XMLAnalyzer;
import emsystem.xml.XMLGenerater;

public class StudentRAO {
	
	public void add(ArrayList<Student> students) {
		XMLGenerater xmlGenerater = new XMLGenerater(ConfigConstant.STUDENT_ROOT, 
				ConfigConstant.STUDENT_ELEMENT, Student.class, new Student());
		for (Student student : students) {
			xmlGenerater.addElement(student);
		}
		String xml = xmlGenerater.getXmlString();
				
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		communicationWithServer.communicate(CommandConstants.STUDENT_DATA, xml);
	}
	
	public Student getStudent(String sid) {
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String studentXML = communicationWithServer.communicate(CommandConstants.GET_STUDENT_INFORMATION_BY_ID, sid);
		
		Student student = null;
		
		XMLAnalyzer analyzer = new XMLAnalyzer(studentXML);
		if (analyzer.hasNext()) {
			ArrayList<String> values = analyzer.next();
			student = new Student(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4));
		}
		
		return student;
	}
}