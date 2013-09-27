package com.sd.training.struts2.imran;
	class Demo1{
		int roll;
	static	String name;
		
	Demo1(String n,int r){
		roll=r;
		name=n;
	}
	void display(){
		System.out.println("The Answer is  " +roll+ " " +name);
	}
}	
public class StaticDemo {
	public static void main(String[] args){
		Demo1 obj=new Demo1("imran",83);
		obj.display();
			
			
	}
}
