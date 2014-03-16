package com.sd.training.struts2.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sd.training.struts2.bean.Payee;
import com.sd.training.struts2.bean.Role;
import com.sd.training.struts2.dao.RoleDao;
import com.sd.training.struts2.util.HibernateUtil;

public class RoleDaoImpl implements RoleDao {

	@Override
	public List<Role> getRoles() {
		
		Session session=HibernateUtil.openSession();
		Query createQuery = session.createQuery("from Role");
		List<Role> arrayList = new ArrayList<Role>();
		List<Role> list = createQuery.list();
		
		for(Object obj:list){
			Role role = (Role)obj;
			arrayList.add(role);
	}
		session.close();	
		return arrayList;
	}}
