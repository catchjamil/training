package com.sd.training.struts2.service;

import java.util.List;

import com.sd.training.struts2.bean.Payee;
import com.sd.training.struts2.bean.Transfer;
import com.sd.training.struts2.bean.User;

public interface TransferService {
	public Transfer save(Transfer transfer);

	public List<Payee> getPayeeList();
	public List<User> getAccountList(String usernane);
	public List<Payee> getDesAcNo(String payee);
	
}

 
