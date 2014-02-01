package com.sd.training.struts2.ish;

/*
 * 
 */
class MyException extends Exception{
	
	public MyException() {
	
	}
	
	public String  stringNOtEqual() {
		return " The String entered is not equal";
		
	}
	

	public String  noNOtEqual() {
		return " The entered number is not equal";
		
	}
	
	
	public String toString(){
		return "Exception caught in  CheckedExceptionDemo.handle()";
	}
	
	
	
}



public class ExceptionDemo {
	
	public void   equalNO(int a, int b) {
		try {
			
			if(a!=b){
				throw new MyException();
			}
			
		} catch (MyException e) {     ///MyException e=new MyException();
		 System.out.println(e.noNOtEqual());
		}
		
	}
	
	public void   equalString(String str1, String str2) {
		try {
			
			if(!str1.equals(str2)){
				throw new MyException();
			}
			
		} catch (MyException e) {     ///MyException e=new MyException();
		 System.out.println(e.stringNOtEqual());
		}
		
	}

	
	public static void main(String[] args) {
		ExceptionDemo demo = new ExceptionDemo();
		demo.equalNO(4, 5);
		demo.equalString("Ishtiyaque", "Ishtiyaqu");
	}
}

