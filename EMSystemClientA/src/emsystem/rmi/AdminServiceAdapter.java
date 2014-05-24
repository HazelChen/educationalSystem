package emsystem.rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;

import emsystem.data.Course;
import emsystem.data.Student;

public class AdminServiceAdapter {

	private static AdminServiceAdapter mAdapter;

	private AdminServiceAdapter() {

	}

	public static AdminServiceAdapter getInstance() {
		return mAdapter == null ? new AdminServiceAdapter() : mAdapter;
	}

	public boolean adminLogin(String pAccount, String pPassword) {
		boolean isValid = false;
		try {
			isValid = RMI.getAdminService().adminLogin(pAccount, pPassword);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return isValid;
	}

	public ArrayList<Student> getStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			students = RMI.getAdminService().getStudents();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return students;
	}

	public boolean addStudent(Student pStudent){
		boolean isSuccess = false;
		try {
			isSuccess = RMI.getAdminService().addStudent(pStudent);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public boolean modifyStudent(Student pStudent){
		boolean isSuccess = false;
		try {
			isSuccess = RMI.getAdminService().modifyStudent(pStudent);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public boolean deleteStudent(String pStudentId){
		boolean isSuccess = false;
		
		try {
			isSuccess = RMI.getAdminService().deleteStudent(pStudentId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public ArrayList<Course> getCourses() {
		ArrayList<Course> courses = null;
		try {
			courses = RMI.getAdminService().getCourses();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return courses;
	}

	public String getMajorName() {
		String name = null;
		try {
			name = RMI.getAdminService().getMajorName();
		} catch (RemoteException e) {
		}
		return name;
	}

}
