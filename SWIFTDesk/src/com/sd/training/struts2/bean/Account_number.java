package com.sd.training.struts2.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	
@Table
public class Account_number implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue
	@Column(name="id")
	private Long Id;
	public Long getId() {
		return Id;
	}
	@Column
	private long accountNo;

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	

}
