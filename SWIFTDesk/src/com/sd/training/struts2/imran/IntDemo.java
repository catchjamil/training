package com.sd.training.struts2.imran;
class Z{
	int i;
	private int j;
	void sop(int x,int y){
		i=x;
		j=y;
	}
}
class Y extends Z{
	void sum(){
		System.out.println("The Answer is " +i);
	}
}
public class IntDemo {
	public static void main(){
		Z obj1=new Z();
		Y obj2=new Y();
		obj1.sop(5,10);
	}

}
