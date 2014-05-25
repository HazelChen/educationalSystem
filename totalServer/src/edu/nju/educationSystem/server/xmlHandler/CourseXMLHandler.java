package edu.nju.educationSystem.server.xmlHandler;

import java.sql.ResultSet;

import edu.nju.educationSystem.server.dao.CourseDAO;

public class CourseXMLHandler {
	private CourseDAO courseDAO;
	
	public CourseXMLHandler() {
		courseDAO = new CourseDAO();
	}
	
	public String listToXml() {
		XMLGenerater xmlGenerater = new XMLGenerater(ConfigConstant.COURSE_ROOT, ConfigConstant.COURSE_ELEMENT);
		
		ResultSet resultSet = courseDAO.getAllCourseResultSet();
		xmlGenerater.generateDocument(resultSet);
		
		String xml = xmlGenerater.getXmlString();
		return xml;
	}
}
