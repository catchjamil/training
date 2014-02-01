package com.sd.training.struts2.ish;

public class Shape {
	public void calArea() {
		
	}

	public static void main(String[] args) {
		Circle s=new Circle();
		s.calArea(5);
	}
}

class Circle extends Shape{
	
	public void calArea(int a) {
		double area= 2*3.14*a;
		System.out.println(area);
	
	}
}

class Triangle extends Shape{

	public void calArea(int l, int b) {
		int area= l*b;
	}
}
class Square extends Shape{
	public void calArea(int a) {
		int area=a*a;
	}
}

