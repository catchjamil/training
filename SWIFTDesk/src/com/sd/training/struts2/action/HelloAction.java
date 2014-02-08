package com.sd.training.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String helloTextFiled;
	
	public String getHelloTextFiled() {
		return helloTextFiled;
	}
	public void setHelloTextFiled(String helloTextFiled) {
		this.helloTextFiled = helloTextFiled;
	}
	public String execute() {
		System.out.println("Hi: "+getHelloTextFiled());
		return "helloForm";
	}
}
