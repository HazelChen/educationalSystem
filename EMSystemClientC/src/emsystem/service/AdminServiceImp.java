package emsystem.service;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import emsystem.data.Course;
import emsystem.data.Student;
import emsystem.rmi.AdminService;
import emsystem.rmi.RMI;

public class AdminServiceImp implements AdminService{
	AdminService as;
	public AdminServiceImp() {
		try {
		as=(AdminService) Naming.lookup(RMI.getIp()+":1099/admin");
		}catch(Exception e){
		e.printStackTrace();
		}
		
	}

	@Override
	public boolean adminLogin(String pAccount, String pPassword)
			throws RemoteException {
		// TODO Auto-generated method stub
		boolean b = false;
		b = as.adminLogin(pAccount, pPassword);
		return b;
	}

	@Override
	public ArrayList<Student> getStudents() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<Student> list = new ArrayList<Student>();
		list = as.getStudents();
		return list;
	}

	@Override
	public boolean addStudent(Student pStudent) throws RemoteException {
		// TODO Auto-generated method stub
		boolean b = false;
		b = as.addStudent(pStudent);
		return b;
	}

	@Override
	public boolean modifyStudent(Student pStudent) throws RemoteException {
		// TODO Auto-generated method stub
		boolean b = false;
		b = as.modifyStudent(pStudent);
		return b;
	}

	@Override
	public boolean deleteStudent(String pStudentId) throws RemoteException {
		// TODO Auto-generated method stub
		boolean b = false;
		b = as.deleteStudent(pStudentId);
		return b;
	}

	@Override
	public String getMajorName() throws RemoteException {
		// TODO Auto-generated method stub
		return "Èí¼þ¹¤³Ì";
	}

	@Override
	public ArrayList<Course> getCourses() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<Course> list = new ArrayList<Course>();
		list = as.getCourses();
		return list;
	}

	@Override
	public boolean addCourse(Course course) throws RemoteException {
		// TODO Auto-generated method stub
		boolean b = false;
		b = as.addCourse(course);
		return b;
	}

	@Override
	public boolean modifyCourse(Course course) throws RemoteException {
		// TODO Auto-generated method stub
		boolean b = false;
		b = as.modifyCourse(course);
		return b;
	}

	@Override
	public boolean deleteCourse(String pCourseId) throws RemoteException {
		// TODO Auto-generated method stub
		boolean b = false;
		b = as.deleteCourse(pCourseId);
		return b;
	}

	@Override
	public ArrayList<Student> getChoosedStudents(String pCourseId)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<Student> list = new ArrayList<Student>();
		list = as.getChoosedStudents(pCourseId);
		return list;
	}

	@Override
	public ArrayList<Course> getUnsharedCourses() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<Course> list = new ArrayList<Course>();
		list = as.getUnsharedCourses();
		return list;
	}

	@Override
	public void postFinishChooseAction() throws RemoteException {
		// TODO Auto-generated method stub
		as.postFinishChooseAction();
	}

	@Override
	public void postShareStudentAction() throws RemoteException {
		// TODO Auto-generated method stub
		as.postShareStudentAction();
	}

	@Override
	public void postShareCourseAction(ArrayList<String> pCourseIds)
			throws RemoteException {
		// TODO Auto-generated method stub
		as.postShareCourseAction(pCourseIds);
	}

}
