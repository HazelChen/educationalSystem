package emsystem.model;

import java.io.Serializable;

public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8308435385396962156L;
	private String name;
	private String password;
	private int competence;
	
	public Account() {}
	
	public Account(String name, String password, int competence) {
		this.name = name;
		this.password = password;
		this.competence = competence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCompetence() {
		return competence;
	}

	public void setCompetence(int competence) {
		this.competence = competence;
	}

}
