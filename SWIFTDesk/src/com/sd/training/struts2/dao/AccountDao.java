package com.sd.training.struts2.dao;

import com.sd.training.struts2.bean.Account;

public interface AccountDao {
	public Account save(Account account);
	public long setAccNo(long l);
	public long getAccNo();
	
}
