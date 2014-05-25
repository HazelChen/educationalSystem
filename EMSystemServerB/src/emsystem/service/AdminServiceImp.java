package emsystem.service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import emsystem.model.Course;
import emsystem.model.Student;
import emsystem.rmi.AdminService;

public class AdminServiceImp implements AdminService{

	@Override
	public boolean adminLogin(String pAccount, String pPassword)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Student> getStudents() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addStudent(Student pStudent) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyStudent(Student pStudent) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudent(String pStudentId) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getMajorName() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Course> getCourses() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCourse(Course course) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyCourse(Course course) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCourse(String pCourseId) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Student> getChoosedStudents(String pCourseId)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Course> getUnsharedCourses() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void postFinishChooseAction() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postShareStudentAction() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postShareCourseAction(ArrayList<String> pCourseIds)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
