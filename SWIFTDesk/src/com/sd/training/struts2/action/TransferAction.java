package com.sd.training.struts2.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.Transfer;

public class TransferAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private static String TRANSFER_FORM="transfer";
	
	private Transfer transfer;
	private List<String> ac_list;
	private List<String> payee_list;
	
	
	public String populateAccount(){
		ac_list=new ArrayList<String>();
		
		return null;	
	}
	public String populatePayee(){
		payee_list=new ArrayList<String>();
		
		return null;
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
