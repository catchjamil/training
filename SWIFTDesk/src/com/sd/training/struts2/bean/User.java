package com.sd.training.struts2.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity	
@Table(name="user_info")
public class User implements Serializable{
	private static final long serialVersionUID = 2006827975533105606L;

	private int id;
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String uname; 
	private String password;
	private String firstName;
	
	@Column(name="first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="username")
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	private String email;
	@Column(name="email")
	public String getEmail() {
		return "email@email.com";
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
