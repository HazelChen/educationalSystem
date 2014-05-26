package emsystem.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Student implements Serializable, ModelSpecification{
	private static final long serialVersionUID = -511579054499558338L;
	
	private String id;
	private String name;
	private String sex;
	private String major;
	private String accountId;
	
	public Student(){}
	
	public Student(String id, String name, String sex, String major, String accountId) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.major = major;
		this.accountId = accountId;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Override
	public Map<String, String> getFieldCorrespondence() {
		Map<String, String> maps = new LinkedHashMap<>();
		maps.put("id", "学号");
		maps.put("name", "姓名");
		maps.put("sex", "性别");
		maps.put("major", "院系");
		maps.put("accountId", "关联账户");
		return maps;
	}
}
