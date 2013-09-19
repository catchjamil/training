package com.sd.training.struts2.zeayul;
abstract class AbstractDemo1{
	double length;
	double wide;
	AbstractDemo1(double n,double m){
		length=n;
		wide=m;
		}
	abstract double area();
	
}
class AbstractDemo2 extends AbstractDemo1{
	AbstractDemo2(double n,double m){
		super(n,m);
	}
		double area(){
			System.out.println("Area for rectangle");
			return length * wide;
			
		}
	
}
class AbstractDemo3 extends AbstractDemo1{
	AbstractDemo3(double n,double m){
		super(n,m);
	
}
	double area(){
		System.out.println("Area for rectangle2");
		return length * wide/2;
		}
	}
public class abstractDemo {
	public static void main(String arg[]){
		//AbstractDemo f = new AbstractDemo();//
		AbstractDemo2 obj = new AbstractDemo2(4,5);
		AbstractDemo3 obj1 = new AbstractDemo3(5,5);
		AbstractDemo1 f;
		f=obj;
		System.out.println("Area is" +f.area());
		f= obj1;
		System.out.println("Area is" +f.area());
		
	}

}
