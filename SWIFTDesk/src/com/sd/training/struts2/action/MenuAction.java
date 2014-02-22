package com.sd.training.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.Menu;
import com.sd.training.struts2.service.MenuService;
import com.sd.training.struts2.serviceImpl.MenuServiceImpl;

public class MenuAction extends ActionSupport {

		private static final long serialVersionUID = 1L;
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

		private static String FWD_TO_MENU="fwdToMenu";
		private static String MENU_FORM="menuForm";
		
		public String fwdToMenu(){
			return FWD_TO_MENU;
		}
		
		public String save(){
			MenuService menuService=new MenuServiceImpl();
			Menu response=menuService.save(menu);
			if(response!=null){
				setMessage("Link added sucessfully");
			}else{
				setMessage("error in saving data");
			}
			
			return MENU_FORM;
		}
}
