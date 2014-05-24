package emsystem.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import emsystem.data.Course;
import emsystem.data.Student;

public interface AdminService extends Remote{

	/**
	 * ��¼����
	 * @param pAccount
	 * @param pPassword
	 * @return
	 * @throws RemoteException
	 */
	public boolean adminLogin(String pAccount, String pPassword) throws RemoteException;
	
	/**
	 * 
	 *��ѧ���Ĳ���
	 */
	public Student[] getStudents() throws RemoteException;
	
	public boolean addStudent(Student pStudent) throws RemoteException;
	
	public boolean modifyStudent(Student pStudent) throws RemoteException;
	
	public boolean deleteStudent(String pStudentId) throws RemoteException;
	
	public Course[] getCourses() throws RemoteException;
	
	public String getMajorName() throws RemoteException;
}