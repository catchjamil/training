package com.sd.trianing.struts2.samdani;



class Chair{
	
	
	protected Chair(String name){
	
		System.out.println("Parametrized construtor of"+"Chair class  "+name);
		
	}
	 Chair(){
		 //this.Chair("Sahi Chair");
		 System.out.println("Non-Parametrized construtor of"+"Chair class"); 
		
		
		
	}
	
	
	
}


class UseTestDemo extends TestDemo{
	UseTestDemo(int v){
		
	}
	UseTestDemo(){
		//this.UseTestDemo(9);
		System.out.println("How can write imidiately System.out.prinln() ");
	}
}
class TestDemo extends Chair{
	protected TestDemo(){
		
		System.out.println("Constructor of TestDmo");
	}
}
public class ConstDemo {
	public static void main(String arg[]){
		TestDemo td=new TestDemo();
	}

}
