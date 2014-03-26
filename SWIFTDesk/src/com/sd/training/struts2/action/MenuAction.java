package com.sd.training.struts2.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.Menu;
import com.sd.training.struts2.service.MenuService;
import com.sd.training.struts2.serviceImpl.MenuServiceImpl;

public class MenuAction extends ActionSupport {

		private static final long serialVersionUID = 1L;
		private Menu menu;
		List<Menu> menulist;
		public List<Menu> getMenulist() {
			return menulist;
		}

		public void setMenulist(List<Menu> menulist) {
			this.menulist = menulist;
		}

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
			MenuService menuService=new MenuServiceImpl();
			/*List<Menu> list1=menuService.getMenuList();
			setMenulist(list1);*/
			return FWD_TO_MENU;
		}
		
		public String save(){
			MenuService menuService=new MenuServiceImpl();
			menu.setParentId(menu.getParentId() < 1? null: menu.getParentId());
			Menu response=menuService.save(menu);
			if(response!=null){
				setMessage("Link added sucessfully");
			}else{
				setMessage("error in saving data");
			}
			
			return MENU_FORM;
		}
}
