package com.sd.bts.action;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class About extends JFrame {
Container con;
JPanel panel=new JPanel();
JLabel image=new JLabel();

	public About() {
		Image titleImage=Toolkit.getDefaultToolkit().getImage("logo.jpg");
		con=getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(110, 50, 600, 600);
		setTitle("Brain Tumor Segmentation");
		setIconImage(titleImage);
		setLayout(null);
		con.add(panel);
		panel.setLayout(null);
		panel.setBounds(0, 0, 600, 600);
		panel.add(image);
		image.setBounds(130,20, 300, 300);
		image.setIcon(new ImageIcon("author.jpg"));
		setVisible(true);
		
	}

	
	public static void main(String[] args) {
		new About();
	}

}
