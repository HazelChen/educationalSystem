package emsystem.rao;

import java.util.ArrayList;

import emsystem.data.Choice;
import emsystem.socket.CommandConstants;
import emsystem.socket.CommunicationWithServer;
import emsystem.xml.ConfigConstant;
import emsystem.xml.XMLAnalyzer;
import emsystem.xml.XMLGenerater;

public class ChoiceRAO {

	public boolean add(Choice choice) {
		XMLGenerater generater = new XMLGenerater(ConfigConstant.ELECTIVE_ROOT, 
				ConfigConstant.ELECTIVE_ELEMENT, Choice.class, new Choice());
		generater.addElement(choice);
		String xml = generater.getXmlString();
		
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String result = communicationWithServer.communicate(CommandConstants.STUDENT_ELECTIVE, xml);
		Boolean resultBoolean = Boolean.valueOf(result);
		return resultBoolean;
	}
	
	public boolean remove(Choice choice) {
		XMLGenerater generater = new XMLGenerater(ConfigConstant.ELECTIVE_ROOT, 
				ConfigConstant.ELECTIVE_ELEMENT, Choice.class, new Choice());
		generater.addElement(choice);
		String xml = generater.getXmlString();
		
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String result = communicationWithServer.communicate(CommandConstants.COURSE_WITHDRAWAL, xml);
		Boolean resultBoolean = Boolean.valueOf(result);
		return resultBoolean;
	}
	
	public ArrayList<Choice> getServerChoises() {
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String xml = communicationWithServer.communicate(CommandConstants.ELECTIVE_RECORD);
		return getChoices(xml);
	}

	public ArrayList<Choice> getStudentChoice(String sid) {
		CommunicationWithServer communicationWithServer = CommunicationWithServer.getInstance();
		String xml = communicationWithServer.communicate(CommandConstants.GET_STUDENT_ELECTIVES, sid);
		return getChoices(xml);
	}
	 
	private ArrayList<Choice> getChoices(String xml) {
		XMLAnalyzer analyzer = new XMLAnalyzer(xml);
		ArrayList<Choice> choices = new ArrayList<>();
		while (analyzer.hasNext()) {
			ArrayList<String> values = analyzer.next();
			int score = 0;
			String scoreString = values.get(2);
			if (!scoreString.equals("")) {
				score = Integer.parseInt(scoreString);
			}
			Choice choice = new Choice(values.get(1), values.get(0), score);
			choices.add(choice);
		}
		return choices;
	}
}
