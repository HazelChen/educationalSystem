package emsystem.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import emsystem.model.Course;
import emsystem.model.Student;

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
	public ArrayList<Student> getStudents() throws RemoteException;
	
	public boolean addStudent(Student pStudent) throws RemoteException;
	
	public boolean modifyStudent(Student pStudent) throws RemoteException;
	
	public boolean deleteStudent(String pStudentId) throws RemoteException;
	
	public String getMajorName() throws RemoteException;
	
	/**
	 * �Կγ̵Ĳ���
	 */
	
	public ArrayList<Course> getCourses() throws RemoteException;
	
	public boolean addCourse(Course course) throws RemoteException;
	
	public boolean modifyCourse(Course course) throws RemoteException;
	
	public boolean deleteCourse(String pCourseId) throws RemoteException;
	
	/**
	 * ��ѡ����Ϣ�Ĳ���
	 */
	public ArrayList<Student> getChoosedStudents(String pCourseId) throws RemoteException;
	
	public ArrayList<Course> getUnsharedCourses() throws RemoteException;
	/**
	 * ���ܷ������ύ������רҵѡ������
	 */
	public void postFinishChooseAction() throws RemoteException;
	
	/**
	 * �ύ����ѧ����Ϣ����
	 * @throws RemoteException
	 */
	public void postShareStudentAction() throws RemoteException;
	
	/**
	 * �ύ����γ���Ϣ����
	 * @throws RemoteException
	 */
	
	public void postShareCourseAction(ArrayList<String> pCourseIds) throws RemoteException;
	
	
	
}
