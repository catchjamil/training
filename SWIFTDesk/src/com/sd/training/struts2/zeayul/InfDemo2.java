package com.sd.training.struts2.zeayul;

interface inf1{
	void display();
}
class Two1 implements inf1{
	public void display(){
	System.out.println("this is interface");
	
	}
}
    class InfDemo2 {
	public static void main(String arg[]){
		Two1 obj = new Two1();
		obj.display();
		
	}
	

}
