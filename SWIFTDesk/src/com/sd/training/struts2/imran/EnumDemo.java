package com.sd.training.struts2.imran;
enum Demo{
	try1("imran"),try2("zeayul"),try3("ish");

	Demo(String a){
		System.out.println("try3    " +a);
	}
	void method(int b){
		System.out.println(b);
	}
}

class EnumDemo{
	public static void main(String[] args){
		System.out.println(Demo.try1);
		
	}
}
