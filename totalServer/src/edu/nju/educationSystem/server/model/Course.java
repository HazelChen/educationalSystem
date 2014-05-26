package edu.nju.educationSystem.server.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Course implements ModelSpecification {
	private String id = "";
	private String name = "";
	/**
	 * ��ʱ
	 */
	private int time;
	/**
	 * ѧ��
	 */
	private int score;
	private String teacher = "";
	private String location = "";

	public Course() {
	}

	public Course(String id, String name, int time, int score, String teacher,
			String location) {
		this.id = id;
		this.name = name;
		this.time = time;
		this.score = score;
		this.teacher = teacher;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public Map<String, String> getFieldCorrespondence() {
		Map<String, String> maps = new LinkedHashMap<>();
		maps.put("id", "id");
		maps.put("name", "name");
		maps.put("time", "time");
		maps.put("score", "score");
		maps.put("teacher", "teacher");
		maps.put("location", "location");
		return maps;
	}

}
