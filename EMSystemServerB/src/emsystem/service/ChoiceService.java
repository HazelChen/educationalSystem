package emsystem.service;

import java.util.ArrayList;

import emsystem.dao.ChoiceDAO;
import emsystem.model.Choice;

public class ChoiceService {
	private ChoiceDAO choiceDAO;
	
	public ChoiceService() {
		choiceDAO = new ChoiceDAO();
	}
	
	public ArrayList<Choice> getMyChoice(String sid) {
		return choiceDAO.getStudentChoice(sid);
	}
	
}
