package emsystem.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import emsystem.data.Course;
import emsystem.data.Student;

public interface AdminService extends Remote{

	/**
	 * 登录服务
	 * @param pAccount
	 * @param pPassword
	 * @return
	 * @throws RemoteException
	 */
	public boolean adminLogin(String pAccount, String pPassword) throws RemoteException;
	
	/**
	 * 
	 *对学生的操作
	 */
	public ArrayList<Student> getStudents() throws RemoteException;
	
	public boolean addStudent(Student pStudent) throws RemoteException;
	
	public boolean modifyStudent(Student pStudent) throws RemoteException;
	
	public boolean deleteStudent(String pStudentId) throws RemoteException;
	
	public ArrayList<Course> getCourses() throws RemoteException;
	
	public String getMajorName() throws RemoteException;
}
