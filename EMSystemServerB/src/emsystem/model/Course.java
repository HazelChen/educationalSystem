package emsystem.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Course implements Serializable, ModelSpecification{
	private static final long serialVersionUID = -437165309238419702L;
	
	private String id;
	private String name;
	private int credit;
	private String teacher;
	private String address;
	private String shareFlag;
	
	public Course(){}
	
	public Course(String id, String name, int credit, String teacher, String address, String shareFlag) {
		this.id = id;
		this.name = name;
		this.credit = credit;
		this.teacher = teacher;
		this.address = address;
		this.shareFlag = shareFlag;
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

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShareFlag() {
		return shareFlag;
	}

	public void setShareFlag(String shareFlag) {
		this.shareFlag = shareFlag;
	}

	@Override
	public Map<String, String> getFieldCorrespondence() {
		Map<String , String> maps = new LinkedHashMap<>();
		maps.put("id", "�γ̱��");
		maps.put("name", "�γ�����");
		maps.put("credit", "ѧ��");
		maps.put("teacher", "�ڿ���ʦ");
		maps.put("address", "�ڿεص�");
		maps.put("shareFlag", "����");
		return maps;
	}
	
	

}
