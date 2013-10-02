package com.sd.training.struts2.zeayul;

public class ExcepDemo2{
 
	public static void main(String args[]) throws InterruptedException
	{
		try{
			System.out.println("start");
			int a=6;
			int b=0;
			int c=a/b;
			
			throw new InterruptedException("hi how r u");
			//System.out.println("hello");
		}
		catch(Exception e){
			System.out.println("end");
		}
	}
	
}
