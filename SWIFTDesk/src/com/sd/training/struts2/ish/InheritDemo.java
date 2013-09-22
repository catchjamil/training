package com.sd.training.struts2.ish;

class Inherit1{
	void show(){
		System.out.println("Inherit1 show");
	}
	void display(){
		System.out.println("Inherit1 display");
	}
}
class Inherit2 extends Inherit1{
	void show(){
		System.out.println("inherit2 show");
	}
}
class Inherit3 extends Inherit2{
	void show(){
		System.out.println("inherit3 show");
	}
}
class Inherit4 extends Inherit3{
	void show(){
		System.out.println("inherit3 show");
	}
}
public class InheritDemo {
	public static void main(String[] args){
		Inherit1 iob1=new Inherit3();
		iob1.show();
	}
}
