package com.sd.training.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.Account;
import com.sd.training.struts2.service.AccountService;
import com.sd.training.struts2.serviceImpl.AccountServiceImp;
import com.sd.training.struts2.util.SendEmail;

public class AccountAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Account account = new Account();
	private Account user;
	public Account getUser() {
		return user;
	}

	public void setUser(Account user) {
		this.user = user;
	}
	private String message;

public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

public String fwdToAccountOpenForm(){
	return "fwdToAccountOpenForm";
}
public String save(){
	AccountService accountService=new AccountServiceImp();
	long l =accountService.getAccNo();
	String str=null;
	if(l!=0){
		account.setAccountnumber(l+1);
		Account accountResponse =accountService.save(account);
		if(accountResponse!= null){
			SendEmail sendEmail=new SendEmail();
			String msg="Hello "+accountResponse.getFirstname()+" your account is Opened, Your Account No is :"+accountResponse.getAccountnumber();
			String[] emails={accountResponse.getEmail(),};
			try {
				sendEmail.SendEmail("SwiftDesk info", msg, emails,null,null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setMessage("User data saved successfully. Your Account Number is "+accountResponse.getAccountnumber()+str);
		
			return "view";
		}else{
			setMessage("Error while saving.");
			return "error";
	}
	}else{
		setMessage("Error in Database");
		return "error";
	}
	
	
}
}
