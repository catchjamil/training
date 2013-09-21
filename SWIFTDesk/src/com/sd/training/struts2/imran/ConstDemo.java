package com.sd.training.struts2.imran;
class ConsDemo{
	int ConsDemo(){
		 System.out.println("hii");
		 return 0;
	}
	void show(double a,double b){
		System.out.println(+a+ " " +b);
	}
}
class ConsDemo1{
	ConsDemo1(){
		System.out.println("hell");
	}
}
public class ConstDemo {
	public static void main(String[] args){
		ConsDemo obj=new ConsDemo();
		ConsDemo1 obj1=new ConsDemo1();
		
		obj.show(1.0, 2.0);
		obj.ConsDemo();
	}
}
