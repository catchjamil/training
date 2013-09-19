package com.sd.training.struts2.zeayul;

class Animal {

		   public void move(){
		      System.out.println("Animals can move");
		   }
}
		class Dog extends Animal{

		   public void move(){
		      System.out.println("Dogs can walk and run");
		   }
		}

	     class TestDog{

		   public static void main(String args[]){
		      Animal a = new Animal();
		      Dog b = new Dog(); 

		      a.move();

		      b.move();
		   }
		}


