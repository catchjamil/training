package com.sd.training.struts2.imran;

import com.sd.training.struts2.util.staticUtil;

public class Thread implements Runnable{
	public void run(){
		System.out.println("Thread Demo");
	}
}
	class Thread1{
	public static void main(String[] args){
		Thread obj=new Thread();
		obj.run();
		
		
	}
}
