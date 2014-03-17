package com.sd.training.struts2.daoimpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sd.training.struts2.bean.Role;
import com.sd.training.struts2.dao.RoleDao;
import com.sd.training.struts2.util.HibernateUtil;

public class RoleDaoImpl implements RoleDao{

	
	public Role setData(Role role) throws RuntimeException {
		
		try{
			Session session = HibernateUtil.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(role);
			transaction.commit();
			session.close();
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return role;
		}
	public List<Role> getRoleList(){
		Session session=HibernateUtil.openSession();
		Query createQuery=session.createQuery("from Role");
		List<Role> arrayList=new ArrayList<Role>();
		List<?> list = createQuery.list();
		for(Object object: list )
		{
			Role role=(Role)object;
			arrayList.add(role);
		}
		return arrayList;
		}
		
}




