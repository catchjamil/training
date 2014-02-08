package com.sd.training.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.Payee;
import com.sd.training.struts2.service.PayeeService;
import com.sd.training.struts2.serviceImpl.PayeeServiceImpl;

public class PayeeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String PAYEE_FORM="addPayee";
	private Payee payee;
	private String message;
	public Payee getPayee() {
		return payee;
	}
	public void setPayee(Payee payee) {
		this.payee = payee;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public String save() {
		PayeeService payeeService=new PayeeServiceImpl();
		Payee payeeResponse=payeeService.save(payee);
		if(payeeResponse!=null)
		{
			setMessage("Payee data save Succuessfully");
		}else{
			setMessage("Error while saving data");
		}
		return PAYEE_FORM;
	}
	

}
