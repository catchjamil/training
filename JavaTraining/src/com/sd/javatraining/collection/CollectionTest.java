package com.sd.javatraining.collection;

import java.util.ArrayList;
import java.util.List;

class A{
	
	public void test(){
		System.out.println("A");
	}
}

class B extends A{
	
	
}


class C{
	
	void test(){
		System.out.println("B");
	}
}

public class CollectionTest {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stubse
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
	B b = new B();
	B b1 = new B();
	
		List<A> list= new ArrayList<A>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(b);
		list.add(b1);
for(A a : list){
	a.test();
}
	}

}
