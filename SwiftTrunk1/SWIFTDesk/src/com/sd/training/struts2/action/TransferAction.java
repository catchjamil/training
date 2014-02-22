package com.sd.training.struts2.action;


import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.Payee;
import com.sd.training.struts2.bean.Transfer;
import com.sd.training.struts2.service.TransferService;
import com.sd.training.struts2.serviceImpl.TransferServiceImp;

public class TransferAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private static final String FWD_TO_TRANSFER = "fwdToTransfer";
	private static String TRANSFER_FORM="transfer";
	
	private Transfer transfer;
	public Transfer getTransfer() {
		return transfer;
	}


	public void setTransfer(Transfer transfer) {
		this.transfer = transfer;
	}


	public String execute() {
		TransferService transferService=new TransferServiceImp();	
		List<Payee> accountList = transferService.getPayeeList();
		
		List<String> accounts1 = new ArrayList<String>();
		for(Payee payee : accountList){
			String account_no = payee.getName();
		
			accounts1.add(account_no+"");
		}
		setAccounts(accounts1);
		return FWD_TO_TRANSFER;
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
	
	
	public String save() {
		
		
		/*if( !=null){
			setMessage("Transaction is success.");
		}else{
			setMessage("Error while transfering");
		}*/
		return TRANSFER_FORM;
	}

}
