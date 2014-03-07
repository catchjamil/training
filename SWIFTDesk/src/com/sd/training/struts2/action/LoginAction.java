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
			getSession2().removeAttribute("menuMessage");
			 MenuConfig menuConfig = new MenuConfig();
			System.out.println(menuConfig.getMenuHtml());
			getSession2().setAttribute("menuMessage", menuMessage);
			return SUCCESS;
		} else {
			return ERROR;
		}

	}
	
private String menuMessage;
	
public String getMenuMessage() {
		return menuMessage;
	}

	public void setMenuMessage(String menuMessage) {
		this.menuMessage = menuMessage;
	}

public static void main(String[] args) {
		new LoginAction().execute();	
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
