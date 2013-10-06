package com.sd.training.struts2.zeayul;

enum Demo{
	test1(50,90,"Good") ,test2(77,99,"Better"), test3(99,88,"Best");
	Demo(int a ,int b,String c){
		
		System.out.println("Hallo A " + a +"  Hello B "+b+"YOU Both r  "+c);
	}
	 void type(int b){
		System.out.println(b);
	}
}

public class EnumDemo {
	public static void main(String[] args){
		//enum obj = new enum();
		//obj.type(40);
		System.out.println(Demo.test1);
	}

}
