package emsystem.data;


import java.io.Serializable;


public class Student implements Serializable{

	/**
	 * 
	 */
//	private static final long serialVersionUID = 3965165557955422153L;
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String sex;
	private String major;
	private String password;
	
	public Student() {}
	
	public Student(String pId, String PName, String pSex, String pMajor,String pPassword){
		id = pId;
		name = PName;
		sex = pSex;
		major = pMajor;
		password=pPassword;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
