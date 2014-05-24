package data;

import java.io.Serializable;

import emsystem.logic.MajorType;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3965165557955422153L;
	
	private String mId;//学号
	private String mName;//姓名
	private String mSex;//性别
	private MajorType mMajor;//专业
	
	private String mPwd;//密码
	
	public Student(String pId, String PName, String pSex, MajorType pMajor,String pPwd){
		mId = pId;
		mName = PName;
		mSex = pSex;
		mMajor = pMajor;
		mPwd = pPwd;
	}
	
	public String getId(){
		return mId;
	}
	
	public String getName(){
		return mName;
	}
	
	public String getSex(){
		return mSex;
	}
	
	public String getMajor(){
		return mMajor.getDepartment();
	}
	
	public String getPwd(){
		return mPwd;
	}
}
