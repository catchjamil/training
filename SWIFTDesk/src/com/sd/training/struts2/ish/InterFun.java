package com.sd.training.struts2.ish;
interface Ab{
	int a=7;
	void show();
}
interface B extends Ab{
	void disp();
}
public class InterFun implements B {
	public static void main(String args[]){
		InterFun b=new InterFun();
		int a=0;
		System.out.println(a);
		b.disp();
		b.show();
	}
	public void disp(){
		System.out.println("disp in B");
	}
	public void show(){
		System.out.println("show.. in A");
	}
}
