package com.sd.training.struts2.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="password_form")
public class Password implements Serializable{
	
	private static final long serialversionUID=1L;
	
	@Id 
	@GeneratedValue
	private Long Id;
	public Long getId() {
		return Id;
	}
	
	public void setId(Long id) {
		Id = id;
	}


	private String userid;
	private String oldpass;
	private String newpass;
	private String cnfmpass;
	public String getUserid() {
		return userid;
	}
	
	
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Column(name="oldpass")
	public String getOldpass() {
		return oldpass;
	}
	public void setOldpass(String oldpass) {
		this.oldpass = oldpass;
	}
	
	@Column(name="newpass")
	public String getNewpass() {
		return newpass;
	}
	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}
	
	@Column(name="cnfmpass")
	public String getCnfmpass() {
		return cnfmpass;
	}
	public void setCnfmpass(String cnfmpass) {
		this.cnfmpass = cnfmpass;
	}
	
	

}
