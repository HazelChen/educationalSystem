package emsystem.rao;

import java.util.ArrayList;

import emsystem.data.Student;
import emsystem.socket.CommandConstants;
import emsystem.socket.CommunicationWithServer;
import emsystem.xml.ConfigConstant;
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
}
