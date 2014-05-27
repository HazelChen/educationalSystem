package emsystem.data;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Choice implements Serializable,ModelSpecification{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String studentId;
	private String courseId;
	private int score;
	
	public Choice(){}
	
	public Choice(String courseId,String studentId, int score){
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
		Map<String,String> map=new LinkedHashMap<>();
		map.put("studentId","学号");
		map.put("courseId", "课程编号");
		map.put("score", "得分");
		return map;
	}

}
