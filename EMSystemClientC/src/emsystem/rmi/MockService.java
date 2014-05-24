package emsystem.rmi;

import java.util.ArrayList;

import data.Course;
import data.Student;
import emsystem.logic.MajorType;

public class MockService implements StudentService{
	
	@Override
	public boolean adminLogin(String pAccount, String pPassword){
		if (pAccount.equals("admin") && pPassword.equals("admin")) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean studentLogin(String pId, String pPassword){
		if (pId.equals("001") && pPassword.equals("123")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 学生
	 */
	@Override
	public Student getStudentInfo(String pId){
		Student student = new Student("001", "哈哈", "女", MajorType.DEPARTMENT_A,"");
		return student;
	}
	
	@Override
	public Course[] getMyCourses(String pId){
		Course course1 = new Course("003", "math", 3, 2, "mike", "china","");
		Course course2 = new Course("004", "art", 2, 2, "Tom", "China","");
		
		Course[] courses = new Course[]{course1, course2};
		return courses;
	}

	/**
	 * 显示课程为未选课程。
	 * @return
	 */
	@Override
	public Course[] getCoursesFromA(String pId){
		Course course1 = new Course("003", "math", 3, 2, "mike", "china","");
		Course course2 = new Course("004", "art", 2, 2, "Tom", "China","");
		
		Course[] courses = new Course[]{course1, course2};
		return courses;
	}
	
	@Override
	public Course[] getCoursesFromB(String pId){
		Course course1 = new Course("003", "math", 3, 2, "mike", "china","");
		Course course2 = new Course("004", "art", 2, 2, "Tom", "China","");
		Course[] courses = new Course[]{course1, course2};
		return courses;
	}
	
	@Override
	public Course[] getCoursesFromC(String pId){
		Course course1 = new Course("003", "math", 3, 2, "mike", "china","");
		Course course2 = new Course("004", "art", 2, 2, "Tom", "China","");
		
		Course[] courses = new Course[]{course1, course2};
		return courses;
	}
	
	
	@Override
	public boolean[] chooseCourses(String pId, ArrayList<String> pCourseId){
		boolean[] results = new boolean[]{true,  false};
		return results;
	}
}
