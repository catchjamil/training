package com.sd.training.struts2.imran;

public class ThrowsDemo {
	static void throwOne() throws IllegalAccessException{
		System.out.println("demo");
	}
	public static void main(String[] args){
		try{
			throwOne();
		}catch(IllegalAccessException e){
			System.out.println("caught " +e);
		}
	}
}
