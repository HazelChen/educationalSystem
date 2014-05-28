package edu.nju.educationSystem.server.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student implements ModelSpecification{
	private String id;
	private String name;
	private Sex sex;
	private Major major;
	
	public Student() {}
	
	public Student(String id, String name, Sex sex, Major major) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.major = major;
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
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}

	@Override
	public Map<String, String> getFieldCorrespondence() {
		Map<String, String> maps = new LinkedHashMap<>();
		maps.put("id", "id");
		maps.put("name", "name");
		maps.put("sex", "sex");
		maps.put("major", "major");
		return maps;
	}
	
	
}
