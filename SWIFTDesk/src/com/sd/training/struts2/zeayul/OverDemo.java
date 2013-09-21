package com.sd.training.struts2.zeayul;

class X{
	public void mv(){}
	 void show(){
		System.out.println("a ");
		
	}
	
}
class Y extends X {
	void show(){
		super.show();
		System.out.println("b");
	}
}
class Z extends X{
	void show(){
		super.show();
		System.out.println("c");
	}
	
}

public class OverDemo {
		
	public static void main(String arg[]){
		//A a = new A();
		//A b = new B();
		X c = new Z();
		
		
		//a.show();
		//b.show();
	c.show();
		
	}

	
}
