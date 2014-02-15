package com.sd.javatraining.thread;

class MathTest{
	
	private int addValue;
	public int getAddValue() {
		return addValue;
	}
	public void setAddValue(int addValue) {
		this.addValue = addValue;
	}
	void add(int a,int b){
		int c = a+b;
	//	System.out.println("Result... "+c);
		setAddValue(c);
	}
}

class ThreadTest extends Thread{
	MathTest mathTest;
	ThreadTest(MathTest mathTest){
		this.mathTest = mathTest;
	}
	@Override
	public void run() {
		System.out.println("Start");
		mathTest.add(4, 5);
		System.out.println("End");
		
		synchronized (mathTest) {
			mathTest.notify();
		}
		System.out.println("Notified");
	}
}

public class ThreadCommunication {
	public static void main(String[] args) {
		MathTest mathTest = new MathTest();
		ThreadTest threadTest1 = new ThreadTest(mathTest);
		
		ThreadTest threadTest2 = new ThreadTest(mathTest);
		threadTest1.start();
		threadTest2.start();
		System.out.println("Result...."+mathTest.getAddValue());
		synchronized (mathTest) {			
			try {
				System.out.println("Waiting....");
				mathTest.wait();
				System.out.println("Result...."+mathTest.getAddValue());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
	}
}
