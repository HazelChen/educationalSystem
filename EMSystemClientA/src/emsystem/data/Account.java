package emsystem.data;

import java.io.Serializable;

public class Account implements Serializable{
	private static final long serialVersionUID = -7958527394040623442L;
	private String name;
	private String password;
	private int jibie;
	private String keti;
	
	public Account(String name,String password,int jibie,String keti){
		this.name=name;
		this.password=password;
		this.jibie=jibie;
		this.keti=keti;
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
	public int getJibie() {
		return jibie;
	}
	public void setJibie(int jibie) {
		this.jibie = jibie;
	}
	public String getKeti() {
		return keti;
	}
	public void setKeti(String keti) {
		this.keti = keti;
	}
	
}
