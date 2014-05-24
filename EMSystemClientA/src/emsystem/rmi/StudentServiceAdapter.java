package emsystem.rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import emsystem.data.Course;
import emsystem.data.Student;

public class StudentServiceAdapter{
	
	private static StudentServiceAdapter mAdapter;
	
	private StudentServiceAdapter(){
		
	}
	public static StudentServiceAdapter getInstance(){
		return mAdapter == null? new StudentServiceAdapter() : mAdapter;
	}
	
	
	public boolean studentLogin(String pId, String pPassword){
		boolean isValid = false;
		try {
			isValid = RMI.getStudentService().studentLogin(pId, pPassword);
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
			student = RMI.getStudentService().getStudentInfo(pId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	public HashMap<Course, Integer> getMyCourses(String pId){
		HashMap<Course, Integer> courses = null;
		try {
			courses = RMI.getStudentService().getMyCourses(pId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return courses;
	}

	/**
	 * 显示课程为未选课程。
	 * @return
	 */
	public ArrayList<Course> getCoursesFromA(String pId){
		ArrayList<Course> courses = null;
		try {
			courses = RMI.getStudentService().getCoursesFromA(pId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return courses;
	}
	
	
	public ArrayList<Course> getCoursesFromB(String pId){
		ArrayList<Course> courses = null;
		try {
			courses = RMI.getStudentService().getCoursesFromB(pId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return courses;
	}
	
	public ArrayList<Course> getCoursesFromC(String pId){
		ArrayList<Course> courses = null;
		try {
			courses = RMI.getStudentService().getCoursesFromC(pId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return courses;
	}
	
	
	
	public boolean[] chooseCourses(String pId, ArrayList<String> pCourseId){
		boolean[] results = null;
		try {
			results = RMI.getStudentService().chooseCourses(pId, pCourseId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return results;
	}

}
