package emsystem.logic;

import java.io.Serializable;

public class Login implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1511076660917010954L;
	private UserType mType;
	private String mAccount;
	private String mPassword;
	
	public Login(UserType pType, String pAccount, String pPassword){
		mType = pType;
		mAccount = pAccount;
		mPassword = pPassword;
	}
	
	public UserType getType(){
		return mType;
	}
	
	public String getAccount(){
		return mAccount;
	}

	
	public String  getPassword(){
		return mPassword;
	}
}
