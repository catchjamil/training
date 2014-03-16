package com.sd.training.struts2.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.Menu;
import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.service.LoginService;
import com.sd.training.struts2.serviceImpl.LoginServiceImpl;

public class LoginAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;
	
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
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
	if (loginServiceImpl.authenticateUser(this.getUser())) {
		 MenuConfig menuConfig = new MenuConfig();
		String menuMessage = menuConfig.getMenuHtml(this.getUser());
		System.out.println(menuMessage);
		menuMessage= menuMessage != null ? menuMessage:"Menu is not mapped with role";
		this.getUser().setMenuList(menuMessage);
		getSession2().setAttribute("userDetails", this.getUser());
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
}
