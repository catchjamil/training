package com.sd.training.struts2.imran;
class StaticDemo5{
	static int a=5;
	static int b,x;
	static void method(){
		System.out.println("x= " +x);
		System.out.println("a= " +a);
		System.out.println("b= " +b);
	}
	static{
		b=a*4;
	}

	public static void main(String[] args){
		method();
	}
}	

