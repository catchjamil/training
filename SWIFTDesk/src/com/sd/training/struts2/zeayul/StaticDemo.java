package com.sd.training.struts2.zeayul;

class StaticDemo1{
	int x=0;
	static int y=0;
	void setX(int n){
		x=n;
		}
	void setY(int n){
		y=n;
	}
	int getX(){
		return x;
	}
	int getY(){
		return y;
	}
	
}
  class StaticDemo {
	public static void main(String arg[]){
		StaticDemo1 obj = new StaticDemo1();
		StaticDemo1 obj1 = new StaticDemo1();
		obj.setX(10);
		obj1.setX(20);
		System.out.println("instance varible of object1="+obj.getX());
		System.out.println("instance varible of object2="+obj1.getX());
		System.out.println("instance varible ="+StaticDemo1.y);
		StaticDemo1.y=30;
		System.out.println("changes value of varible y ="+obj.getY());
		System.out.println("changes value of varible y through class =" +StaticDemo1.y);
		obj1.setY(StaticDemo1.y+10);
		System.out.println("changes value of varible y by object2 ="+obj1.getY());
		
	}

}
