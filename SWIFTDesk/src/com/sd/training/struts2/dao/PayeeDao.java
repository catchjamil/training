package com.sd.training.struts2.dao;

import java.util.List;

import com.sd.training.struts2.bean.Payee;

public interface PayeeDao {
	public Payee save(Payee payee) throws RuntimeException;
	public List<Payee> getAccountList()  throws RuntimeException;
}
