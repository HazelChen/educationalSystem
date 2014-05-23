package emsystem.logic;

public enum UserType {
    ADMIN("管理员"),
    STUDENT("学生");
    
    private final String mUserType;
    private UserType(String pUserType){
    	mUserType = pUserType;
    }
    
    public String getUserType(){
    	return mUserType;
    }

}
