package emsystem.rmi.mock;

import emsystem.data.Course;
import emsystem.data.Student;
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
	public Student[] getStudents() {
		Student student1 = new Student("001", "����", "Ů", getMajorName(),
				"12334");
		Student student2 = new Student("002", "�Ǻ�", "��", getMajorName(), "11");

		Student[] students = new Student[] { student1, student2 };
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
	public Course[] getCourses() {
		Course course1 = new Course("001", "math", 3, "5-6", "mike", "china", "��");
		Course course2 = new Course("002", "art", 2, "1-2", "Tom", "China", "��");

		Course[] courses = new Course[] { course1, course2 };
		return courses;
	}

	@Override
	public String getMajorName() {
		return "רҵA";
	}

}
