package emsystem.service;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import emsystem.model.Course;
import emsystem.model.Student;
import emsystem.rmi.AdminService;
import emsystem.rmi.RMI;

public class AdminServiceImp  implements AdminService{
	AdminService as;
	
	public AdminServiceImp() {
		try {
		as=(AdminService) Naming.lookup(RMI.getIp()+":1099/admin");
		}catch(Exception e){
		e.printStackTrace();
		}
		
	}

	@Override
	public boolean adminLogin(String pAccount, String pPassword){
		
		boolean b=false;
		try {
			b=as.adminLogin(pAccount, pPassword);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public ArrayList<Student> getStudents() {
		ArrayList<Student> list=null;
		try {
			list=as.getStudents();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addStudent(Student pStudent){
		boolean b=false;
		try {
			b=as.addStudent(pStudent);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean modifyStudent(Student pStudent){
		boolean b=false;
		try {
			b=as.modifyStudent(pStudent);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean deleteStudent(String pStudentId){
		boolean b=false;
		try {
			b=as.deleteStudent(pStudentId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public String getMajorName(){
		return "π„∏Ê—ß";
	}

	@Override
	public ArrayList<Course> getCourses(){
		ArrayList<Course> list=null;
		try {
			list=as.getCourses();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addCourse(Course course){
		boolean b=false;
		try {
			b=as.addCourse(course);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean modifyCourse(Course course){
		boolean b=false;
		try {
			b=as.modifyCourse(course);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean deleteCourse(String pCourseId){
		boolean b=false;
		try {
			b=as.deleteCourse(pCourseId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public ArrayList<Student> getChoosedStudents(String pCourseId){
		ArrayList<Student> result=null;
		try {
			result=as.getChoosedStudents(pCourseId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<Course> getUnsharedCourses(){
		ArrayList<Course> result=null;
		try {
			result=as.getUnsharedCourses();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void postFinishChooseAction(){
		try {
			as.postFinishChooseAction();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void postShareStudentAction(){
		try {
			as.postShareStudentAction();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void postShareCourseAction(ArrayList<String> pCourseIds){
		try {
			as.postShareCourseAction(pCourseIds);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
