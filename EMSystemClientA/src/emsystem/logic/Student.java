package emsystem.logic;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3965165557955422153L;
	
	private String mId;
	private String mName;
	private String mSex;
	private MajorType mMajor;
	private String mPassword;
	
	public Student(String pId, String PName, String pSex, MajorType pMajor,String pPassword){
		mId = pId;
		mName = PName;
		mSex = pSex;
		mMajor = pMajor;
		mPassword=pPassword;
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

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmSex() {
		return mSex;
	}

	public void setmSex(String mSex) {
		this.mSex = mSex;
	}

	public MajorType getmMajor() {
		return mMajor;
	}

	public void setmMajor(MajorType mMajor) {
		this.mMajor = mMajor;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

}
