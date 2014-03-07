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
	
	public String getMenuHtml(User user){

		// TODO Auto-generated method stub
		MenuService menuService = new MenuServiceImpl();
		
		StringBuffer stringBuffer = new StringBuffer();
		List<Menu> menuList = menuService.menuList(user);
		Map<Menu,List<Menu>> map = new HashMap<Menu,List<Menu>>();
		for (Menu menu : menuList) {

			Long menuId = menu.getId();
			List<Menu> list = new ArrayList<Menu>();
			for (Menu menu1 : menuList) {
				if (menuId.equals(menu1.getParentId())) {
					list.add(menu1);
				}
			}
			if(list.size() >0)
			map.put(menu, list);

		}

		for (Menu menu : menuList) {
			List<Menu> listOfMenu = map.get(menu);
			if (listOfMenu != null) {
				stringBuffer
						.append(getFirstLevelMenu(menu.getName()));

				for (Menu menu1 : listOfMenu) {
					listOfMenu = map.get(menu1);
					if (listOfMenu != null) {
						stringBuffer.append(getSubMenu(menu1
								.getName()));
						for (Menu menu2 : listOfMenu) {
							stringBuffer.append(getSubMenuList(
									menu2.getHref(), menu2.getName()));
						}
					}else{
						stringBuffer.append(getMainMenu(menu1.getHref(),	menu1.getName()));
					}
				}
			} else {
				stringBuffer.append(getMainMenu(menu.getHref(),
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
