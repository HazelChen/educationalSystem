package emsystem.rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
	
	public Course[] getMyCourses(String pId){
		Course[] courses = null;
		try {
			courses = RMI.getStudentService().getMyCourses(pId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return courses;
	}

	public int[] getScores(String pStudentId){
		int[] scores = null;
		try {
			scores = RMI.getStudentService().getScores(pStudentId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scores;
	}
	/**
	 * 显示课程为未选课程。
	 * @return
	 */
	public Course[] getCoursesFromA(String pId){
		Course[] courses = null;
		try {
			courses = RMI.getStudentService().getCoursesFromA(pId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return courses;
	}
	
	public Course[] getCoursesFromB(String pId){
		Course[] courses = null;
		try {
			courses = RMI.getStudentService().getCoursesFromB(pId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return courses;
	}
	
	public Course[] getCoursesFromC(String pId){
		Course[] courses = null;
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
