
package com.sd.training.struts2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.sd.training.struts2.bean.Role;
import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.service.LoginService;
import com.sd.training.struts2.service.MenuService;
import com.sd.training.struts2.service.RoleService;
import com.sd.training.struts2.serviceImpl.LoginServiceImpl;
import com.sd.training.struts2.serviceImpl.MenuServiceImpl;
import com.sd.training.struts2.serviceImpl.RoleServiceImpl;

public class RoleAction {
	private Role role;
	private static String ROLE_FORM="RoleForm";
	String 	success,error;
	private String message;
	
	private static final long serialVersionUID = 1L;
	private static String FWD_TO_ROLE="role";
	private String data = "Admin,Role";
	private List<String> countries ;
	private String country ;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	private List<Role> roleList;
	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
    public String fwdToRoleForm(){
    	RoleService roleServiceImpl = new RoleServiceImpl();
		List<Role> list = roleServiceImpl.getRoleList();
		setRoleList(list);
    	return ROLE_FORM;
    }
	public String save() {
	
		RoleService roleServiceImpl = new RoleServiceImpl();
		Role roleResponse = roleServiceImpl.save(role);
		if (roleResponse!=null) {
			setMessage("Data save successfully");
			
		}
		else{
			setMessage("Error while saving");
		}
		
		return 	fwdToRoleForm();
		
}
		
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
