package com.sd.training.struts2.imran;
class U{
	final void show(){
		System.out.println("This is Final Demo");
	}
}
class V extends U{
	//we can not extends a final declared method void show(){
		
	}

public class FinalDemo {
	public static void main(String[] args){
		U obj=new U();
		obj.show();
	}
	
}
