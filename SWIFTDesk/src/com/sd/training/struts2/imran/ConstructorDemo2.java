package com.sd.training.struts2.imran;
class Pq{
	double a,b,c;
	Pq(Pq obj){
		a=obj.a;
		b=obj.b;
		c=obj.c;
	}
	Pq(double x,double y,double z){
		a=x;
		b=y;
		c=z;
	}
	double show(){
		return a*b*c;
	}
}
public class ConstructorDemo2 {
	public static void main(){
		Pq obj1=new Pq(2,3,4);
		Pq obj2=new Pq(3,4,5);
	}
}
