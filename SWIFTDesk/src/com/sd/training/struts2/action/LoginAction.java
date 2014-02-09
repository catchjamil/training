package com.sd.training.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.service.LoginService;
import com.sd.training.struts2.serviceImpl.LoginServiceImpl;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private static final String SUCCESS = "success";
	private static final String FWD_TO_USERREGISTRATION = "fwdToUserRegistration";
	private static final String ERROR = "error";
	private static final String FWD_TO_PAYEE = "fwdToAddPayee";
	private static final String FWD_TO_TRANSFER = "fwdToTransfer";
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() {
		LoginService loginServiceImpl = new LoginServiceImpl();
		if (loginServiceImpl.authenticateUser(this.getUser())) {
			return SUCCESS;
		} else {
			return ERROR;
		}

	}
	public String fwdToAddPayee(){
		return FWD_TO_PAYEE;
	}
	public String fwdToTransfer(){
		return FWD_TO_TRANSFER;
	}

	public String fwdToUserRegistration() {
		return FWD_TO_USERREGISTRATION;
	}
public static void main(String[] args) {
		new LoginAction().execute();	
   }
}
