package com.sd.training.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class TileAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String Welcome()
	{
		return "welcome";
	}
	
	public String loginForm()
	{
		return "loginForm";
	}

}
