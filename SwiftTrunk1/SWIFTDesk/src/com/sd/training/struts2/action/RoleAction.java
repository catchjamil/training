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
	private String data = "Afghanistan, Zimbabwe, India, United States, Germany, China,Australia";
	private List<String> countries;
	private String country;
	public String fwdtoRole(){
		countries = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(data, ",");
		while (st.hasMoreTokens()) {
		countries.add(st.nextToken().trim());
		}
		
		
		return FWD_TO_ROLE;
	}
	public List<String> getCountries() {
		return countries;
		}
		public void setCountries(List<String> countries) {
		this.countries = countries;
		}
}
