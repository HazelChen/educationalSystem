package emsystem.model;

import java.io.Serializable;

public class Student implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4549192449721237752L;
	private String id;
	private String name;
	private String sex;
	private String major;
	private String accountId;
	
	public Student(){}
	
	public Student(String id, String name, String sex, String major, String accountId) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.major = major;
		this.accountId = accountId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


}
