package com.sd.bts.action;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.sd.bts.security.licence.LicenseDetails;
import com.sd.bts.security.licence.LicenseKey;

public class GenerateLicenseKey extends JFrame implements ActionListener{

	Container con;
	JPanel panel=new JPanel();
	JLabel nameLbl=new JLabel("Name");
	JLabel emailLbl=new JLabel("Eamil");
	JLabel licencePeriodLbl=new JLabel("Licence Period");
	JLabel licenseNumberLbl=new JLabel("License Number");

	JTextField nameTxt=new JTextField();
	JTextField emailTxt=new JTextField();
	JTextArea licencePeriodTxt=new JTextArea();
	JTextField licenseNumberTxt=new JTextField();
	
	JButton generate=new JButton("Generate");
	JButton exit=new JButton("Exit");

	
	
	public GenerateLicenseKey() {
		Image titleImage=Toolkit.getDefaultToolkit().getImage("logo.jpg");
		con=getContentPane();
	//	setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("License Key");
		setBounds(125, 50, 800, 600);
		setIconImage(titleImage);
	    con.setLayout(null) ;
	    con.add(panel);
	    panel.setLayout(null);	
	    panel.setBounds(15,10, 760,540);
	    panel.setBorder(new TitledBorder("License Key Detials"));
	    panel.setBackground(Color.lightGray);
	    
	    
	    panel.add(nameLbl).setBounds(100, 75, 125, 30);
	    panel.add(nameTxt).setBounds(225, 75, 125, 30);
	    panel.add(emailLbl).setBounds(100, 125, 125, 30);
	    panel.add(emailTxt).setBounds(225, 125, 125, 30);
	    panel.add(licenseNumberLbl).setBounds(100, 175, 125, 30);
	    panel.add(licenseNumberTxt).setBounds(225, 175, 125, 30);
	    
	    panel.add(licencePeriodLbl).setBounds(100, 225, 125, 30);
	    panel.add(licencePeriodTxt).setBounds(225, 225, 125, 30);
	    panel.add(generate).setBounds(100, 300, 125, 30);
        panel.add(exit).setBounds(225, 300, 125, 30);
	    
	    nameLbl.setFont(new Font("Bookman Old Style",1,14));
	    nameTxt.setFont(new Font("Bookman Old Style",1,14));
	    emailLbl.setFont(new Font("Bookman Old Style",1,14));
	    emailTxt.setFont(new Font("Bookman Old Style",1,14));
	    licencePeriodLbl.setFont(new Font("Bookman Old Style",1,14));
	    licencePeriodTxt.setFont(new Font("Bookman Old Style",1,14));
	    licenseNumberLbl.setFont(new Font("Bookman Old Style",1,14));
	    licenseNumberTxt.setFont(new Font("Bookman Old Style",1,14));
	 
	    setVisible(true);
	  
	    generate.addActionListener(this);
	    exit.addActionListener(this);
	    
	
	}
	
	
	
	public void actionPerformed(ActionEvent event)
	{
		
		try
		{
		
		if(event.getActionCommand()=="Generate")
		{
			LicenseDetails licenseDetails = new LicenseDetails();
			licenseDetails.setEmail(emailTxt.getText());
			licenseDetails.setName(nameTxt.getText());
			licenseDetails.setLicenseNumber(licenseNumberTxt.getText());
			licenseDetails.setLicensePeriod(new Integer(licencePeriodTxt.getText()));
			if(LicenseKey.generateKey(licenseDetails)){

				JOptionPane.showMessageDialog(this,	"License key is generated Successfully");
				
			}else{

				JOptionPane.showMessageDialog(this,	"License Key is not generated");
			}
			
		}
		
			if(event.getActionCommand()=="Exit")
		{
			System.exit(0);
		}
				}
		catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,	"Error While Generating Key");
		}
		
	}
	
public static void main(String[] args) {
	new GenerateLicenseKey();
}
}
