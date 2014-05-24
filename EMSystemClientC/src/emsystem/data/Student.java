package emsystem.data;

import java.io.Serializable;


public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3965165557955422153L;
	
	private String mId;//ѧ��
	private String mName;//����
	private String mSex;//�Ա�
	private String mMajor;//רҵ
	
	private String mPwd;//����
	
	public Student(String pId, String PName, String pSex, String pMajor,String pPwd){
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
		return mMajor;
	}
	
	public String getPwd(){
		return mPwd;
	}
}
