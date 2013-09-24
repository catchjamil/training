package com.sd.training.struts2.zeayul;
interface Area{
	int add(int a, int b);
	int sub(int x , int y);
	int mul(int k , int l);
	int divide(int d, int c);
	
}
 class InfDemo implements Area {

		public int add(int a, int b){
			 return a+b;
		 }
	public	int sub(int x, int y){
			return x-y;
			
		}
		 public int mul(int k , int l){
			return k * l;
			
		}
		 public int divide(int d, int c){
			 return d/c;
			 
		 }
		 public static void main(String arg[]){
			 InfDemo obj = new  InfDemo(); 
			 System.out.println("value after addition=" +obj.add(10,20));
			 System.out.println("value after sub=" +obj.sub(10,20));
			 System.out.println("value after mul=" +obj.mul(10,20));
			 System.out.println("value after divide=" +obj.divide(100,20));
				
				
		 }
		 }
