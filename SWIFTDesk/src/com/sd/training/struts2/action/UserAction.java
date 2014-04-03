package com.sd.training.struts2.action;

import java.awt.Checkbox;
import java.util.ArrayList;
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
	private static final String LIST_USER_FORM = "listuserForm";
	private List<User> listUsers = new ArrayList<User>();
	private User user;
	private String message;
	private Checkbox chkBox;
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
	
	public String getAllUser() {
		UserService userServiceImpl = new UserServiceImpl();
		 setListUsers(userServiceImpl.getuserlist());
		
		return LIST_USER_FORM;
	}

	public String removeProduct() {
		boolean b = chkBox.getState();
		
		
		return "success";
	}
	
	public String execute() {
		UserService userServiceImpl = new UserServiceImpl();
		if (true) {
			return SUCCESS;
		} else {
			return ERROR;
		}

	}

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}

	public Checkbox getChkBox() {
		return chkBox;
	}

	public void setChkBox(Checkbox chkBox) {
		this.chkBox = chkBox;
	}

}
