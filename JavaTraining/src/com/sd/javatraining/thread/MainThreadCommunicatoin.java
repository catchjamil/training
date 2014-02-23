package com.sd.javatraining.thread;


class Interviewer extends Thread{
	private boolean resultAnnouced = false;
	public boolean isResultAnnouced() {
		return resultAnnouced;
	}
	public void setResultAnnouced(boolean resultAnnouced) {
		this.resultAnnouced = resultAnnouced;
	}
	@Override
	public void run() {
	  System.out.println("Checking papers");
	  synchronized (this) {
		this.notifyAll();
		setResultAnnouced(true);
		System.out.println("Result is announced");
	}
	}
}

class Candidate extends Thread{
	Interviewer interviewer;
	Candidate(Interviewer interviewer){
		this.interviewer = interviewer;
		System.out.println("Interviewer");
	}
	@Override
	public void run() {
	System.out.println("submmiting paperts");
	System.out.println("Waiting for result...");
	synchronized (interviewer) {
		try {
			if(!(interviewer.isResultAnnouced()))
			interviewer.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Recieved Result");
	}
	}
	
}

public class MainThreadCommunicatoin {
	public static void main(String[] args) {
		Interviewer interviewer = new Interviewer();
		Candidate candidate1 = new Candidate(interviewer);
		Candidate candidate2 = new Candidate(interviewer);
		Candidate candidate3 = new Candidate(interviewer);
		candidate1.start();
		candidate2.start();
		candidate3.start();
		interviewer.start();
		
	}

}
