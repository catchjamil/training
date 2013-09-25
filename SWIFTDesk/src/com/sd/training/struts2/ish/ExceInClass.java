package com.sd.training.struts2.ish;

class Exc1{
	
	void disp(){
		try{
			int a=9/0;
		
		
		}catch(ArithmeticException e){
			System.out.println(e.getMessage());
		}
	}
}
class Exc2{
	void show(){
		try{
			//System.out.println("");
			int []ch=new int[45];
			ch[70]=90;
			System.out.println(ch);
		}catch(IndexOutOfBoundsException er){
			System.out.println(er.getMessage());
		}
		finally{
			System.out.println(" any candition,finally is run");
		}
		
	}
}
class Exc3{
	Exc3(String a[]){
		int l=a.length;
		int []v=new int[5];
		//int no=Integer.parseInt();
		try{
			if(l==0){
				int c=42/0;
			}
			else{
				v[24]=9;
			}
			
		}catch(IndexOutOfBoundsException ee){
			System.out.println("arrayoutofbounds");
		}catch(ArithmeticException er){
			System.out.println("arithmetic exception");
		}finally{
			System.out.println("Finally");
		}
	}
}
class ExceInClass{
	public static void main(String  args[]){
	
		new Exc1();
		new Exc2();
		new Exc3(args);
		//System.out.println(args[0]);
		//eob1.disp();
		//eob2.show();
	}
}