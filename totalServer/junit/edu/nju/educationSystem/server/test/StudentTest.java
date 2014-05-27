package edu.nju.educationSystem.server.test;

import java.util.ArrayList;

import org.junit.Test;

import edu.nju.educationSystem.server.model.Major;
import edu.nju.educationSystem.server.model.Sex;
import edu.nju.educationSystem.server.model.Student;
import edu.nju.educationSystem.server.service.StudentService;

public class StudentTest {
	
	@Test
	public void testAdd() {
		ArrayList<Student> students = new ArrayList<>();
		
		Student student1 = new Student("00000000", "陈霖", Sex.FEMALE, Major.广告学);
		Student student2 = new Student("00000001", "啊啊", Sex.MALE, Major.物理);
		students.add(student1);
		students.add(student2);
		
		StudentService service  = new StudentService();
		service.addStudents(students);
	}
}
