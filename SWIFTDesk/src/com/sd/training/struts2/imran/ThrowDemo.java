package com.sd.training.struts2.imran;
class ThrowDemo{
	static void demoproc(){
		try{
			throw new NullPointerException("demo");
		}catch(NullPointerException e){
			System.out.println("caught inside demoproc");
			throw e;
		}
	}

public static void main(String[] args){
		try{
			demoproc();
		}catch(NullPointerException e){
			System.out.println("recaught"  +e);
		}
	}

	
}

