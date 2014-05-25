package emsystem.data;

import java.io.Serializable;

public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String mId;
	private String mCourseName;
	private int mCredit;
	private String mCourseTime;//¿ÎÊ±
	private String mTeacher;
	private String mAddress;
	private String mShareFlag;
	
	public Course(){}
	
	public Course(String pId, String pCourseName, int pCredit,String pCourseTime, String pTeacher, String pAddress, String pShareFlag){
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
	
	public String getCourseTime(){
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
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public void setmCourseName(String mCourseName) {
		this.mCourseName = mCourseName;
	}

	public void setmCredit(int mCredit) {
		this.mCredit = mCredit;
	}

	public void setmCourseTime(String mCourseTime) {
		this.mCourseTime = mCourseTime;
	}

	public void setmTeacher(String mTeacher) {
		this.mTeacher = mTeacher;
	}

	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public String getmShareFlag() {
		return mShareFlag;
	}

	public void setmShareFlag(String mShareFlag) {
		this.mShareFlag = mShareFlag;
	}

}
