package emsystem.rmi;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import emsystem.data.Course;
import emsystem.data.Student;

public interface StudentService extends Remote{
	/**
	 * 
	 * 登录服务
	 */
	public boolean adminLogin(String pAccount, String pPassword) throws RemoteException;
	
	
	public boolean studentLogin(String pId, String pPassword) throws RemoteException;
	
	/**
	 * 学生
	 */
	public Student getStudentInfo(String pId) throws RemoteException;
	
	public Course[] getMyCourses(String pId) throws RemoteException;

	/**
	 * 显示课程为未选课程。
	 * @return
	 */
	public Course[] getCoursesFromA(String pId) throws RemoteException;
	
	public Course[] getCoursesFromB(String pId) throws RemoteException;
	
	public Course[] getCoursesFromC(String pId) throws RemoteException;
	
	public boolean[] chooseCourses(String pId, ArrayList<String> pCourseId) throws RemoteException;
	

}
