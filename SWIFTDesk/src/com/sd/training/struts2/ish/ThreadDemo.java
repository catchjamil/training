package com.sd.training.struts2.ish;
//implementing Runnable, many threads can share the same object instance

public class ThreadDemo implements Runnable {

   public void run() {
   
      Thread t = Thread.currentThread();
      System.out.print(t.getName());
      //checks if this thread is alive
      System.out.println(", status = " + t.isAlive());
   }

   public static void main(String args[]) throws Exception {
   
      Thread t = new Thread(new ThreadDemo());
      t.start();
      t.join();
      System.out.print(t.getName());
      System.out.println(", status = " + t.isAlive());
   }
} 