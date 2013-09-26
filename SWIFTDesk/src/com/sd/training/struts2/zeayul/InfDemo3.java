package com.sd.training.struts2.zeayul;

interface inf2{
	void display();
}
interface inf3{
	void show();
	
}
class InfDem implements inf2,inf3{
	public void display(){
		System.out.println("display method");
	}
	public void show(){
		System.out.println("show method");
}
}
public class InfDemo3 {
	public static void main(String arg[]){
		
		InfDem obj = new InfDem();
		obj.display();
		obj.show();
	} 
		
	}


