package com.sd.training.struts2.ish;

class InhertFun {
	public static void main(String[] args){

		//C c=new C();
		System.out.println("Befor down casting ");
		//i.display();
		A a =new C();
		a.display();
		System.out.println("After down casting ");
		A a2=new C();
		
	//	C c=new A();
		
		((C)a2).Show();
	
	}
}

class A {
	void display(){
		
				//if j==Character.UPPERCASE_LETTER;
		System.out.println("class A");
	}
}

class C extends A{
	void Show(){
		System.out.println("class C");
	}
}


