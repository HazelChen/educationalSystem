package emsystem.rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;

import emsystem.logic.Course;
import emsystem.logic.Student;

public class StudentServiceAdapter{
	
	private static StudentServiceAdapter mAdapter;
	
	public static StudentServiceAdapter getInstance(){
		return mAdapter == null? new StudentServiceAdapter() : mAdapter;
	}
	
	public boolean adminLogin(String pAccount, String pPassword){
		boolean isValid = false;
		try {
			isValid =  RMI.getService().adminLogin(pAccount, pPassword);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return isValid;
	}
	
	public boolean studentLogin(String pId, String pPassword){
		boolean isValid = false;
		try {
			isValid = RMI.getService().studentLogin(pId, pPassword);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return isValid;
				
	}
	
	/**
	 * 学生
	 */
	public Student getStudentInfo(String pId){
		Student student = null;
		try {
			student = RMI.getService().getStudentInfo(pId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	public Course[] getMyCourses(String pId){
		Course[] courses = null;
		try {
			courses = RMI.getService().getMyCourses(pId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return courses;
	}

	/**
	 * 显示课程为未选课程。
	 * @return
	 */
	public Course[] getCoursesFromA(String pId){
		Course[] courses = null;
		try {
			courses = RMI.getService().getCoursesFromA(pId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return courses;
	}
	
	public Course[] getCoursesFromB(String pId){
		Course[] courses = null;
		try {
			courses = RMI.getService().getCoursesFromB(pId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return courses;
	}
	
	public Course[] getCoursesFromC(String pId){
		Course[] courses = null;
		try {
			courses = RMI.getService().getCoursesFromC(pId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return courses;
	}
	
	
	public boolean[] chooseCourses(String pId, ArrayList<String> pCourseId){
		boolean[] results = null;
		try {
			results = RMI.getService().chooseCourses(pId, pCourseId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return results;
	}

}
