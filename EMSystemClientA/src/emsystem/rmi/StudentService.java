package emsystem.rmi;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import emsystem.data.Course;
import emsystem.data.Student;

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
	
	public Course[] getMyCourses(String pCourseId) throws RemoteException;
	
	public int[] getScores(String pStudentId) throws RemoteException;

	/**
	 * ��ʾ�γ�Ϊδѡ�γ̡�
	 * @return
	 */
	public Course[] getCoursesFromA(String pId) throws RemoteException;
	
	public Course[] getCoursesFromB(String pId) throws RemoteException;
	
	public Course[] getCoursesFromC(String pId) throws RemoteException;
	
	public boolean[] chooseCourses(String pId, ArrayList<String> pCourseId) throws RemoteException;
	
	

}
