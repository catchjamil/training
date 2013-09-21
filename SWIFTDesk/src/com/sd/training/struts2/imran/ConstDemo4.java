package com.sd.training.struts2.imran;
import java.util.*;
class Print{
	public double x,y;
	Print(int a,int b){
	x=a;
	y=b;
	
	}
	public void method(){
		System.out.println(+x+ " " +y);
	}
}
class DPrint extends Print{
	DPrint(int a, int b) {
		super(a, b);
	}

	public void method(){
		System.out.println(+x+ " " +y);
	}
}
public class ConstDemo4 {
	public static void main(String[] args){
		Print obj1=new Print(2,3);
		DPrint obj2=new DPrint(5,6);
		
	}

}
