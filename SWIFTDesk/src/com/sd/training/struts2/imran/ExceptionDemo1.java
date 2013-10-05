package com.sd.training.struts2.imran;
class  ExceptionDemo1{
	static void demo(){
		try{
			throw new NullPointerException("Demo");
		}catch(NullPointerException e){
			System.out.println("caught inside method");
			throw e;
		}
	}

public static void main(String[] args){
		try{
			demo();
		}catch(NullPointerException e){
			System.out.println("Recaught : " +e);
		}
    }
}
	


