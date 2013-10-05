package com.sd.training.struts2.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Role  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6284148609738666529L;
	
	@Id 
	@GeneratedValue
	private Long Id;
	private Long menuId;
	private Long userId;

	 public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	@Column
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	@Column
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}