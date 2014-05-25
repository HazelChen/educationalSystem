package emsystem.data;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private String mId;
	private String mName;
	private String mSex;
	private String mMajor;
	private String mPassword;
	
	public Student(String pId, String PName, String pSex, String pMajor,String pPassword){
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
		return mMajor;
	}

	
	public void setmName(String mName) {
		this.mName = mName;
	}


	public void setmSex(String mSex) {
		this.mSex = mSex;
	}

	public void setmMajor(String mMajor) {
		this.mMajor = mMajor;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

}
