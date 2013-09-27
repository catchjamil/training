package com.sd.training.struts2.imran;
class Zoom{
	static int roll;
	static String name;
	Zoom(int r,String n){
		roll=r;
		name=n;
	}
	static void show(){
		System.out.println("Output is  "  +roll+ " " +name);
	}
}
public class StaticDemo2 {
	public static void main(String[] args){
		Zoom obj=new Zoom(81,"zeayul");
		obj.show();
	}

}
