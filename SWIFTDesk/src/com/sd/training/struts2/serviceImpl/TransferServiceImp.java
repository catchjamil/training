package com.sd.training.struts2.serviceImpl;

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

}
