package com.sd.training.struts2.service;

import java.util.List;

import com.sd.training.struts2.bean.Payee;
import com.sd.training.struts2.bean.Transfer;

public interface TransferService {
	public Transfer save(Transfer transfer);

	public List<Payee> getPayeeList();
	public List getAccountList();

	
}

 
