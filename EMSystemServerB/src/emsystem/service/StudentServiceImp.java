package emsystem.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import emsystem.model.Choice;
import emsystem.model.Course;
import emsystem.model.Student;
import emsystem.rmi.StudentService;

public class StudentServiceImp extends UnicastRemoteObject implements StudentService{
	private static final long serialVersionUID = -1592393992780046631L;
	
	private AccountService accountService;
	private emsystem.service.StudentService studentService;
	private ChoiceService choiceService;
	private CourceService courceService;

	public StudentServiceImp() throws RemoteException {
		super();
		accountService = new AccountService();
		studentService = new emsystem.service.StudentService();
		choiceService = new ChoiceService();
		courceService = new CourceService();
	}

	@Override
	public boolean studentLogin(String pId, String pPassword)
			throws RemoteException {
		return accountService.login(pId, pPassword);
	}

	@Override
	public Student getStudentInfo(String pId) throws RemoteException {
		return studentService.getStudent(pId);
	}

	@Override
	public HashMap<Course, Integer> getMyCourses(String pStudentId)
			throws RemoteException {
		HashMap<Course, Integer> map = new HashMap<Course, Integer>();
		
		ArrayList<Choice> list = choiceService.getMyChoice(pStudentId);
		for (int i = 0; i < list.size(); i++) {
			Choice choice = list.get(i);
			String cid = choice.getCourseId();
			Course course = courceService.findCourse(cid); 
			map.put(course, choice.getScore());
		}
		return map;
	}

	@Override
	public ArrayList<Course> getCoursesFromA(String sid) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Course> getCoursesFromB(String pId) throws RemoteException {
		ArrayList<Course> result = new ArrayList<Course>();
		ArrayList<Course> all = courceService.getAllCourse();
		for (int i = 0; i < all.size(); i++) {
			Course course = all.get(i);
			boolean has = dwchoice.hasSelect(pId, course.getId());
			if (!has) {
				result.add(course);
			}
		}
		return result;
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Course> getCoursesFromC(String pId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean[] chooseCourses(String pId, ArrayList<String> pCourseId)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean[] dropCourses(String pStudentId, ArrayList<String> pCourseId)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Course> getCoursesToDrop(String pStudentId)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
