package emsystem.service;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import emsystem.data.Course;
import emsystem.data.Student;
import emsystem.rmi.RMI;
import emsystem.rmi.StudentService;

public class StudentServiceImp implements StudentService{
	StudentService ss;
	public StudentServiceImp() throws RemoteException {
		try {
//			if(System.getSecurityManager()==null)
//		        System.setSecurityManager(new RMISecurityManager());
			ss= (StudentService) Naming.lookup(RMI.getIp()+":1099/student");
			}catch(Exception e){
			e.printStackTrace();
			}
	}

	@Override
	public boolean studentLogin(String pId, String pPassword)
			throws RemoteException {
		// TODO Auto-generated method stub
		boolean b = false;
		b = ss.studentLogin(pId, pPassword);
		return b;
	}

	@Override
	public Student getStudentInfo(String pId) throws RemoteException {
		// TODO Auto-generated method stub
		Student s =null;
		s = ss.getStudentInfo(pId);
		return s;
	}

	@Override
	public HashMap<Course, Integer> getMyCourses(String pStudentId)
			throws RemoteException {
		// TODO Auto-generated method stub
		HashMap<Course,Integer> map = new HashMap<Course, Integer>();
		map = ss.getMyCourses(pStudentId);
		return map;
	}

	@Override
	public ArrayList<Course> getCoursesFromA(String pId) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<Course> list = new ArrayList<Course>();
		list = ss.getCoursesFromA(pId);
		return list;
	}

	@Override
	public ArrayList<Course> getCoursesFromB(String pId) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<Course> list = new ArrayList<Course>();
		list = ss.getCoursesFromB(pId);
		return list;
	}

	@Override
	public ArrayList<Course> getCoursesFromC(String pId) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<Course> list = new ArrayList<Course>();
		list = ss.getCoursesFromC(pId);
		return list;
	}

	@Override
	public boolean[] chooseCourses(String pId, ArrayList<String> pCourseId)
			throws RemoteException {
		// TODO Auto-generated method stub
		boolean[] b = ss.chooseCourses(pId, pCourseId);
		return b;
	}

	@Override
	public boolean[] dropCourses(String pStudentId, ArrayList<String> pCourseId)
			throws RemoteException {
		// TODO Auto-generated method stub
		boolean[] b = ss.dropCourses(pStudentId, pCourseId);
		return b;
	}

	@Override
	public ArrayList<Course> getCoursesToDrop(String pStudentId)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<Course> list = new ArrayList<Course>();
		list = ss.getCoursesToDrop(pStudentId);
		return list;
	}

}
