package com.sd.bts.action;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class Login extends JFrame implements ActionListener {

	
	String Id,Password;
	Container con;
	JPanel panel=new JPanel();
	JLabel index=new JLabel("Enter the Login ID And Password");
	JLabel userid=new JLabel("Enter User ID:");
	JLabel password=new JLabel("Enter Password:");
	JTextField useridTxt=new JTextField();
	JPasswordField passwordTxt=new JPasswordField();
	JButton submit=new JButton("Submit");
	JButton exit=new JButton("Exit");
	
	
	
	
	public Login() {
		
		Image titleImage=Toolkit.getDefaultToolkit().getImage("logo.jpg");
		con=getContentPane();
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Brain Tumor Segmentation");
		setBounds(125, 50, 800, 600);
		setIconImage(titleImage);
	    con.setLayout(null) ;
	    con.add(panel);
	    panel.setLayout(null);	
	    panel.setBounds(15,10, 760,540);
	    panel.setBorder(new TitledBorder("Login Page"));
	    panel.setBackground(Color.lightGray);
	    
	    panel.add(index);
	    panel.add(userid);
	    panel.add(password);
	    panel.add(useridTxt);
	    panel.add(passwordTxt);
	    panel.add(submit);
	    panel.add(exit);
	    
		Font font=new Font("Bookman Old Style",1,15);
	   
		index.setBounds(260, 50, 350, 30);
	    userid.setBounds(250, 125, 125, 30);
	    useridTxt.setBounds(400, 125, 125, 30);
	    password.setBounds(250, 200, 175, 30);
	    passwordTxt.setBounds(400, 200, 125, 30);
	    submit.setBounds(275, 300, 125, 50);
	    exit.setBounds(425, 300, 125, 50);
	    
	    index.setFont(new Font("Bookman Old Style",1,18));
	    userid.setFont(font);
	    useridTxt.setFont(font);
	    password.setFont(font);
	    passwordTxt.setFont(font);
	    submit.setFont(font);
	    exit.setFont(font);
	    
	    submit.setBorder(BorderFactory.createLineBorder(Color.black, 5));
	    exit.setBorder(BorderFactory.createLineBorder(Color.black, 5));
	    setVisible(true);
	    
	    
	    submit.addActionListener(this);
	    exit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getActionCommand()=="Submit")
		{
			

			Id=useridTxt.getText();
			Password=passwordTxt.getText();
			
			
			if(Id.equalsIgnoreCase("admin")&& Password.equalsIgnoreCase("admin"))
			{
			
			BrainMain.registerPatients.setEnabled(true);
			BrainMain.tumorIdentification.setEnabled(true);
			BrainMain.reports.setEnabled(true);
			BrainMain.about.setEnabled(true);
			setVisible(false);
			
			}
			else
			{
				JOptionPane.showMessageDialog(this ,"Invalid Login Details");
			}
			
			
		}
		
		if(event.getActionCommand()=="Exit")
		{
			System.exit(0);
		}
	}
	
	

}
