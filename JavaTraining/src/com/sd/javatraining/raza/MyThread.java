package com.sd.javatraining.raza;

class SynA{
	
	
	 synchronized void show(SynB b){
		try {
			for(int i=0;i<5;i++){
				Thread.sleep(1000);
			System.out.println("show: "+i+Thread.currentThread());
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("calling b.disp");
		b.disp();
	 }
	
	 synchronized void disp(){
	
		System.out.println("this is in SynA");
	
	}
}	
class SynB{
	 synchronized void show(SynA a){
		try {
		for(int i=0;i<5;i++){
				
				Thread.sleep(1000);
			System.out.println("show: "+i+Thread.currentThread());
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("calling a.disp");
		a.disp();
	}
		 synchronized void disp(){
				
				System.out.println("this is in SynB");
			
			}
	
}	




public class MyThread extends Thread{
	SynA synA=new SynA();
	SynB synB=new SynB();
	
	public MyThread() {
		Thread thread=new Thread(this);
		thread.start();
		synA.show(synB);
		System.out.println("back in main thread");
	}
	@Override
	public void run() {
		synB.show(synA);
		System.out.println("back in thread-2");
		
	}
	public static void main(String[] args) {
		
		new MyThread();
	}
	
}
