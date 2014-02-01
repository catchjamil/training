package com.sd.training.struts2.ish;

class Demo1{
	 Demo1(){
		System.out.println("Demo1");
		//return;
	}
	float  team(int a, int b){
		System.out.println(a+" "+b);
		return 4;
	}
}
class Demo2{
	Demo2(){
		System.out.println("Demo2");
	}
}
public class Con1 {
	public static void main(String args[]){
		Demo1 ob1=new Demo1();
		Demo2 ob2=new Demo2();
		
		//ob1.team(7,8);
		//ob1.Demo1();
	}
}
