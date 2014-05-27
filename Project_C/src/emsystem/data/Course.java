package emsystem.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Course implements Serializable,ModelSpecification{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String id;
	private String courseName;
	private int credit;
	private int courseTime;//¿ÎÊ±
	private String teacher;
	private String address;
	private String shareFlag;
	
	public Course(){}
	
	public Course(String pId, String pCourseName, int pCredit,int pCourseTime, String pTeacher, String pAddress, String pShareFlag){
		id = pId;
		courseName = pCourseName;
		credit = pCredit;
		courseTime = pCourseTime;
		teacher = pTeacher;
		address = pAddress;
		shareFlag = pShareFlag;
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(int courseTime) {
		this.courseTime = courseTime;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShareFlag() {
		return shareFlag;
	}

	public void setShareFlag(String shareFlag) {
		this.shareFlag = shareFlag;
	}


	@Override
	public Map<String, String> getFieldCorrespondence() {
		Map<String,String> map=new HashMap<String, String>();
		map.put("id", "Cno");
		map.put("courseName","Cnm");
		map.put("credit", "Ctm");
		map.put("courseTime", "Cpt");
		map.put("teacher", "Tec");
		map.put("address","Pla");
		map.put("shareFlag", "Share");
		return map;
	}

}
