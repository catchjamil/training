package com.sd.training.struts2.dao;

import java.util.List;

import com.sd.training.struts2.bean.Payee;
import com.sd.training.struts2.bean.Transfer;

public interface TransferDao {
	public Transfer save(Transfer transfer)throws RuntimeException;
	public List<Payee> getPayeeList()  throws RuntimeException;

}
