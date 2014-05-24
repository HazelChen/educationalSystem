package edu.nju.educationSystem.server.test;

import java.util.ArrayList;

import org.junit.Test;

import edu.nju.educationSystem.server.model.Course;
import edu.nju.educationSystem.server.service.CourseService;

public class CourseTest {
	@Test
	public void addCourse() {
		ArrayList<Course> courses = new ArrayList<>();
		Course course1 = new Course("0000000", "���ѧ", 37, 3, "����", "��һ");
		Course course2 = new Course("0000001", "����ѧ", 40, 5, "��־��", "�ɶ�");
		courses.add(course1);
		courses.add(course2);
		
		CourseService courseService = new CourseService();
		courseService.addCourses(courses);
	}

}
