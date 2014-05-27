package edu.nju.educationSystem.server.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Elective implements ModelSpecification{
	
	private String studentId = "";
	private String courseId = "";
	private int score;
	
	public Elective() {}
	
	public Elective(String sid, String cid, int score) {
		this.studentId = sid;
		this.courseId = cid;
		this.score = score;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public Map<String, String> getFieldCorrespondence() {
		Map<String, String> maps = new LinkedHashMap<>();
		maps.put("studentId", "sid");
		maps.put("courseId", "cid");
		maps.put("score", "score");
		return maps;
	}
	
}
