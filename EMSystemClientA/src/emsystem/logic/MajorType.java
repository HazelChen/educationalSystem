package emsystem.logic;

public enum MajorType {
	DEPARTMENT_A("DepartmentA"),
	DEPARTMENT_B("π„∏Ê—ß"),
	DEPARTMENT_C("DepartmentC");
	
	
	private final String mDepartment;
	private MajorType(String pDepartment){
		mDepartment = pDepartment;
	}
	
	public String getDepartment(){
		return mDepartment;
	}
}
