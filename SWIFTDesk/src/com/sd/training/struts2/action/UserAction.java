package com.sd.training.struts2.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.Account;
import com.sd.training.struts2.bean.Role;
import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.service.LoginService;
import com.sd.training.struts2.service.UserService;
import com.sd.training.struts2.serviceImpl.LoginServiceImpl;
import com.sd.training.struts2.serviceImpl.RoleServiceImpl;
import com.sd.training.struts2.serviceImpl.UserServiceImpl;
import com.sd.training.struts2.util.SendEmail;

public class UserAction extends ActionSupport implements ServletRequestAware,ServletResponseAware  {
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

	public String save() throws Exception {
		UserService userServiceImpl = new UserServiceImpl();
		Account account=new Account();
		account.setAccountnumber(user.getAccountNo());
		if(userServiceImpl.getAccountNo(account)!=null){
		String password=user.getPassword();
		User userResponse = userServiceImpl.save(user);
		if(userResponse != null){
			String msg="Hello "+userResponse.getFirstName()+" your account is created your User Id is "+userResponse.getUname()+" password is: "+password;
			String[] emails={userResponse.getEmail(),};
			SendEmail sendEmail=new SendEmail();
			sendEmail.SendEmail("SwiftDesk info", msg, emails,null,null);
			setMessage("User data saved successfully.");
		}else{
			setMessage("Error while saving.");
		}
		}else{
			setMessage("Account No Not Exist");
		}
		return fwdToUserRegistration();
	}

	public String execute() {
		UserService userServiceImpl = new UserServiceImpl();
		if (true) {
			return SUCCESS;
		} else {
			return ERROR;
		}

	}
	HttpServletRequest request;
	 HttpServletResponse response;
	 private HttpSession session;
	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response=arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request=arg0;
	}
public String validuname(){
	String str =request.getParameter("name");
	UserService userServiceImpl = new UserServiceImpl();
	User user=new User();
	System.out.println(str);
	user.setUname(str);
	response.setContentType("text/html;charset=UTF-8");
    response.setHeader("Cache-Control", "no-cache");
    try {
	   if (userServiceImpl.validuname(user)){
            response.getWriter().write("yes");
        }
	   else{
         response.getWriter().write("no");
        }
    }catch (IOException ioe) {
            ioe.printStackTrace();
        }
	
	return null;
}
public String fwdToHelp(){
	return "fwdToHelp";
}

}
