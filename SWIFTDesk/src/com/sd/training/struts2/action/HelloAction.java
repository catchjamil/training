package com.sd.training.struts2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.Payee;
import com.sd.training.struts2.daoimpl.PayeeDaoImpl;

public class HelloAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String helloTextFiled;
	
	public String getHelloTextFiled() {
		return helloTextFiled;
	}
	public void setHelloTextFiled(String helloTextFiled) {
		this.helloTextFiled = helloTextFiled;
	}
	public String execute() {
		System.out.println("Hi: "+getHelloTextFiled());
		
		/*PayeeDaoImpl payeeDaoImpl = new PayeeDaoImpl();
		List<Payee> accountList = payeeDaoImpl.getAccountList();
		
		List<String> accounts1 = new ArrayList<String>();
		for(Payee payee : accountList){
			long account_no = payee.getAccount_no();
			accounts1.add(account_no+"");
		}
		setAccounts(accounts1);*/
		displCountry();
		return "helloForm";
	}
	
	
	public List<String> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<String> accounts) {
		this.accounts = accounts;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}


	private List<String> accounts;
	private String account;
	
	
	private String data = "Afghanistan, Zimbabwe, India, United States, Germany, China,Australia";
	private List<String> countries;
	private String country;
	
	
	private void displCountry() {
	countries = new ArrayList<String>();
	StringTokenizer st = new StringTokenizer(data, ",");
	while (st.hasMoreTokens()) {
	countries.add(st.nextToken().trim());
	}
	}
	public String getCountry() {
	return this.country;
	}
	public List<String> getCountries() {
	return countries;
	}
	public void setCountries(List<String> countries) {
	this.countries = countries;
	}
	public void setCountry(String country) {
	this.country = country;
	}
	
}
