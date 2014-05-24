package emsystem.data;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3965165557955422153L;
	
	private String mId;
	private String mName;
	private String mSex;
	private String mMajor;
	
	public Student(String pId, String PName, String pSex, String pMajor){
		mId = pId;
		mName = PName;
		mSex = pSex;
		mMajor = pMajor;
		
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
}