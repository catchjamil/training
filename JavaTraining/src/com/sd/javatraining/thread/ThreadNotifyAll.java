package com.sd.javatraining.thread;

 class Interviewers extends Thread{
	 
	 private boolean resultAnnounced = false;
	 public boolean isResultAnnounced() {
		return resultAnnounced;
	}

	public void setResultAnnounced(boolean resultAnnounced) {
		this.resultAnnounced = resultAnnounced;
	}

	Interviewers(){
		 System.out.println("Constructor called");
	 }
	 
	@Override
	public void run() {
		System.out.println("checking papers...");
		synchronized (this) {
			this.notifyAll();
			setResultAnnounced(true);
		}
	}
}
 
 class Candiates extends Thread{
	 Interviewers interviewer;
	 Candiates(Interviewers interviewer){
		 this.interviewer = interviewer;
	 }
	 @Override
	public void run() {
		 System.out.println("Paper submitted");
		 System.out.println("Waiting for result...");
		 synchronized (interviewer) {
			try {
				if(!(interviewer.isResultAnnounced())){
					interviewer.wait();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Result Announced");
		}
		 
	}
		
}

public class ThreadNotifyAll {
	public static void main(String[] args) {
		Interviewers interviewer = new Interviewers();
		Candiates candiate1 = new Candiates(interviewer);
		Candiates candiate2 = new Candiates(interviewer);
		Candiates candiate3 = new Candiates(interviewer);
		candiate1.start();
		candiate2.start();
		candiate3.start();
		interviewer.start();
		candiate3.start();
		//synchronized (interviewer) {
			
		//}
		
		
	}
}
