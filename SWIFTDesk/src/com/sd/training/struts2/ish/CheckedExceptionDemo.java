package com.sd.training.struts2.ish;

public class CheckedExceptionDemo {

	public void  handle() throws InterruptedException {
		
		System.out.println("Before sleep");
		Thread.sleep(10000);
		System.out.println("After sleep");
		
	}
	
	
	public static void main(String[] args) throws MyException {
		CheckedExceptionDemo checkedExceptionDemo = new CheckedExceptionDemo();
		try {
			checkedExceptionDemo.handle();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
