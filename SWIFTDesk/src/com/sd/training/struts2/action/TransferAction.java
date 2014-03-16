package com.sd.training.struts2.action;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.Payee;
import com.sd.training.struts2.bean.Transfer;
import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.service.TransferService;
import com.sd.training.struts2.serviceImpl.TransferServiceImp;

public class TransferAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private static final String FWD_TO_TRANSFER = "fwdToTransfer";
	private static String TRANSFER_FORM="transfer";
	
	private Transfer transfer;
	private String message; 
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Transfer getTransfer() {
		return transfer;
	}


	public void setTransfer(Transfer transfer) {
		this.transfer = transfer;
	}


	public String execute() {
		
		
		TransferService transferService=new TransferServiceImp();	
		List<Payee> payeelist = transferService.getPayeeList();
		List<User> accountList = transferService.getAccountList("usernane");
		List<String> accounts1 = new ArrayList<String>();
		for(Payee payee : payeelist){
			String account_no = payee.getName();
		
			accounts1.add(account_no+"");
		}
		setPayees(accounts1);
		List<String> accounts2 = new ArrayList<String>();
		for(User user :accountList){
			String account_no = Integer.toString(user.getId());
			accounts2.add(account_no+"");
		}
	
		setAccounts(accounts2);
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
	private List<String> payees;

	public List<String> getPayees() {
		return payees;
	}


	public void setPayees(List<String> payees) {
		this.payees = payees;
	}
	private String account;
	private List<String> payeeAcc;
	
	 public List<String> getPayeeAcc() {
		return payeeAcc;
	}


	public void setPayeeAcc(List<String> payeeAcc) {
		this.payeeAcc = payeeAcc;
	}
	HttpServletRequest request;
	 HttpServletResponse response;
	public String getDesAcNo(){
		System.out.println("transfer check");
		TransferService transferService=new TransferServiceImp();
				String str =request.getParameter("name");
				String str1=""; 
				List<Payee> payeelist = transferService.getDesAcNo(str);
				for(Payee payee : payeelist){
					String account_no = Long.toString(payee.getAccount_no());
					
					str1+=account_no+",";
				}
				
				
			        System.out.println("Ajax request receive with id : [] and reply value : " + str1);
			       
					response.setContentType("text/html;charset=UTF-8");
			        response.setHeader("Cache-Control", "no-cache");
			        try {
			            response.getWriter().write(str1);
			        } catch (IOException ioe) {
			            ioe.printStackTrace();
			        }
		
		return null;
	}
	
	public String save() {
		TransferService transferService=new TransferServiceImp();
		
		transfer.setDestinationAcc(request.getParameter("des_no"));
		Transfer reponse= transferService.save(transfer);
		
		if(reponse !=null){
			setMessage("Transaction is success.");
		}else{
			setMessage("Error while transfering");
		}
		
		execute();
		return TRANSFER_FORM;
	}


	 @Override
	    public void setServletResponse(HttpServletResponse httpServletResponse) {
	        this.response = httpServletResponse;
	    }


	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.request=httpServletRequest;
		
	}


	

}
