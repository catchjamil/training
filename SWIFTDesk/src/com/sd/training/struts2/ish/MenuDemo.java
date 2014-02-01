package com.sd.training.struts2.ish;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MenuDemo implements ActionListener{
	MenuItem item1,item2,item3,item4;
	JFrame frm1;
	MenuDemo(){
		JFrame frm=new JFrame("Menu Demo");
		frm.setSize(400,400);
		frm.setLayout(null);
		//Container c=frm.getContentPane();
		//c.setBackground(Color.orange);
		MenuBar  mbar=new MenuBar();
		Menu  file=new Menu("File");
		frm.setMenuBar(mbar);
		Menu open=new Menu("Open");
		MenuItem a111;
		open.add(a111=new MenuItem("one"));
		file.add(open);
		//MenuItem item1,item2,item3;
		file.add(item1=new MenuItem("new"));
		file.add(item2=new MenuItem("open"));
		file.add(item3=new MenuItem("close"));
		file.add(item4=new MenuItem("Exit"));
		mbar.add(file);
		Menu edit=new Menu("Edit");
		MenuItem  item4,item5,item6;
		edit.add(item4=new MenuItem("copy"));
		edit.add(item5=new MenuItem("paste"));
		edit.add(item6=new MenuItem("cut"));
		mbar.add(edit);
		Menu project=new Menu("Project");
		MenuItem item7,item8,item9;
		project.add(item7=new MenuItem("Open Project"));
		project.add(item8=new MenuItem("Close Project"));
		project.add(item9=new MenuItem("Property"));
		mbar.add(project);
		Menu sub=new Menu("Extra");
		MenuItem a1,a2,a3;
		sub.add(a1=new MenuItem("work space"));
		sub.add(a2=new MenuItem("project"));
		sub.add(a3=new MenuItem("hierarchy"));
		file.add(sub);
		file.setFont(new Font ("ARIAL",Font.BOLD,15));
		edit.setFont(new Font("ALGERIAN",Font.BOLD,15));
		project.setFont(new Font("ELEPHANT",Font.BOLD,15));
		item1.addActionListener(this);
		item4.addActionListener(this);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==item1){
				JFrame frm1=new JFrame("Menu Demo");
				frm1.setSize(400,400);
				frm1.setVisible(true);
			}
			else if(e.getSource()==item4){
				String str="";
				str="you have selected exit";
				
			}
		}
	public static void main(String[] args){
		new MenuDemo();
	}
}

