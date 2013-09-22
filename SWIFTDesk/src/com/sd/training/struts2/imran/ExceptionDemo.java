package com.sd.training.struts2.imran;

public class ExceptionDemo {
	public static void main(String[] args){
		int d,a;
		try{
			d=0;a=42/d;
			System.out.println("Exception demo");
		}catch(ArithmeticException e){
			System.out.println("Division by zero");
		}
		System.out.println("Final statement");
	}
}
