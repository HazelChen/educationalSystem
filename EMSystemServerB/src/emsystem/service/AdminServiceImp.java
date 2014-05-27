package emsystem.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import emsystem.model.Account;
import emsystem.model.Course;
import emsystem.model.Student;
import emsystem.rmi.AdminService;

public class AdminServiceImp extends UnicastRemoteObject implements AdminService{
	private static final long serialVersionUID = 5595924612995374408L;
	
	private AccountService accountService;
	private StudentService studentService;
	private CourseService courseService;
	private ChoiceService choiceService;
	
	public AdminServiceImp() throws RemoteException {
		super();
		accountService = new AccountService();
		studentService = new StudentService();
		courseService = new CourseService();
		choiceService = new ChoiceService();
	}

	@Override
	public boolean adminLogin(String pAccount, String pPassword)
			throws RemoteException {
		return accountService.login(pAccount, pPassword);
	}

	@Override
	public ArrayList<Student> getStudents() throws RemoteException {
		return studentService.getStudents();
	}

	@Override
	public boolean addStudent(Student pStudent) throws RemoteException {
		Account account = new Account(pStudent.getId(), "1", 0);
		boolean result = accountService.add(account);
		studentService.add(pStudent);
		return result;
	}

	@Override
	public boolean modifyStudent(Student pStudent) throws RemoteException {
		return studentService.update(pStudent);
	}

	@Override
	public boolean deleteStudent(String pStudentId) throws RemoteException {
		return studentService.remove(pStudentId);
	}

	@Override
	public String getMajorName() throws RemoteException {
		return "ŒÔ¿Ì";
	}

	@Override
	public ArrayList<Course> getCourses() throws RemoteException {
		return courseService.getThisMajorCourses();
	}

	@Override
	public boolean addCourse(Course course) throws RemoteException {
		return courseService.add(course);
	}

	@Override
	public boolean modifyCourse(Course course) throws RemoteException {
		return courseService.update(course);
	}

	@Override
	public boolean deleteCourse(String pCourseId) throws RemoteException {
		return courseService.remove(pCourseId);
	}

	@Override
	public ArrayList<Student> getChoosedStudents(String pCourseId)
			throws RemoteException {
		return studentService.getChoosedStudents(pCourseId);
	}

	@Override
	public ArrayList<Course> getUnsharedCourses() throws RemoteException {
		return courseService.getUnsharedCourses();
	}

	@Override
	public void postFinishChooseAction() throws RemoteException {
		choiceService.insertChoisesFromTotalServer(); 
	}

	@Override
	public void postShareStudentAction() throws RemoteException {
		ArrayList<Student> students = studentService.getStudents();
		studentService.shareStudent(students);
	}

	@Override
	public void postShareCourseAction(ArrayList<String> pCourseIds)
			throws RemoteException {
		courseService.shareInDB(pCourseIds);
		ArrayList<Course> courses = courseService.getSharedCourses();
		courseService.shareCoursesToServer(courses);
	}

}
