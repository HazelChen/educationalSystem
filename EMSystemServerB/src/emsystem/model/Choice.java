package emsystem.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Choice implements Serializable, ModelSpecification{
	private static final long serialVersionUID = -6541266622375689831L;
	
	private String courseId;
	private String studentId;
	private int score;
	
	public Choice(){}
	
	public Choice(String courseId, String studentId, int score){
		this.studentId = studentId;
		this.courseId = courseId;
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
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("courseId", "课程编号");
		maps.put("studentId", "学生编号");
		maps.put("score", "成绩");
		return maps;
	}

}
