package com.sd.training.struts2.zeayul;

class Person {
	 private int id;
	 private String name;
     Person(int dd,String nn){
	    	 id = dd;
	    	 name = nn; 
		 }
	 void persondetail(){
		 System.out.println("person id=" +id);
		 System.out.println("person Namre=" +name);
		 
	 }
	
	
}
class Employee extends Person{
	private double salary;
	Employee(int g,String l,double sal){
		super(g,l);
		salary = sal;
		}
	void empDetail(){
		System.out.println("salary="+salary);
		
	}
	
}

   class EmpDemo{
	public static void main(String arg[]){
		Employee e1 = new Employee(104,"Imran",70000.00);
		Employee e2 = new Employee(105,"Istiyak",80000.00);
		e1.persondetail();
		e1.empDetail();
		System.out.println();
		e2.persondetail();
		e2.empDetail();

		
		
		
	}
}
