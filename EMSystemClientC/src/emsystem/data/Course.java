package emsystem.data;

import java.io.Serializable;

public class Course implements Serializable{
	/**
	 * 
	 */
//	private static final long serialVersionUID = 8076731434972170530L;
	private static final long serialVersionUID = 1L;
/*	private String mId;//编号
	private String mCourseName;//名称
	
	private int mCredit;//学分
	private int mCourseTime;//课时
	private String mTeacher;//老师
	private String mAddress;//地点
	private String mShareFlag;//共享
	
	public Course(String pId, String pCourseName, int pCredit,int pCourseTime, String pTeacher, String pAddress, String pShareFlag){
		mId = pId;
		mCourseName = pCourseName;
		mCredit = pCredit;
		mCourseTime = pCourseTime;
		mTeacher = pTeacher;
		mAddress = pAddress;
		mShareFlag = pShareFlag;
	}
	
	public String getId(){
		return mId;
	}
	
	public String getCourseName(){
		return mCourseName;
	}
	
	public int getCredit(){
		return mCredit;
	}
	
	public int getCourseTime(){
		return mCourseTime;
	}
	
	public String getTeacher(){
		return mTeacher;
	}
	
	public String getAddress(){
		return mAddress;
	}
	
	public String getShareFlag(){
		return mShareFlag;
	}*/
	private String id;
	private String courseName;
	private int credit;
	private int courseTime;//课时
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
}
