package com.sd.training.struts2.ish;

public class MultiThreadedProgram  extends Thread{

	MultiThreadedProgram(){

	}

	
	@Override
	public void run() {
		System.out.println("Java is hot, aromatic, and invigorating===>>  "+Thread.currentThread().getName());
		
	}
}

class Test{
	public static void main(String[] args) {
		MultiThreadedProgram th=new MultiThreadedProgram();
		MultiThreadedProgram th2=new MultiThreadedProgram();
		th.setName("First Thread");
		th.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		th2.setName("Second Thread");
		th2.start();

	}
}