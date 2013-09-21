package com.sd.training.struts2.imran;
class Override{
	int i,j;
	Override(int a,int b){
		i=a;
		j=b;
	}
	void method(){
		System.out.println("The Answer is " +i+ " " +j);
	}
}
class D extends Override{
int k;
	D(int a ,int b, int c) {
		super(a, b);
		k=c;
	}
	void method(){
		System.out.println("k is " +k);
	}
}
public class SuperDemo {
	public static void main(String[] args){
		Override obj1=new Override(5,10);
		obj1.method();
	}
}
