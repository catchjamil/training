package com.sd.training.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.opensymphony.xwork2.ActionSupport;
import com.sd.training.struts2.bean.Payee;
import com.sd.training.struts2.daoimpl.PayeeDaoImpl;

public class RoleAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static String FWD_TO_ROLE="role";
	public String fwdtoRole(){
		return FWD_TO_ROLE;
	}
	
}
