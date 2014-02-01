package com.sd.training.struts2.ish;

public class Swapping {
	public Swapping(){
		
	}
	
	public  void swap(Swapp obj) {
		int temp = obj.a;
		obj.a=obj.b;
		obj.a=temp;
		System.out.println("a= "+ obj.a+" b= "+obj.b);
		
	}
	
}

class  Swapp{
	static int a=8;
	static int b=9;
	Swapp(int a,int b){
		
	}
	
	public static void main(String[] args) {
		
		Swapping swapp = new Swapping();
		Swapp obj = new Swapp(a,b);
		swapp.swap(obj);
	}
}