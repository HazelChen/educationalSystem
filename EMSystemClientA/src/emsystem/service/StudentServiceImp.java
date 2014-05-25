package emsystem.service;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import emsystem.data.Account;
import emsystem.data.Choice;
import emsystem.data.Course;
import emsystem.data.Student;
import emsystem.rmi.AdminService;
import emsystem.rmi.RMI;
import emsystem.rmi.StudentService;

@SuppressWarnings("serial")
public class StudentServiceImp  implements StudentService{
	
	StudentService ss;
	public StudentServiceImp() throws RemoteException {
		try {
			ss= (StudentService) Naming.lookup(RMI.getIp()+":8888/student");
			}catch(Exception e){
			e.printStackTrace();
			}
	}


	@Override
	public boolean studentLogin(String pId, String pPassword) {
		boolean b=false;
		try {
			b=ss.studentLogin(pId, pPassword);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public Student getStudentInfo(String pId){
		Student s=null;
		try {
			s=ss.getStudentInfo(pId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}


	@Override
	public HashMap<Course, Integer> getMyCourses(String pStudentId){
		HashMap<Course, Integer> map=null;
		try {
			map=ss.getMyCourses(pStudentId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}


	@Override
	public ArrayList<Course> getCoursesFromA(String pId){
		ArrayList<Course> result=null;
		try {
			result=ss.getCoursesFromA(pId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public ArrayList<Course> getCoursesFromB(String pId){
		ArrayList<Course> result=null;
		try {
			result=ss.getCoursesFromB(pId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public ArrayList<Course> getCoursesFromC(String pId){
		ArrayList<Course> result=null;
		try {
			result=ss.getCoursesFromC(pId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public boolean[] chooseCourses(String pId, ArrayList<String> pCourseIdlist){
		boolean[] result=null;
		try {
			result=ss.chooseCourses(pId, pCourseIdlist);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public boolean[] dropCourses(String pStudentId, ArrayList<String> pCourseId){
		boolean[] result=null;
		try {
			result=ss.dropCourses(pStudentId, pCourseId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public ArrayList<Course> getCoursesToDrop(String pStudentId){
		ArrayList<Course> result=null;
		try {
			result=ss.getCoursesToDrop(pStudentId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	

}
