package com.sd.training.struts2.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sd.training.struts2.bean.Menu;
import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.service.MenuService;
import com.sd.training.struts2.serviceImpl.MenuServiceImpl;

public class MenuConfig {

	/**
	 * @param args
	 */
	static MenuConfig menuConfig = new MenuConfig();
	public static void main(String[] args) {
		
		menuConfig.getMenuHtml();
	}
	
	public String getMenuHtml(){

		// TODO Auto-generated method stub
		MenuService menuService = new MenuServiceImpl();
		User user = new User();
		user.setRoleID(1);
		StringBuffer stringBuffer = new StringBuffer();
		List<Menu> menuList = menuService.menuList(user);
		Map map = new HashMap();
		for (Menu menu : menuList) {

			Long menuId = menu.getId();
			List list = new ArrayList();
			for (Menu menu1 : menuList) {
				if (menuId.equals(menu1.getParentId())) {
					list.add(menu1);
				}
			}
			if(list.size() >0)
			map.put(menu, list);

		}

		for (Menu menu : menuList) {
			Object object = map.get(menu);
			if (object != null) {
				stringBuffer
						.append(menuConfig.getFirstLevelMenu(menu.getName()));

				List listOfMenu = (List) object;
				for (Object obj : listOfMenu) {
					Menu menu1 = (Menu) obj;
					object = map.get(menu1);
					if (object != null) {
						stringBuffer.append(menuConfig.getSubMenu(menu1
								.getName()));
						listOfMenu = (List) object;
						for (Object obj1 : listOfMenu) {
							Menu menu2 = (Menu) obj1;
							stringBuffer.append(menuConfig.getSubMenuList(
									menu2.getHref(), menu2.getName()));
						}
					}else{
						stringBuffer.append(menuConfig.getMainMenu(menu1.getHref(),	menu1.getName()));
					}
				}
			} else {
				stringBuffer.append(menuConfig.getMainMenu(menu.getHref(),
						menu.getName()));
			}

		}

	return stringBuffer.toString();
	}

	private String getMainMenu(String href, String name) {
		return "<li><a href=\"" + href + "\">" + name + "</a></li>\n";
	}

	private String getFirstLevelMenu(String mainMenu) {
		String sting = "<li class=\"dropdown\">\n"
				+ "<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n"
				+ mainMenu + " <b class=\"caret\"></b></a>\n"
				+ "<ul class=\"dropdown-menu\">\n";
		return sting;
	}

	private String getSubMenu(String mainMenu) {
		String s = "<li class=\"dropdown-submenu\"> \n <a tabindex=\"-1\" href=\"#\">"
				+ mainMenu + "</a>" + "<ul class=\"dropdown-menu\">\n";

		return s;
	}

	private String getSubMenuList(String href, String name) {

		return "<li><a tabindex=\"-1\" href=\"" + href + "\">" + name + "</a>\n";
	}

}
