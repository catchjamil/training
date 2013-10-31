package com.sd.training.struts2.zeayul;
class Ab{
	int i,j;
	Ab(int a,int b){
		i=a;
		j=b;
	}
	void show(){
		System.out.println("i and j:" + i + "  " + j);
	}
}
class Ac extends Ab{
	int k;
	Ac(int a,int b,int c){
		super(a,b);
		k=c;
		}
	void show(){
		super.show();
		System.out.println("k =" + k);
		
	}
}
public class OverDemo1 {
 
	public static void main(String xyz[]){
		Ac obj = new Ac(5,9,8);
		obj.show();
	}
}
