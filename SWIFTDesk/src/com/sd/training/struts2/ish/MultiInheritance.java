package com.sd.training.struts2.ish;

public class MultiInheritance extends MyClass implements MyInterface,MyInterface2{

	//@Override
	public void show() {
		System.out.println("Method of MyInterface");
		
	}

	//@Override
	public void read() {
		System.out.println("Method of MyInterface2");
		
	}
	//@Override
	void takeValue() {
		super.takeValue();
		System.out.println("overrided Method of MyClass");
	}
	
	public static void main(String[] args) {
		MultiInheritance inheritance = new MultiInheritance();
		inheritance.show();
		inheritance.read();
		inheritance.takeValue();
	}

}


interface MyInterface{
	void show();
}
interface MyInterface2{
	void  read();
}

class MyClass{
	void takeValue(){
		System.out.println("Method of SupperClass MyClass");
	}
}