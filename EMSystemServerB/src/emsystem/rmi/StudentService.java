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
	 * ��¼����
	 */
	public boolean studentLogin(String pId, String pPassword) throws RemoteException;
	
	/**
	 * ѧ��
	 */
	public Student getStudentInfo(String pId) throws RemoteException;
	
	public HashMap<Course, Integer> getMyCourses(String pStudentId) throws RemoteException;
	
//	public int[] getScores(String pStudentId) throws RemoteException;

	/**
	 * ��ʾ�γ�Ϊδѡ�γ̡�
	 * @return
	 */
	public ArrayList<Course> getCoursesFromA(String pId) throws RemoteException;
	
	public ArrayList<Course> getCoursesFromB(String pId) throws RemoteException;
	
	public ArrayList<Course> getCoursesFromC(String pId) throws RemoteException;
	
	public boolean[] chooseCourses(String pId, ArrayList<String> pCourseId) throws RemoteException;
	
	/**
	 * ��ѡ�γ�
	 * @param pStudentId
	 * @param pCourseId
	 * @return
	 * @throws RemoteException
	 */
	public boolean[] dropCourses(String pStudentId, ArrayList<String> pCourseId) throws RemoteException;
	
	public ArrayList<Course> getCoursesToDrop(String pStudentId) throws RemoteException;
		
	
}
