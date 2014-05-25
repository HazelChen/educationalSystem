package emsystem.rmi.mock;

import java.rmi.RemoteException;
import java.util.ArrayList;

import emsystem.model.Course;
import emsystem.model.Student;
import emsystem.rmi.AdminService;

public class MockAdminService implements AdminService {
	@Override
	public boolean adminLogin(String pAccount, String pPassword) {
		if (pAccount.equals("admin") && pPassword.equals("admin")) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Student> getStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		Student student1 = new Student("001", "哈哈", "女", getMajorName(),
				"12334");
		Student student2 = new Student("002", "呵呵", "男", getMajorName(), "11");

		students.add(student1);
		students.add(student2);
		return students;
	}

	@Override
	public boolean addStudent(Student pStudent) {
		return true;
	}

	@Override
	public boolean modifyStudent(Student pStudent) {
		return true;
	}

	@Override
	public boolean deleteStudent(String pStudentId) {
		return true;
	}

	@Override
	public ArrayList<Course> getCourses() {
		ArrayList<Course> courses = new ArrayList<>();
		Course course1 = new Course("001", "math", 3, "5-6", "mike", "china",
				"是");
		Course course2 = new Course("002", "art", 2, "1-2", "Tom", "China", "否");

		courses.add(course1);
		courses.add(course2);
		return courses;
	}

	@Override
	public String getMajorName() {

		return "专业A";
	}

	@Override
	public boolean addCourse(Course course) {
		return true;
	}

	@Override
	public boolean modifyCourse(Course course) {
		return true;
	}

	@Override
	public boolean deleteCourse(String pCourseId) {
		return true;
	}

	@Override
	public ArrayList<Student> getChoosedStudents(String pCourseId){
		ArrayList<Student> students = new ArrayList<Student>();
		if (pCourseId.equals("001")) {
			Student student1 = new Student("001", "哈哈", "女", getMajorName(),
					"12334");
			Student student2 = new Student("002", "呵呵", "男", getMajorName(), "11");
			
			students.add(student1);
			students.add(student2);
		}
		else {
			Student student1 = new Student("003", "哈哈", "女", getMajorName(),
					"12334");
			Student student2 = new Student("004", "呵呵", "男", getMajorName(), "11");
			
			students.add(student1);
			students.add(student2);
		}

		return students;
	}
	
	
	@Override
	public ArrayList<Course> getUnsharedCourses(){
		ArrayList<Course> courses = new ArrayList<>();
		Course course1 = new Course("001", "math", 3, "5-6", "mike", "china",
				"否");
		Course course2 = new Course("002", "art", 2, "1-2", "Tom", "China", "否");

		courses.add(course1);
		courses.add(course2);
		return courses;
	}
	
	/**
	 * 向总服务器提交结束跨专业选课请求
	 */
	@Override
	public void postFinishChooseAction(){
		
	}
	
	/**
	 * 提交共享学生信息请求
	 * @throws RemoteException
	 */
	@Override
	public void postShareStudentAction(){
		
	}
	
	/**
	 * 提交共享课程信息请求
	 * @throws RemoteException
	 */
	
	@Override
	public void postShareCourseAction(ArrayList<String> pCourseIds) {
		
	}
	
}
