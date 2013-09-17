package com.sd.training.struts2.imran;

class A {
	public void mv(){}
	 void show(){
		System.out.println("a ");
		
	}
	
}
class B extends A{
	void show(){
		super.show();
		System.out.println("b");
	}
}
class C extends B{
	void show(){
		super.show();
		System.out.println("c");
	}
	
}

public class OverDemo {
		
	public static void main(String arg[]){
		//A a = new A();
		//A b = new B();
		A c = new C();
		
		
		//a.show();
		//b.show();
		c.show();
		
	}

	
}
