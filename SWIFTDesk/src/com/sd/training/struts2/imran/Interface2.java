package com.sd.training.struts2.imran;
interface Start{
	void meth1();
	void meth2();
}
interface Start1 extends Start{
	void meth3();
}
class InterfaceDemo{
	void meth1(){
		System.out.println("implement meth1");
	}
	void meth2(){
		System.out.println("implement meth2");
	}
	void meth3(){
		System.out.println("implement meth3");
	}
}

public class Interface2 {
	public static void main(){
		InterfaceDemo obj=new InterfaceDemo();
		obj.meth1();
		obj.meth1();
		obj.meth1();
	}

}
