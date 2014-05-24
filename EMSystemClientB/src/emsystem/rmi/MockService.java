package emsystem.rmi;

import java.util.ArrayList;

import emsystem.data.Course;
import emsystem.data.Student;

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
	 * ѧ��
	 */
	@Override
	public Student getStudentInfo(String pId){
		Student student = new Student("001", "����", "Ů", "רҵA");
		return student;
	}
	
	@Override
	public Course[] getMyCourses(String pId){
		Course course1 = new Course("001", "math", 3, "5-6", "mike", "china",1);
		Course course2 = new Course("002", "art", 2, "1-2", "Tom", "China",1);
		
		Course[] courses = new Course[]{course1, course2};
		return courses;
	}
	
	@Override
	public int[] getScores(String pId){
		int[] scores = new int[]{90, 100};
		return scores;
	}

	/**
	 * ��ʾ�γ�Ϊδѡ�γ̡�
	 * @return
	 */
	@Override
	public Course[] getCoursesFromA(String pId){
		Course course1 = new Course("003", "math", 3, "5-6", "mike", "china",1);
		Course course2 = new Course("004", "art", 2, "1-2", "Tom", "China",1);
		
		Course[] courses = new Course[]{course1, course2};
		return courses;
	}
	
	@Override
	public Course[] getCoursesFromB(String pId){
		Course course1 = new Course("005", "math", 3, "5-6", "mike", "china",1);
		Course course2 = new Course("006", "art", 2, "1-2", "Tom", "China",1);
		
		Course[] courses = new Course[]{course1, course2};
		return courses;
	}
	
	@Override
	public Course[] getCoursesFromC(String pId){
		Course course1 = new Course("007", "math", 3, "5-6", "mike", "china",1);
		Course course2 = new Course("008", "art", 2, "1-2", "Tom", "China",1);
		
		Course[] courses = new Course[]{course1, course2};
		return courses;
	}
	
	
	@Override
	public boolean[] chooseCourses(String pId, ArrayList<String> pCourseId){
		boolean[] results = new boolean[]{true,  false};
		return results;
	}
}
