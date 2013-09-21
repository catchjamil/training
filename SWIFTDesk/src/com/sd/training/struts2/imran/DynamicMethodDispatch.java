package com.sd.training.struts2.imran;
class J{
	void callme(){
		System.out.println("Inside j is callme method");
	}
}
class K extends J{
	void callme(){
		System.out.println("Inside k is callme method");
	}
}
class L extends J{
	void callme(){
		System.out.println("Inside l is callme method");
    }
}	
	
  class DynamicMethodDispatch {
	public static void main(String[] args){
		J obj1=new J();
		K obj2=new K();
		L obj3=new L();
		J r;
		r=obj1;
		r.callme();
		r=obj2;
		r.callme();
		r=obj3;
		r.callme();
	}
 }

