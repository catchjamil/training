package com.sd.training.struts2.dao;

import java.util.List;

import com.sd.training.struts2.bean.Payee;
import com.sd.training.struts2.bean.Transfer;
import com.sd.training.struts2.bean.User;

public interface TransferDao {
	public Transfer save(Transfer transfer)throws RuntimeException;
	public List<Payee> getPayeeList()  throws RuntimeException;
	public List<User> getAcoountList(String username);
	public List<Payee> getDesAcNo(String payee);
}
