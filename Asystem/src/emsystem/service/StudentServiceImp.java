package emsystem.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import emsystem.data.Account;
import emsystem.data.Choice;
import emsystem.data.Course;
import emsystem.data.Student;
import emsystem.database.DealWithAccount;
import emsystem.database.DealWithChoice;
import emsystem.database.DealWithCourse;
import emsystem.database.DealWithStudent;
import emsystem.rao.RAOFacade;
import emsystem.rmi.StudentService;

@SuppressWarnings("serial")
public class StudentServiceImp extends UnicastRemoteObject implements
		StudentService {
	// 具体实现
	DealWithStudent dwstudent = new DealWithStudent();
	DealWithChoice dwchoice = new DealWithChoice();
	DealWithCourse dwcourse = new DealWithCourse();
	DealWithAccount dwaccount = new DealWithAccount();
	
	RAOFacade raoFacade = new RAOFacade();

	public StudentServiceImp() throws RemoteException {
		super();
	}

	@Override
	public boolean studentLogin(String pId, String pPassword) {
		Account account = dwaccount.search(pId);
		boolean b = false;
		if (account != null) {
			if (account.getPassword().equals(pPassword)) {
				b = true;
			}
		}
		return b;
	}

	@Override
	public Student getStudentInfo(String pId) {
		return dwstudent.search(pId);
	}

	@Override
	public HashMap<Course, Integer> getMyCourses(String pStudentId) {
		HashMap<Course, Integer> map = new HashMap<Course, Integer>();
		ArrayList<Choice> list = dwchoice.getMyChoice(pStudentId);
		ArrayList<Choice> myOtherMajorChoices = raoFacade.getStudentChoice(pStudentId);
		list.addAll(myOtherMajorChoices);
		
		for (int i = 0; i < list.size(); i++) {
			Choice choice = list.get(i);
			Course c = null;
			if (choice.getCourseId().startsWith("1")) {
				c = dwcourse.search(choice.getCourseId());
			} else {
				// 外院课程
				c = raoFacade.findCourse(choice.getCourseId());
			}
			map.put(c, choice.getScore());

		}
		return map;
	}

	@Override
	public ArrayList<Course> getCoursesFromA(String pId) {
		ArrayList<Course> result = new ArrayList<Course>();
		ArrayList<Course> all = dwcourse.getAllCourse();
		for (int i = 0; i < all.size(); i++) {
			Course course = all.get(i);
			boolean has = dwchoice.hasSelect(pId, course.getId());
			if (!has) {
				result.add(course);
			}
		}
		return result;
	}

	@Override
	public ArrayList<Course> getCoursesFromB(String pId) {
		return raoFacade.getNotSelectedCoursesInB(pId);
	}

	@Override
	public ArrayList<Course> getCoursesFromC(String pId) {
		return raoFacade.getNotSelectedCoursesInB(pId);
	}

	@Override
	public boolean[] chooseCourses(String pId, ArrayList<String> pCourseIdlist) {
		boolean[] result = new boolean[pCourseIdlist.size()];
		for (int i = 0; i < pCourseIdlist.size(); i++) {
			String cid = pCourseIdlist.get(i);
			if (cid.startsWith("1")) {
				// 选A系统的课
				Choice choice = new Choice(pId, cid, 0);
				boolean b = dwchoice.insert(choice);
				result[i] = b;
			} else {
				// 选择外院的课
				Choice choice = new Choice(pId, cid, 0);
				result[i] = raoFacade.add(choice);
			}
		}
		return result;
	}

	@Override
	public boolean[] dropCourses(String pStudentId,
			ArrayList<String> pCourseIdlist) {
		boolean[] result = new boolean[pCourseIdlist.size()];
		for (int i = 0; i < pCourseIdlist.size(); i++) {
			String cid = pCourseIdlist.get(i);
			if (cid.startsWith("1")) {
				// 退选A系统的课
				boolean b = dwchoice.delete(cid, pStudentId);
				result[i] = b;
			} else {
				// 退选外院的课
				Choice choice = new Choice(pStudentId, cid, 0);
				result[i] = raoFacade.remove(choice);
			}
		}
		return result;
	}

	@Override
	public ArrayList<Course> getCoursesToDrop(String pStudentId) {
		ArrayList<Choice> list = dwchoice.getMyChoice(pStudentId);
		ArrayList<Course> result = new ArrayList<Course>();
		for (int i = 0; i < list.size(); i++) {
			String cid = list.get(i).getCourseId();
			Course c = null;
			if (list.get(i).getScore() == 0) {
				if (cid.startsWith("1")) {
					c = dwcourse.search(cid);
				} else {
					// 外院的课程
					c = raoFacade.findCourse(cid);
				}
				result.add(c);
			}
		}
		return result;
	}
}
