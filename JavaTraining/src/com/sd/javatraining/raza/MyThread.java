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
			
		}catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("calling a.disp");
		a.disp();
	}
	synchronized void disp(){
		System.out.println("this is in SynB");
			
	}
	
}	

class Demo extends Thread{
	
	SynA synA;
	SynB synB;
	public Demo(SynA synA,SynB synB) {
		this.synA=synA;
		this.synB=synB;
	}
	
	@Override
	public void run() {
			
		synA.show(synB);
	}
}
class Demo1 extends Thread{
	
	SynA synA;
	SynB synB;
	public Demo1(SynA synA,SynB synB) {
		this.synA=synA;
		this.synB=synB;;
	}
	
	@Override
	public void run() {
			
		synB.show(synA);
	}
}


public class MyThread extends Thread{
	SynA synA=new SynA();
	SynB synB=new SynB();
	
	public MyThread() {
		Demo demo=new Demo(synA,synB);
		demo.start();
		Demo1 demo1=new Demo1(synA,synB);
		demo1.start();
		System.out.println("back in main thread");
	}
	
	public static void main(String[] args) {
		
		new MyThread();
		
	}
	
}
