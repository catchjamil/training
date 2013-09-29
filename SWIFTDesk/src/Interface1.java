interface Int{
	void method();
}
class  F implements Int{
	public void method(){
		
		System.out.println("ok");
	}
	public void method1(int b){
		System.out.println(b);
	}
	
	
}
class G implements Int{

	public static void main(String[] args){
		//Int  obj;
		F obj1=new F();
		G obj2=new G();
		//obj1.b=5;
		obj1.method();
		obj2.method();
		//obj.method1();
	}
	

	public void method(){
		System.out.println("not ok");
	}
}
class Interface1{}


