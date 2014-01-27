package com.sd.training.struts2.raza;

public class MyThread implements Runnable {
	@Override
	public void run() {
	for (int i = 1; i<=5; i++) {
		System.out.println("Thread :" + Thread.currentThread().getName()+" "+i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}
	public static void main(String[] args) throws InterruptedException {
		 Thread thread1 = new Thread(new MyThread());
		 Thread thread2 = new Thread(new MyThread());
		 thread1.setName("one");
		 System.out.println("Thread :" + Thread.currentThread().getName()+" 1");
		 thread2.setName("two");
		 System.out.println("Thread :" + Thread.currentThread().getName()+" 2");
		 thread1.start();
		 thread2.start();
		 thread1.join();
		 System.out.println("Thread :" + Thread.currentThread().getName()+" 3");
		 System.out.println("Thread :" + Thread.currentThread().getName()+" 4");
		 System.out.println("Thread :" + Thread.currentThread().getName()+" 5");
	}
}
