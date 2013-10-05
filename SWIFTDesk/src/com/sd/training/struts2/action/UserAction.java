package com.sd.training.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.service.UserService;
import com.sd.training.struts2.serviceImpl.UserServiceImpl;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private static final String USER_FORM = "userForm";
	private User user;

	public User getUser() {
		return user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	private String message;

	public String save() {
		UserService userServiceImpl = new UserServiceImpl();
		User userResponse = userServiceImpl.save(user);
		if(userResponse != null){
			setMessage("User data saved successfully.");
		}else{
			setMessage("Error while saving.");
		}
		return USER_FORM;
	}

	public String execute() {
		UserService userServiceImpl = new UserServiceImpl();
		if (true) {
			return SUCCESS;
		} else {
			return ERROR;
		}

	}

}
