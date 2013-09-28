package com.sd.training.struts2.zeayul;

class StatArea{
	static int area;
	static int computeArea(int width, int length){
		return area=width*length;
		
	}
}
public class StaticDemoM {
	public static void main(String arg[]){
		System.out.println("Area of the static method=" +StatArea.computeArea(10,10));
		
	}

}
