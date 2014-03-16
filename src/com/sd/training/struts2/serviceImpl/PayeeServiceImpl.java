package com.sd.training.struts2.serviceImpl;

import com.sd.training.struts2.bean.Payee;
import com.sd.training.struts2.dao.PayeeDao;
import com.sd.training.struts2.daoimpl.PayeeDaoImpl;
import com.sd.training.struts2.service.PayeeService;

public class PayeeServiceImpl implements PayeeService{

	@Override
	public Payee save(Payee payee) throws RuntimeException {
		PayeeDao payeeDao=new PayeeDaoImpl();
		payee=payeeDao.save(payee);
		return payee;
	}

}
