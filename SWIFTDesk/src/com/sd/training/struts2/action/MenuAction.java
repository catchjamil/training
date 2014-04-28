package com.sd.training.struts2.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.Menu;
import com.sd.training.struts2.bean.Role;
import com.sd.training.struts2.service.MenuService;
import com.sd.training.struts2.serviceImpl.MenuServiceImpl;

public class MenuAction extends ActionSupport {

		private static final long serialVersionUID = 1L;
		private Menu menu;
		List<Menu> menulist;
		List<Role> rolelist;
		public List<Role> getRolelist() {
			return rolelist;
		}

		public void setRolelist(List<Role> rolelist) {
			this.rolelist = rolelist;
		}

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
		
		public String fwdToMenu(){
			MenuService menuService=new MenuServiceImpl();
			List<Menu> list1=menuService.getMenuList();
			setMenulist(list1);
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
			
			return fwdToMenu();
		}
		
		public String fwdToRoleMenu(){
			MenuService menuService=new MenuServiceImpl();
			List<Menu> list1=menuService.getMenuList();
			List<Role> list2=menuService.getRoleList();
			setMenulist(list1);
			setRolelist(list2);
		return 	"fwdToRoleMenu";
		}
}
