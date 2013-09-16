package com.sd.trianing.struts2.samdani;

 class Foo1 {
	
void  read(){
	System.out.println("Method of Foo");
	}


}

class  Cliper extends Foo1{
	void readBook(){
		System.out.println("Method of Foo");
		
	}
	
  public void read(){
	  System.out.println("Overrided Method of Foo");
	  
  }
	
	
}

class Foo{
	public static void main(String ar[]){
		Foo1 f=new Foo1();
		f.read();
	//	Cliper c=(Cliper) new Foo1();
		Foo1 c=new Cliper();
		c.read();
		
	}
}