package com.sd.javatraining.thread;


class TestA{
	
	public synchronized void count(){
		for(int a=0; a<10; a++){
			System.out.println("Count: "+a+" Thread Name: "+Thread.currentThread().getName());
		}
	}
}

class ThreadRunner extends Thread{
	
	TestA testA;
	ThreadRunner(TestA testA){
		this.testA = testA;
	}
	
	@Override
	public void run() {
		System.out.println("start");
		testA.count();
		System.out.println("end");
	}
}

public class SynchronisationTest {
	public static void main(String[] args) {

		TestA testA = new TestA();		
		
		ThreadRunner threadRunner1 = new ThreadRunner(testA);
		ThreadRunner threadRunner2 = new ThreadRunner(testA);
		ThreadRunner threadRunner3 = new ThreadRunner(testA);
		ThreadRunner threadRunner4 = new ThreadRunner(testA);
		ThreadRunner threadRunner5 = new ThreadRunner(testA);
		threadRunner1.setName("threadRunner1");
		threadRunner2.setName("threadRunner2");
		threadRunner3.setName("threadRunner3");
		threadRunner4.setName("threadRunner4");
		threadRunner5.setName("threadRunner5");
		
		threadRunner1.start();
		threadRunner2.start();
		threadRunner3.start();
		threadRunner4.start();
		threadRunner5.start();
	}
}
