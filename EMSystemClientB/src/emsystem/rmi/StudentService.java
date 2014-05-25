package emsystem.rmi;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import emsystem.model.Course;
import emsystem.model.Student;

public interface StudentService extends Remote{
	/**
	 * 
	 * 登录服务
	 */
	public boolean studentLogin(String pId, String pPassword) throws RemoteException;
	
	/**
	 * 学生
	 */
	public Student getStudentInfo(String pId) throws RemoteException;
	
	public HashMap<Course, Integer> getMyCourses(String pStudentId) throws RemoteException;
	
//	public int[] getScores(String pStudentId) throws RemoteException;

	/**
	 * 显示课程为未选课程。
	 * @return
	 */
	public ArrayList<Course> getCoursesFromA(String pId) throws RemoteException;
	
	public ArrayList<Course> getCoursesFromB(String pId) throws RemoteException;
	
	public ArrayList<Course> getCoursesFromC(String pId) throws RemoteException;
	
	public boolean[] chooseCourses(String pId, ArrayList<String> pCourseId) throws RemoteException;
	
	/**
	 * 退选课程
	 * @param pStudentId
	 * @param pCourseId
	 * @return
	 * @throws RemoteException
	 */
	public boolean[] dropCourses(String pStudentId, ArrayList<String> pCourseId) throws RemoteException;
	
	public ArrayList<Course> getCoursesToDrop(String pStudentId) throws RemoteException;
		
	
}
