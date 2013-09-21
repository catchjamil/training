package com.sd.training.struts2.imran;
abstract class M{
	abstract void method();
	void method1(){
		System.out.println("Ruscle");
	}
}
class N extends M{
	void method(){
		System.out.println("This is It");
	}
}
public class AbstractDemo {
	public static void main(String[] args){
		N obj=new N();
		obj.method();
		obj.method1();
	}
}
