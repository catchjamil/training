package com.sd.training.struts2.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.services.LoginService;
import com.sd.training.struts2.servicesImpl.LoginServiceImpl;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

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

	public String execute() {
		LoginService loginServiceImpl = new LoginServiceImpl();
		if (loginServiceImpl.authenticateUser(uname, password)) {
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}

}
