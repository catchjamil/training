package com.sd.training.struts2.imran;

class Q{
	int a,b;
	void method(){
		System.out.println("value is " +a+ " " +b);
	}
}
class R extends Q{
	int c,d;
	void method(int c,int d){
		System.out.println("value is " +c+ " " +d);
	}
	
}
public class InheritanceDemo {
	public static void main(String[] args){
		Q obj5=new Q();
		R obj6=new R();
		obj5.method();
		obj6.method();
		
		
		
	}
}
