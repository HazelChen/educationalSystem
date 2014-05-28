package emsystem.data;

import java.io.Serializable;
import java.util.HashMap;
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
	
	public Choice() {}
	
	public Choice(String courseId, String studentId, int score){
		this.courseId = courseId;
		this.studentId = studentId;
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
		Map<String,String> map=new LinkedHashMap<String, String>();
		map.put("courseId","Cno");
		map.put("studentId", "Sno");
		map.put("score", "Grd");
		return map;
	}

}
