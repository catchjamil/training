package com.sd.training.struts2.ish;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.FlowLayout;

public class NewTree extends JFrame {
	JTree tree;
	JTable table;
	String str[]={"Name","Extension","ID#"};
	Object data[][]={
			{"Gail","4345","345"},
			{"Ken","3434","333"},
			{"Viviane","897","78"}
	};
	DefaultMutableTreeNode top,a,a1,a2;
	NewTree(){
		table=new JTable(data,str);
		top=new DefaultMutableTreeNode("Options");
		a=new DefaultMutableTreeNode("A");
		top.add(a);
		a1=new DefaultMutableTreeNode("A1");
		top.add(a1);
		a2=new DefaultMutableTreeNode("A2");
		top.add(a2);
		tree=new JTree(top);
		add(tree);
		add(table);
	}
	

	public static void main(String[] args){
		NewTree frm=new NewTree();
		frm.setLayout(new FlowLayout());
		frm.setSize(600, 500);
		frm.setVisible(true);
	}
}
