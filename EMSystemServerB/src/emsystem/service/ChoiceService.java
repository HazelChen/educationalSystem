package emsystem.service;

import java.util.ArrayList;

import emsystem.dao.ChoiceDAO;
import emsystem.model.Choice;
import emsystem.rao.ChoiceRAO;

public class ChoiceService {
	private ChoiceDAO choiceDAO;
	private ChoiceRAO choiceRAO;
	
	public ChoiceService() {
		choiceDAO = new ChoiceDAO();
		choiceRAO = new ChoiceRAO();
	}
	
	public ArrayList<Choice> getMyChoice(String sid) {
		ArrayList<Choice> result =  choiceDAO.getStudentChoice(sid);
		ArrayList<Choice> remoteChoices = choiceRAO.getStudentChoice(sid);
		result.addAll(remoteChoices);
		return result;
		
	}
	
	public boolean[] choice(ArrayList<Choice> choices) {
		boolean[] result = new boolean[choices.size()];
		
		for (int i = 0; i < choices.size(); i++) {
			Choice choice = choices.get(i);
			String cid = choice.getCourseId();
			if (cid.startsWith("2")) {
				result[i] = choiceDAO.add(choice);
			} else {
				result[i] = choiceRAO.add(choice);
			}
		}
		return result;
	}
	
	public boolean[] drop(ArrayList<Choice> choices) {
		boolean[] result = new boolean[choices.size()];
		
		for (int i = 0; i < choices.size(); i++) {
			Choice choice = choices.get(i);
			String cid = choice.getCourseId();
			if (cid.startsWith("2")) {
				result[i] = choiceDAO.remove(choice);
			} else {
				result[i] = choiceRAO.remove(choice);
			}
		}
		return result;
	}
	
	public void insertChoisesFromTotalServer() {
		ArrayList<Choice> choices = choiceRAO.getServerChoises();
		for (Choice choice : choices) {
			choiceDAO.add(choice);
		}
	}
	
}
