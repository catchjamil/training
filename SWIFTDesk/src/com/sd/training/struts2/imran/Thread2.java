package com.sd.training.struts2.imran;
import javax.swing.*;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class Thread2 implements Runnable{
	public void run(){
		
	}
}
class Demo5{
	public static void main(){
		JFrame frm=new JFrame("Frame");
		frm.setLayout(new FlowLayout());
		frm.setSize(400,400);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
