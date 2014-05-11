package com.sd.training.struts2.action;

//http://swift-parser.sourceforge.net/xref/index.html
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.Account;
import com.sd.training.struts2.bean.Menu;
import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.service.LoginService;
import com.sd.training.struts2.service.UserService;
import com.sd.training.struts2.serviceImpl.LoginServiceImpl;
import com.sd.training.struts2.serviceImpl.UserServiceImpl;

public class LoginAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;
	
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	private String message;
	private List accountDetails;
	
	public List getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(List accountDetails) {
		this.accountDetails = accountDetails;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	private List<Menu> menuList;
	
	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
		
			}
	public String execute() {	
		LoginService loginServiceImpl = new LoginServiceImpl();
		User authenticateUser = loginServiceImpl.authenticateUser(this.getUser());
	if (authenticateUser != null) {
		 MenuConfig menuConfig = new MenuConfig();
		String menuMessage = menuConfig.getMenuHtml(authenticateUser);
		System.out.println(menuMessage);
		menuMessage= menuMessage != null ? menuMessage:"Menu is not mapped with role";
		authenticateUser.setMenuList(menuMessage);
		getSession2().setAttribute("userDetails", authenticateUser);
		fwdToHome();
		return SUCCESS;
	} else {
		return ERROR;
	}
}
	
public String logout(){
	
	getSession2().removeAttribute("userDetails");
	getSession2().invalidate();
	return SUCCESS;
}


public String loginForm(){
	
	return "loginForm";
}

private HttpSession session2;
public HttpSession getSession2() {
	return session2;
}

public void setSession2(HttpSession session2) {
	this.session2 = session2;
}

@Override
public void setServletRequest(HttpServletRequest arg0) {
	
	setSession2(arg0.getSession());
}
public String fwdToHome(){
	User user=(User)getSession2().getAttribute("userDetails");
	long accountNumber=user.getAccountNo();
	Account account= new Account();
	account.setAccountnumber(accountNumber);
	UserService userServiceImpl = new UserServiceImpl();
	account=userServiceImpl.getAccountNo(account);
	List<Account> list=new ArrayList<Account>();
	list.add(account);
	setAccountDetails(list);
	//String str="Your Balance"+account.getBalance();
	//setMessage(str);
	return "fwdToHome";
}
}
