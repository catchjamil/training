package com.sd.training.struts2.imran;

public class ThrowsDemo1 {
	static void throwOne() throws IllegalAccessException{
		System.out.println("Inside throwOne");
		throw new IllegalAccessException("demo");
	}
	public static void main(String[] args){
		try{
			throwOne();
		}catch(IllegalAccessException e){
			System.out.println("caught "  +e);
		}
	}
}
