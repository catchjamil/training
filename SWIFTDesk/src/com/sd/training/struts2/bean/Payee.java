package com.sd.training.struts2.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="payee_info")
public class Payee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long account_no;
	private String Name;
	private String nickName;
	
	
	@Id 
	@GeneratedValue
	@Column(name="id")
	private Long Id;
	public Long getId() {
		return Id;
	}
	@Column(name="account_no")
	public long getAccount_no() {
		return account_no;
	}
	public void setAccount_no(long account_no) {
		this.account_no = account_no;
	}
	@Column(name="name")
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Column(name="nick_name")
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
}
