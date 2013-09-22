package com.sd.training.struts2.bean;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 2006827975533105606L;
	private String uname; 
	private String password;
	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
