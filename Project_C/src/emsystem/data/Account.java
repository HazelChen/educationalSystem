package emsystem.data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Account implements Serializable,ModelSpecification{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String name;
	private String password;
	private Timestamp createTime;
	
	public Account(String name,String password,Timestamp ts){
		this.name=name;
		this.password=password;
		this.createTime = ts;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getCreateTime(){
		return createTime;
	}
	public void setCreateTime(Timestamp ts){
		this.createTime = ts;
	}
	@Override
	public Map<String, String> getFieldCorrespondence() {
		Map<String, String> map=new LinkedHashMap<String, String>();
		map.put("name", "acc");
		map.put("password", "pwd");
		map.put("createtime", "createTime");
		return map;
	}
	
}
