package edu.nju.educationSystem.server.test;

import java.util.ArrayList;

import org.junit.Test;

import edu.nju.educationSystem.server.model.Course;
import edu.nju.educationSystem.server.model.Elective;
import edu.nju.educationSystem.server.model.Major;
import edu.nju.educationSystem.server.service.ElectiveService;
import edu.nju.educationSystem.server.xmlHandler.XMLTransform;

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
	
	public void testGetAllElective() {
		ElectiveService electiveService = new ElectiveService();
		ArrayList<Elective> electives = electiveService.getAllElective(Major.广告学);
		for (Elective elective : electives) {
			System.out.println(elective.getCourseId());
		}
	}
	
	public void testGenerateXML() {
		ArrayList<Elective> electives = new ArrayList<>();
		Elective elective = new Elective("cid","sid", 0);
		electives.add(elective);
		ElectiveService electiveService = new ElectiveService();
		System.out.println(electiveService.getElectivesXml(electives));
	}
	
	@Test
	public void testChange() {
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><choices>  <choice>    <学号>100250001</学号>    <课程编号>20140201</课程编号>    <得分>0</得分>  </choice></choices>";
		XMLTransform transform = new XMLTransform();
		transform.transform(xml, "choiceToT");
	}
	
	
}
