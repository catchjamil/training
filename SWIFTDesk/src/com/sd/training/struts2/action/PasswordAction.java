package com.sd.training.struts2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.Password;
import com.sd.training.struts2.bean.Payee;
import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.service.LoginService;
import com.sd.training.struts2.service.PasswordService;
import com.sd.training.struts2.service.PayeeService;
import com.sd.training.struts2.serviceImpl.LoginServiceImpl;
import com.sd.training.struts2.serviceImpl.PasswordServiceImp;
import com.sd.training.struts2.serviceImpl.PayeeServiceImpl;

public class PasswordAction  extends ActionSupport implements ServletRequestAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final long Serializeversion=1L;
	public static final String PASSWORD_FORM="passwordform";
	
	
	private Password pass;
	private String message;
	private HttpSession session;
	
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public Password getPass() {
		return pass;
	}
	public void setPass(Password pass) {
		this.pass = pass;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}	
	
	public String fwdToResetPass(){
		return PASSWORD_FORM;
	}
	public String save() {
		User user1=(User)session.getAttribute("userDetails");
		User user =new User();
		user.setUname(user1.getUname());
		user.setPassword(pass.getOldpass());
		LoginService loginServiceImpl = new LoginServiceImpl();
		
		if (loginServiceImpl.authenticateUser(user)){
			PasswordService passwordService=new PasswordServiceImp();
			user.setPassword(pass.getNewpass());
			user= passwordService.save(user);
			if(user!=null)
			setMessage("Password Has been Changed Succuessfully");	
			else 
				setMessage("Error while changing password");
		}	
		else{
			setMessage("Worng old Password ");
		}
		return PASSWORD_FORM;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		
		
	}
	

}
