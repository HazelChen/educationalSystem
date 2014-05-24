package data;

import java.io.Serializable;

public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8076731434972170530L;
	private String mId;//编号
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
	}
}
