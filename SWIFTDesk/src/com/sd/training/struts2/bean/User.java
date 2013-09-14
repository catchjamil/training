package com.sd.training.struts2.bean;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 2006827975533105606L;
	private String uname, password;

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
