class A{
	int a,b;
	void method(){
		System.out.println(+a+ " " +b);
		}
}
class B extends A{
	int c;
	void method1(){
		System.out.println(+c);
	}
	void display(){
		System.out.println("a+b+c is=  "  +(a+b+c));
	}
}
class Inheritance1{
	public static void main(String[] args){
		A obj=new A();
		B obj1=new B();
		obj.a=5;
		obj.b=10;
		obj.method();
		obj1.c=15;
		obj1.method1();
		
	}
}