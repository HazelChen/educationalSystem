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
		Student student1 = new Student("001", "����", "Ů", getMajorName(),
				"12334");
		Student student2 = new Student("002", "�Ǻ�", "��", getMajorName(), "11");

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
				"��");
		Course course2 = new Course("002", "art", 2, "1-2", "Tom", "China", "��");

		courses.add(course1);
		courses.add(course2);
		return courses;
	}

	@Override
	public String getMajorName() {

		return "רҵA";
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
			Student student1 = new Student("001", "����", "Ů", getMajorName(),
					"12334");
			Student student2 = new Student("002", "�Ǻ�", "��", getMajorName(), "11");
			
			students.add(student1);
			students.add(student2);
		}
		else {
			Student student1 = new Student("003", "����", "Ů", getMajorName(),
					"12334");
			Student student2 = new Student("004", "�Ǻ�", "��", getMajorName(), "11");
			
			students.add(student1);
			students.add(student2);
		}

		return students;
	}
	
	
	@Override
	public ArrayList<Course> getUnsharedCourses(){
		ArrayList<Course> courses = new ArrayList<>();
		Course course1 = new Course("001", "math", 3, "5-6", "mike", "china",
				"��");
		Course course2 = new Course("002", "art", 2, "1-2", "Tom", "China", "��");

		courses.add(course1);
		courses.add(course2);
		return courses;
	}
	
	/**
	 * ���ܷ������ύ������רҵѡ������
	 */
	@Override
	public void postFinishChooseAction(){
		
	}
	
	/**
	 * �ύ����ѧ����Ϣ����
	 * @throws RemoteException
	 */
	@Override
	public void postShareStudentAction(){
		
	}
	
	/**
	 * �ύ����γ���Ϣ����
	 * @throws RemoteException
	 */
	
	@Override
	public void postShareCourseAction(ArrayList<String> pCourseIds) {
		
	}
	
}
