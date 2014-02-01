package com.sd.training.struts2.ish;
enum type{
	call,email,sms(24);
	type(int s){
		System.out.println(s);
	}
	type(){
		
	}
	static void disp(int a){
		System.out.println(a);
	}
}

public class EnumDemo {
	public static void main(String args[]){
		System.out.println(type.call);
		type.disp(7);
		
	}
}
