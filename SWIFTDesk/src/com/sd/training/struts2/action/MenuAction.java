package com.sd.training.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.Menu;

public class MenuAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private static final String MENU="menu";
	private Menu menu;
	private String message;
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String save(){
		
		
		
		return MENU;
	}

}
