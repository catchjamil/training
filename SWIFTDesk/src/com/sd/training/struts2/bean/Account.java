package com.sd.training.struts2.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity	
@Table(name="Account")
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@Column
	private String accounttype;
	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	@Column
	private long accountnumber;
	@Column
	private Float balance;

	public long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}


	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}
	@Column
	private String nametitle;
	@Column
	private String firstname;
	@Column
	private String middlename;
	@Column
	private String lastname;
	@Column
	private String mothername;
	@Column
	private String fathername;
	public String getMothername() {
		return mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public String getPstate() {
		return pstate;
	}

	public void setPstate(String pstate) {
		this.pstate = pstate;
	}

	public String getPcity() {
		return pcity;
	}

	public void setPcity(String pcity) {
		this.pcity = pcity;
	}

	public String getPpin() {
		return ppin;
	}

	public void setPpin(String ppin) {
		this.ppin = ppin;
	}
	@Column
	private String dob;
	@Column
	private String nationality;
	@Column
	private String address;
	@Column
	private String state;
	@Column
	private String pin;
	@Column
	private String city;
	@Column
	private String sameaddress;
	@Column
	private String email;
	@Column
	private String phoneNo;
	@Column
	private String paddress;
	@Column
	private String pstate;
	@Column
	private String pcity;
	@Column
	private String ppin;
	public String getNametitle() {
		return nametitle;
	}

	public void setNametitle(String nametitle) {
		this.nametitle = nametitle;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSameaddress() {
		return sameaddress;
	}

	public void setSameaddress(String sameaddress) {
		this.sameaddress = sameaddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	



}
