package emsystemimp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import emsystem.data.Choice;
import emsystem.data.Course;
import emsystem.data.Student;
import emsystem.database.Account_logic;
import emsystem.database.Choice_logic;
import emsystem.database.Course_logic;
import emsystem.database.Student_logic;
import emsystem.rao.RAOFacade;
import emsystem.rmi.StudentService;

public class StudentServiceImp extends UnicastRemoteObject implements
		StudentService {
	private RAOFacade raoFacade;
	
	public StudentServiceImp() throws RemoteException {
		super();
		raoFacade = new RAOFacade();
	}

	/**
	 * 
	 * 登录服务
	 */
	// tested
	public boolean studentLogin(String pId, String pPassword) {
		boolean isLogin = false;
		Account_logic al = new Account_logic();
		isLogin = al.isLogin(pId, pPassword);
		return isLogin;
	}

	/**
	 * 学生
	 */
	public Student getStudentInfo(String pId) {
		Student_logic sl = new Student_logic();
		Student s = sl.queryStudentBySno(pId);
		return s;
	}

	public HashMap<Course, Integer> getMyCourses(String pStudentId) {
		HashMap<Course, Integer> hashmap = new HashMap<Course, Integer>();
		Course course;
		Course_logic coursel = new Course_logic();
		Choice_logic cl = new Choice_logic();
		ArrayList<Choice> courselist = cl.getChoiceBySno(pStudentId);
		
		ArrayList<Choice> myOtherMajorChoices = raoFacade.getStudentChoice(pStudentId);
		courselist.addAll(myOtherMajorChoices);

		for (Choice choice : courselist) {
			String cid = choice.getCourseId();
			if (cid.startsWith("3")) {
				course = coursel.queryCourseByCno(cid);
			} else {
				course = raoFacade.findCourse(cid);
			}
			int mark = choice.getScore();
			hashmap.put(course, mark);
		}
		return hashmap;

	}

	/**
	 * 显示课程为未选课程。
	 * 
	 * @return
	 */

	public ArrayList<Course> getCoursesFromC(String pId) {
		Choice_logic c = new Choice_logic();
		Course_logic l = new Course_logic();

		// 存储返回的courselist
		ArrayList<Course> result = new ArrayList<Course>();
		// 根据学生id来获取他的选择的课程
		ArrayList<Choice> list = c.getChoiceBySno(pId);
		// 获取学生选择的课程
		ArrayList<Course> listA = new ArrayList<Course>();
		for (int i = 0; i < list.size(); i++) {
			Course course = l.queryCourseByCno(list.get(i).getCourseId());
			listA.add(course);
		}
		

		ArrayList<Course> listB = l.listCourse();// 在该listb中而不在上面的lista中的course
		for (int i = 0; i < listB.size(); i++) {
			boolean isin = false;
			for (int n = 0; n < listA.size(); n++) {
				if ((listB.get(i).getId()).equals((listA.get(n).getId()))) {
					isin = true;
				}
			}
			if (!isin) {
				result.add(listB.get(i));
			}
		}
		return result;

	}

	public boolean[] chooseCourses(String pId, ArrayList<String> pCourseId) {
		boolean[] b = new boolean[pCourseId.size()];
		Course_logic cl = new Course_logic();
		Choice_logic lc = new Choice_logic();
		for (int i = 0; i < pCourseId.size(); i++) {
			if (cl.isCCourse(pCourseId.get(i))) {
				lc.addChoice(pCourseId.get(i), pId);
				b[i] = true;
			} else {
				Choice choice = new Choice(pId, pCourseId.get(i), 0);
				b[i] = raoFacade.add(choice);
			}
		}
		return b;
	}

	@Override
	public ArrayList<Course> getCoursesFromA(String pId) throws RemoteException {
		ArrayList<Course> courses = raoFacade.getNotSelectedCoursesInA(pId);
		return courses;
	}

	@Override
	public ArrayList<Course> getCoursesFromB(String pId) throws RemoteException {
		ArrayList<Course> courses = raoFacade.getNotSelectedCoursesInB(pId);
		return courses;
	}

	@Override
	public boolean[] dropCourses(String pStudentId, ArrayList<String> pCourseId) {

		Choice_logic cl = new Choice_logic();
		boolean[] result = new boolean[pCourseId.size()];
		for (int i = 0; i < pCourseId.size(); i++) {
			String cid = pCourseId.get(i);
			if (cid.startsWith("3")) {
				// 退选C系统的课
				boolean b = cl.deleteChoice(cid, pStudentId);
				result[i] = b;
			} else {
				Choice choice = new Choice(pStudentId, cid, 0);
				result[i] = raoFacade.remove(choice);
			}
		}
		return result;
	}

	@Override
	public ArrayList<Course> getCoursesToDrop(String pStudentId) {
		Choice_logic cl = new Choice_logic();
		Course_logic c = new Course_logic();
		ArrayList<Choice> list = new ArrayList<Choice>();
		ArrayList<Course> result = new ArrayList<Course>();
		list = cl.getChoiceBySno(pStudentId);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getScore() == 0) {
				Course course = c.queryCourseByCno(list.get(i).getCourseId());
				result.add(course);
			} else {
				Course course = raoFacade.findCourse(list.get(i).getCourseId());
				result.add(course);
			}
		}
		return result;
	}

}
