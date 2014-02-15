package com.sd.training.struts2.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.Payee;
import com.sd.training.struts2.bean.Transfer;
import com.sd.training.struts2.dao.TransferDao;
import com.sd.training.struts2.daoimpl.PayeeDaoImpl;
import com.sd.training.struts2.daoimpl.TransferDaoImp;

public class TransferAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private static final String FWD_TO_TRANSFER = "fwdToTransfer";
	private static String TRANSFER_FORM="transfer";
	
	private Transfer transfer;
	public String execute() {
		TransferDao transferDao =new TransferDaoImp();			
		List<Payee> accountList = transferDao.getAccountList();
		
		List<String> accounts1 = new ArrayList<String>();
		for(Payee payee : accountList){
			long account_no = payee.getAccount_no();
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
	public String fwdToTransfer(){
		return FWD_TO_TRANSFER;
	}
	
	public String save() {
		
		
		/*if( !=null){
			setMessage("Transaction is success.");
		}else{
			setMessage("Error while transfering");
		}*/
		return TRANSFER_FORM;
	}

}
