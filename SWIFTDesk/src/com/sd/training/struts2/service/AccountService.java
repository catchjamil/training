package com.sd.training.struts2.service;

import com.sd.training.struts2.bean.Account;

public interface AccountService {
	public Account save(Account account);
	public long setAccNo(long l);
	public long getAccNo();

}
