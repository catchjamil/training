package com.sd.training.struts2.ish;
import javax.swing.*;
import java.awt.*;
public class RadioDemo extends JFrame {
	JRadioButton b1,b2,b3;
	RadioDemo(){
		b1=new JRadioButton("A");
		b2=new JRadioButton("B");
		b3=new JRadioButton("C");
		add(b1);
		add(b2);
		add(b3);
		ButtonGroup bg=new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		
	}

	public static void main(String arg[]){
		RadioDemo demo=new RadioDemo();
		demo.setLayout(new FlowLayout());
		demo.setSize(500,600);
		demo.setVisible(true);
	}
}
