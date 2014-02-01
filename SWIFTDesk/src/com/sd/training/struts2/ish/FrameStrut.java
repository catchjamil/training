package com.sd.training.struts2.ish;
import javax.swing.*;

import java.awt.*;

public class FrameStrut extends JFrame {
	String cities[]={"Delhi","Mumbai","Nadraganj","Amsara","Nawadi","dariyaganj","xyz","America","Dhuj","Fridabad"};
	JList list;
	JScrollPane pane;
	FrameStrut(){
		list=new JList(cities);
		pane=new JScrollPane(list);
		JButton btn=new JButton("ok");
		add(btn);
		JTextField txt=new JTextField(20);
		add(txt);
		add(pane);
	}

	public static void main(String[] args){
		FrameStrut frm=new FrameStrut();
		frm.setLayout(new FlowLayout());
		frm.setSize(600, 500);
		frm.setVisible(true);
	}
}
