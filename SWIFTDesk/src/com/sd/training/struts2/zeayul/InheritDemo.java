package com.sd.training.struts2.zeayul;
class A{
	void method(){
		System.out.println("nmdmn");
	}
}
class B extends A{
	void method(){
		System.out.println("nmdmn");
	}
}
public class InheritDemo {
	public static void main(String[] args){
		B obj=new B();
		obj.method();
	}
}
