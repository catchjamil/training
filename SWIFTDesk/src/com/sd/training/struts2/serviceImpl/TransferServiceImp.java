package com.sd.training.struts2.serviceImpl;

import java.util.List;

import com.sd.training.struts2.bean.Payee;
import com.sd.training.struts2.bean.Transfer;
import com.sd.training.struts2.dao.TransferDao;
import com.sd.training.struts2.daoimpl.TransferDaoImp;
import com.sd.training.struts2.service.TransferService;

public class TransferServiceImp implements TransferService {

	@Override
	public Transfer save(Transfer transfer) {
		TransferDao transferDao= new TransferDaoImp();
		transfer=transferDao.save(transfer);
		
		return transfer;
	}

	@Override
	public List<Payee> getPayeeList() {
		TransferDao transferDao= new TransferDaoImp();
	    List<Payee> arrayList=transferDao.getPayeeList();
	    return arrayList;
	}

	@Override
	public List getAccountList() {
		// TODO Auto-generated method stub
		return null;
	}



}
