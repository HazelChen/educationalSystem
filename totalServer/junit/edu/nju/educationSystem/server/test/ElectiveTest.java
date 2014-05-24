package edu.nju.educationSystem.server.test;

import java.util.ArrayList;

import org.junit.Test;

import edu.nju.educationSystem.server.model.Course;
import edu.nju.educationSystem.server.model.Elective;
import edu.nju.educationSystem.server.model.Major;
import edu.nju.educationSystem.server.service.ElectiveService;

public class ElectiveTest {
	
	public void testAdd() {
		Elective elective1 = new Elective("00000000", "0000000", 95);
		Elective elective2 = new Elective("00000000", "0000001", 80);
		Elective elective3 = new Elective("00000001", "0000000", 60);
		Elective elective4 = new Elective("00000001", "0000001", 69);
		
		ArrayList<Elective> electives = new ArrayList<>();
		electives.add(elective1);
		electives.add(elective2);
		electives.add(elective3);
		electives.add(elective4);
		
		ElectiveService electiveService = new ElectiveService();
		electiveService.addElectives(electives);
	}

	public void testGetStudentCourse() {
		ElectiveService electiveService = new ElectiveService();
		ArrayList<Course> electives = electiveService.getStudentsCourse("00000000");
		for (Course course : electives) {
			System.out.println(course.getId());
		}
	}
	
	@Test
	public void testGetAllElective() {
		ElectiveService electiveService = new ElectiveService();
		ArrayList<Elective> electives = electiveService.getAllElective(Major.A);
		for (Elective elective : electives) {
			System.out.println(elective.getCourseId());
		}
	}
	
	
}
