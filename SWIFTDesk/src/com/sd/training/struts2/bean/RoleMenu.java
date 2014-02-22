package com.sd.training.struts2.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class RoleMenu  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6284148609738666529L;
	
	@Id 
	@GeneratedValue
	private Long Id;
	private Long roleId;
	private List<Menu> menus;

	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	 public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
}