package edu.nju.educationSystem.server.test;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.junit.Test;

import edu.nju.educationSystem.server.dao.CourseDAO;
import edu.nju.educationSystem.server.model.Course;
import edu.nju.educationSystem.server.service.CourseService;
import edu.nju.educationSystem.server.xmlHandler.XMLGenerater;

public class CourseTest {
	
	public void addCourse() {
		ArrayList<Course> courses = new ArrayList<>();
		Course course1 = new Course("0000000", "���ѧ", 37, 3, "����", "��һ");
		Course course2 = new Course("0000001", "����ѧ", 40, 5, "��־��", "�ɶ�");
		courses.add(course1);
		courses.add(course2);
		
		CourseService courseService = new CourseService();
		courseService.addCourses(courses);
	}
	
	public void testGenerateXml() {
		CourseDAO dao = new CourseDAO();
		ResultSet resultSet = dao.getAllCourseResultSet();
		
		XMLGenerater xmlGenerater = new XMLGenerater("courses", "course");
		xmlGenerater.generateDocument(resultSet);
		System.out.println(xmlGenerater.getXmlString());
	}
	
	@Test
	public void testGenerateXml2() {
		Course course1 = new Course("0000000", "���ѧ", 37, 3, "����", "��һ");
		Course course2 = new Course("0000001", "����ѧ", 40, 5, "��־��", "�ɶ�");
		
		XMLGenerater xmlGenerater = new XMLGenerater("courses", "course");
		xmlGenerater.generateDocumentBaseInfo(Course.class);
		xmlGenerater.addElement(course1);
		xmlGenerater.addElement(course2);
		System.out.println(xmlGenerater.getXmlString());
	}
}
