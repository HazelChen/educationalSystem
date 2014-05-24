package emsystem.data;

import java.io.Serializable;

public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8076731434972170530L;
	private String mId;
	private String mCourseName;
	private int mCredit;
	private String mCourseTime;//¿ÎÊ±
	private String mTeacher;
	private String mAddress;
	private int mShareFlag;
	
	public Course(String pId, String pCourseName, int pCredit,String pCourseTime, String pTeacher, String pAddress, int pShareFlag){
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
	
	public int getShareFlag(){
		return mShareFlag;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmCourseName() {
		return mCourseName;
	}

	public void setmCourseName(String mCourseName) {
		this.mCourseName = mCourseName;
	}

	public int getmCredit() {
		return mCredit;
	}

	public void setmCredit(int mCredit) {
		this.mCredit = mCredit;
	}

	public String getmCourseTime() {
		return mCourseTime;
	}

	public void setmCourseTime(String mCourseTime) {
		this.mCourseTime = mCourseTime;
	}

	public String getmTeacher() {
		return mTeacher;
	}

	public void setmTeacher(String mTeacher) {
		this.mTeacher = mTeacher;
	}

	public String getmAddress() {
		return mAddress;
	}

	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public int getmShareFlag() {
		return mShareFlag;
	}

	public void setmShareFlag(int mShareFlag) {
		this.mShareFlag = mShareFlag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
