package emsystem.data;

import java.io.Serializable;
import java.util.LinkedHashMap;
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
	private String courseTime;//��ʱ
	private String teacher;
	private String address;
	private String shareFlag;
	
	public Course(){}
	
	public Course(String pId, String pCourseName, int pCredit,String pCourseTime, String pTeacher, String pAddress, String pShareFlag){
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

	public String getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(String courseTime) {
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
		Map<String,String> map=new LinkedHashMap<>();
		map.put("id", "���");
		map.put("courseName","����");
		map.put("credit", "��ʱ");
		map.put("courseTime", "ѧ��");
		map.put("teacher", "��ʦ");
		map.put("address","�ص�");
		map.put("shareFlag", "����");
		return map;
	}

}
