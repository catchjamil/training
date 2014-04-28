package com.sd.training.struts2.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.Role;
import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.service.UserService;
import com.sd.training.struts2.serviceImpl.RoleServiceImpl;
import com.sd.training.struts2.serviceImpl.UserServiceImpl;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private static final String USER_FORM = "userForm";
	private static final String FWD_TO_USERREGISTRATION = "fwdToUserRegistration";
	
	private User user;
	private String message;

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
	
	private List<Role> roles;
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	public String fwdToUserRegistration() {
		RoleServiceImpl roleServiceImpl = new RoleServiceImpl();
		this.setRoles(roleServiceImpl.getRoles());
		return FWD_TO_USERREGISTRATION;
	}
	
	public String fwdToContact(){
		return "fwdToContact";
		
	}

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
