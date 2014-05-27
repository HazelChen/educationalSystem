package emsystemimp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import emsystem.data.Choice;
import emsystem.data.Course;
import emsystem.data.Student;
import emsystem.database.Account_logic;
import emsystem.database.Choice_logic;
import emsystem.database.Course_logic;
import emsystem.database.Student_logic;
import emsystem.rao.RAOFacade;
import emsystem.rmi.AdminService;

public class AdminServiceImp extends UnicastRemoteObject implements
		AdminService {
	private RAOFacade raoFacade;
	
	public AdminServiceImp() throws RemoteException {
		super();
		raoFacade = new RAOFacade();
	}

	@Override
	public boolean adminLogin(String pAccount, String pPassword)
			throws RemoteException {
		boolean isLogin = false;
		Account_logic al = new Account_logic();
		isLogin = al.isLogin(pAccount, pPassword);
		return isLogin;
	}

	@Override
	public ArrayList<Student> getStudents() throws RemoteException {
		Student_logic sl = new Student_logic();
		return sl.listStudent();
	}

	@Override
	public boolean addStudent(Student pStudent) throws RemoteException {
		boolean isadd = false;
		Student_logic sl = new Student_logic();
		isadd = sl.addStudent(pStudent);
		return isadd;
	}

	@Override
	public boolean modifyStudent(Student pStudent) throws RemoteException {
		boolean ismodify;
		Student_logic sl = new Student_logic();
		ismodify = sl.updateStudent(pStudent);
		return ismodify;
	}

	@Override
	public boolean deleteStudent(String pStudentId) throws RemoteException {
		boolean isdelete = false;
		Student_logic sl = new Student_logic();
		isdelete = sl.deleteAStudent(pStudentId);
		return isdelete;
	}

	@Override
	public String getMajorName() throws RemoteException {
		return "Èí¼þ¹¤³Ì";
	}

	@Override
	public ArrayList<Course> getCourses() throws RemoteException {
		Course_logic cl = new Course_logic();
		return cl.listCourse();
	}

	@Override
	public boolean addCourse(Course course) throws RemoteException {
		Course_logic cl = new Course_logic();
		return cl.addCourse(course);
	}

	@Override
	public boolean modifyCourse(Course course) throws RemoteException {
		Course_logic cl = new Course_logic();
		return cl.updateCourse(course);
	}

	@Override
	public boolean deleteCourse(String pCourseId) throws RemoteException {
		Course_logic cl = new Course_logic();
		return cl.deleteACourse(pCourseId);
	}

	@Override
	public ArrayList<Student> getChoosedStudents(String pCourseId)
			throws RemoteException {
		Course_logic cl = new Course_logic();
		return cl.getStudentByCno(pCourseId);
	}

	@Override
	public ArrayList<Course> getUnsharedCourses() throws RemoteException {
		Course_logic cl = new Course_logic();
		return cl.getUnsharedCourse();
	}

	@Override
	public void postFinishChooseAction() throws RemoteException {
		ArrayList<Choice> allChoicesFromTotalServer = raoFacade.getServerChoises();
		Choice_logic logic = new Choice_logic();
		for(Choice choice : allChoicesFromTotalServer) {
			logic.addChoice(choice);
		}
	}

	@Override
	public void postShareStudentAction() throws RemoteException {
		Student_logic logic = new Student_logic();
		ArrayList<Student> students = logic.getAllStudent();
		raoFacade.addStudents(students);
	}

	@Override
	public void postShareCourseAction(ArrayList<String> pCourseIds)
			throws RemoteException {
		Course_logic logic = new Course_logic();
		
		ArrayList<Course> courses = new ArrayList<>();
		for(String cid : pCourseIds) {
			Course course = logic.queryCourseByCno(cid);
			courses.add(course);
		}
		raoFacade.addCourses(courses);
	}

}
