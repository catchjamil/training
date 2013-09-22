package com.sd.training.struts2.ish;
interface int1{
	void disp();
}
/*
 * @authour:Ishtiyaque Alam
 * Written Date:
 * Modified by:N/A
 * Modified date:
 Program which represents constructor overloading
 */
class ForInt implements int1{
	public void disp(){
		System.out.println("Enter a val");
		int i=new java.util.Scanner(System.in).nextInt();
		System.out.println("implements of int1"+i);
	}
}
public class Int_faceDemo {
	public static void main(String[] arg){
		ForInt imob1=new ForInt();
		imob1.disp();
	}
}
