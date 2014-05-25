package emsystem.logic;

import java.util.ArrayList;
import java.util.HashMap;

public class Inform {

	private static HashMap<String, ArrayList<String>> mInformMessages;
	
	public static HashMap<String, ArrayList<String>> getInforMessages(String pAccount){
		if (mInformMessages == null) {
			mInformMessages = new HashMap<String, ArrayList<String>>();
			mInformMessages.put(pAccount, new ArrayList<String>());
		}
		
		return mInformMessages;
	}
	
	public static void setMessages(HashMap<String, ArrayList<String>> pInformMessages){
		mInformMessages = pInformMessages;
	}
	
	public static void addMessages(String pAccount, ArrayList<String> pCourseIds){
		if (mInformMessages == null) {
			mInformMessages = new HashMap<String, ArrayList<String>>();
			mInformMessages.put(pAccount, pCourseIds);
			return;
		}
		for (int i = 0; i < pCourseIds.size(); i++) {
			mInformMessages.get(pAccount).add(pCourseIds.get(i));
		}
		
	}
}
