package com.sd.training.struts2.imran;
class Box{
int a,b,c;
	Box(int a,int b,int c){
		this.a=a;
		this.b=b;
		this.c=c;
	}
	void display(){
		System.out.println("a b & c is " +a+ " " +b+ " " +c);
	}
}
public class ConstructorDemo {
	public static void main(String[] args){
		Box obj=new Box(1,2,3);
		obj.display();
	}
	
}
