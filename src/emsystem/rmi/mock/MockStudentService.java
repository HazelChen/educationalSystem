package emsystem.rmi.mock;

import java.util.ArrayList;
import java.util.HashMap;

import emsystem.data.Course;
import emsystem.data.Student;
import emsystem.rmi.StudentService;

public class MockStudentService implements StudentService{
	
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
		if (pId != "001") {
			return null;
		}
		Student student = new Student("001", "哈哈", "女", "专业A","123");
		return student;
	}
	
	@Override
	public HashMap<Course, Integer> getMyCourses(String pId){
		if ( pId == null) {
			return null;
		}
		Course course1 = new Course("001", "math", 3, "5-6", "mike", "china","是");
		Course course2 = new Course("002", "art", 2, "1-2", "Tom", "China","否");
		
		HashMap<Course, Integer> courses = new HashMap<Course, Integer>();
		courses.put(course1, new Integer(90));
		courses.put(course2, new Integer(100));
		return courses;
	}
	
//	@Override
//	public int[] getScores(String pId){
//		int[] scores = new int[]{90, 100};
//		return scores;
//	}

	/**
	 * 显示课程为未选课程。
	 * @return
	 */
	@Override
	public ArrayList<Course> getCoursesFromA(String pId){
		ArrayList<Course> courses = new ArrayList<Course>();
		Course course1 = new Course("001", "math", 3, "5-6", "mike", "china","是");
		Course course2 = new Course("002", "art", 2, "1-2", "Tom", "China","否");
		
		courses.add(course1);
		courses.add(course2);
		return courses;
	}
	
	@Override
	public ArrayList<Course> getCoursesFromB(String pId){
		ArrayList<Course> courses = new ArrayList<Course>();
		Course course1 = new Course("003", "math", 3, "5-6", "mike", "china","是");
		Course course2 = new Course("004", "art", 2, "1-2", "Tom", "China","否");
		
		courses.add(course1);
		courses.add(course2);
		return courses;
	}
	
	@Override
	public ArrayList<Course> getCoursesFromC(String pId){
		ArrayList<Course> courses = new ArrayList<Course>();
		Course course1 = new Course("005", "math", 3, "5-6", "mike", "china","是");
		Course course2 = new Course("006", "art", 2, "1-2", "Tom", "China","否");
		
		courses.add(course1);
		courses.add(course2);
		return courses;
	}
	
	
	@Override
	public boolean[] chooseCourses(String pId, ArrayList<String> pCourseId){
		boolean[] results = new boolean[]{true,  false};
		return results;
	}
	
	@Override
	public boolean[] dropCourses(String pStudentId, ArrayList<String> pCourseId){
		boolean[] results = new boolean[]{true, false};
		return results;
		
	}
	
	@Override
	public ArrayList<Course> getCoursesToDrop(String pStudentId){
		ArrayList<Course> courses = new ArrayList<Course>();
		Course course1 = new Course("005", "math", 3, "5-6", "mike", "china","是");
		Course course2 = new Course("006", "art", 2, "1-2", "Tom", "China","否");
		
		courses.add(course1);
		courses.add(course2);
		return courses;
		
	}
}
