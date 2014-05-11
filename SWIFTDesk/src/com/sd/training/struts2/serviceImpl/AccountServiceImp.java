package com.sd.training.struts2.serviceImpl;

import com.sd.training.struts2.bean.Account;
import com.sd.training.struts2.dao.AccountDao;
import com.sd.training.struts2.daoimpl.AccountDaoImp;
import com.sd.training.struts2.service.AccountService;

public class AccountServiceImp implements AccountService{

	@Override
	public Account save(Account account) {
		AccountDao accountDao=new AccountDaoImp();
		accountDao.save(account);
		return account;
	}

	@Override
	public long setAccNo(long l) {
		AccountDao accountDao=new AccountDaoImp();
		return accountDao.setAccNo(l);
	}

	@Override
	public long getAccNo() {
		AccountDao accountDao=new AccountDaoImp();
		return accountDao.getAccNo();
	}

}
