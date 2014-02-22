package com.sd.training.struts2.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import com.sd.training.struts2.bean.Menu;
import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.service.LoginService;
import com.sd.training.struts2.service.MenuService;
import com.sd.training.struts2.serviceImpl.LoginServiceImpl;
import com.sd.training.struts2.serviceImpl.MenuServiceImpl;

public class LoginAction extends ActionSupport {
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
		
		Menu menu1=new Menu();
		
		menu1.setMenuId(1L);
		menu1.setName("Registraion");
		//menu1.setLinkName("fwdToUserRegistration.action");
		
		Menu menu2=new Menu();

		menu2.setMenuId(2L);
		menu2.setName("Hello");
	//	menu2.setLinkName("hello.action");
		
		menuList.add(menu1);
		menuList.add(menu2);
	}
	StringBuffer stringBuffer = new StringBuffer();
	public String execute() {
		LoginService loginServiceImpl = new LoginServiceImpl();
		if (loginServiceImpl.authenticateUser(this.getUser())) {
		/*	MenuService menuService = new MenuServiceImpl();
			List<Menu> menuList2 = menuService.menuList(user);
			for(Menu menu: menuList2){
				menu.getName()
				menu.getHref()
				
				stringBuffer.append("<li class=\"active\"><a href=\"");
				stringBuffer.append(menu.getHref());
				stringBuffer.append("\">");
				stringBuffer.append(menu.getName());
				stringBuffer.append("</a></li>");
			}
		*/	//setMenuList(menuService.menuList(user));
			return SUCCESS;
		} else {
			return ERROR;
		}

	}
	
	
	

	
	
public static void main(String[] args) {
		new LoginAction().execute();	
   }
}
