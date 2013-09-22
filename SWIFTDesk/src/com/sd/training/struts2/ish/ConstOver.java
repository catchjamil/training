package com.sd.training.struts2.ish;

class Const1{
	Const1(char i){
		System.out.println("Non Parametrized");
	}
	Const1(int a){
		System.out.println("Parametrized"+a);
	}
	Const1(){
		
	}
}
class Const2 extends Const1{
	Const2(int x){
		//super();//It is default in Constructor;
		System.out.println(x);
	}
}
public class ConstOver {
	public  static void main(String[] args){
		//Const1 cob1=new Const1();
		//Const1 cob2=new Const1(9);
		new  Const2(5);
	}
}
