package emsystem.logic;

public enum UserType {
    ADMIN("����Ա"),
    STUDENT("ѧ��");
    
    private final String mUserType;
    private UserType(String pUserType){
    	mUserType = pUserType;
    }
    
    public String getUserType(){
    	return mUserType;
    }

}
