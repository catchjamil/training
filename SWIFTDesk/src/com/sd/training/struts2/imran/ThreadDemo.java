package com.sd.training.struts2.imran;

import java.io.InterruptedIOException;

public class ThreadDemo {
	public static void main(String[] args){
		ThreadDemo t=new ThreadDemo();
		System.out.println("current thread" +t);
		t.setName("My Thread");
		System.out.println("After the change" +t);
		try{
			for(int n=5; n>0; n--){
				
			}
		}catch(InterruptedException e){
			System.out.println("main thread interrupted");
		}
		
	}

	
		
	
}
