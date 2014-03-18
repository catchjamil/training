package com.sd.training.struts2.serviceImpl;



import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.dao.PasswordDao;
import com.sd.training.struts2.daoimpl.PasswordDaoImp;
import com.sd.training.struts2.security.Encryt;
import com.sd.training.struts2.service.PasswordService;


public class PasswordServiceImp implements PasswordService{

	public User save(User user) throws RuntimeException {
	PasswordDao passwordDao =new PasswordDaoImp();
	 String string=Encryt.getHash(user.getPassword());
	 user.setPassword(string);
	    user=passwordDao.save(user);
		return user;
	}
}
