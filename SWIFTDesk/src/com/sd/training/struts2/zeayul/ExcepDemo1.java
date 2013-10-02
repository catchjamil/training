package com.sd.training.struts2.zeayul;
class Exep1 {
	void display() throws InterruptedException
	{
	System.out.println("Start");
	throw new InterruptedException("hi i m InterruptedException");
	}
}

public class ExcepDemo1 {
	public static void main(String args[]) throws InterruptedException
	{
		Exep1 obj = new Exep1();
		try{
		obj.display();
		System.out.println("end");
		
		}
	catch(InterruptedException e){
			System.out.println(e);
		}
} 
}