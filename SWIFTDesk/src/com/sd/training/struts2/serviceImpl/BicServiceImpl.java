package com.sd.training.struts2.serviceImpl;

import com.sd.training.struts2.bean.Bic;
import com.sd.training.struts2.dao.BicDao;
import com.sd.training.struts2.daoimpl.BicDaoImpl;
import com.sd.training.struts2.service.BicService;

public class BicServiceImpl implements BicService {

	@Override
	public Bic save(Bic bic) throws RuntimeException {
		BicDao bicDao=new BicDaoImpl();
		bic=bicDao.save(bic);
		return bic;
	}

}
