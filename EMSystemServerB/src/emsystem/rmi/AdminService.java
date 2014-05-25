package emsystem.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import emsystem.model.Course;
import emsystem.model.Student;

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
	
	public String getMajorName() throws RemoteException;
	
	/**
	 * 对课程的操作
	 */
	
	public ArrayList<Course> getCourses() throws RemoteException;
	
	public boolean addCourse(Course course) throws RemoteException;
	
	public boolean modifyCourse(Course course) throws RemoteException;
	
	public boolean deleteCourse(String pCourseId) throws RemoteException;
	
	/**
	 * 对选课信息的操作
	 */
	public ArrayList<Student> getChoosedStudents(String pCourseId) throws RemoteException;
	
	public ArrayList<Course> getUnsharedCourses() throws RemoteException;
	/**
	 * 向总服务器提交结束跨专业选课请求
	 */
	public void postFinishChooseAction() throws RemoteException;
	
	/**
	 * 提交共享学生信息请求
	 * @throws RemoteException
	 */
	public void postShareStudentAction() throws RemoteException;
	
	/**
	 * 提交共享课程信息请求
	 * @throws RemoteException
	 */
	
	public void postShareCourseAction(ArrayList<String> pCourseIds) throws RemoteException;
	
	
	
}
