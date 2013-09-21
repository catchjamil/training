package com.sd.training.struts2.imran;
interface Za{
	void disp();
}
interface Yb {
	void display();
}
class I {
	void disp(String a,int b){
		System.out.println("Name     " +a);
		System.out.println("roll     " +b);
	}
	void display(String c){
		System.out.println("Branch   " +c);
	}
}
public class InterfaceDemo3 {
	public static void main(String[] args){
		I obj=new I();
		obj.disp("Athar",72);
		obj.display("cse");
	}

}
