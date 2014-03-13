package com.sd.bts.action;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.sd.bts.security.licence.LicenseDetails;
import com.sd.bts.security.licence.ValidateLicenseKey;
import com.sd.bts.utils.Constrains;


public class BrainMain extends JFrame implements ActionListener {
	
	Container con;
	JMenuBar menubar=new JMenuBar();
	JMenu file=new JMenu("File");
	JMenu process=new JMenu("Process");
	JMenu help=new JMenu("Help");
	static JMenuItem login=new JMenuItem("Login");
	static JMenuItem exit=new JMenuItem("Exit");
	static JMenuItem registerPatients=new JMenuItem("RegisterPatients");
	static JMenuItem tumorIdentification=new JMenuItem("TumorIdentification");
	static JMenuItem reports=new JMenuItem("Testimony");
	static JMenuItem about=new JMenuItem("About");
    JPanel panel;
	
	
	
	public BrainMain() {
		
		    Image titleImage=Toolkit.getDefaultToolkit().getImage("logo.jpg");
		
		    panel=new JPanel()
		    {
			Image panelImage=Toolkit.getDefaultToolkit().getImage("PanelImage.gif");
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(panelImage, 0,0, this.getWidth(), this.getHeight(),this);
			}
			
		    };
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		con=getContentPane();
		setTitle("Brain Tumor Segmentation");
		setIconImage(titleImage);
	    con.setLayout(null) ;
	    con.add(panel);
	    panel.setLayout(null);
	    con.setBackground(Color.gray);
	    menubar.setBackground(Color.white);
	    login.setBackground(Color.white);
	    exit.setBackground(Color.white);
	    registerPatients.setBackground(Color.white);
	    tumorIdentification.setBackground(Color.white);
	    reports.setBackground(Color.white);
	    about.setBackground(Color.white);
	    setJMenuBar(addMenuBar());
	    panel.setBounds(150, 100, 400, 300);
	    setBounds(150, 50, 700, 600);
	    setVisible(true);
	    
	    login.addActionListener(this);
	    exit.addActionListener(this);
	    registerPatients.addActionListener(this);
	    tumorIdentification.addActionListener(this);
	    reports.addActionListener(this);
	    about.addActionListener(this);
	    
	    registerPatients.setEnabled(false);
	    tumorIdentification.setEnabled(false);
	    reports.setEnabled(false);
	    about.setEnabled(false);
	    
	
	}

	
	public JMenuBar addMenuBar()
	{
		
		
		menubar.add(file);
		menubar.add(process);
		menubar.add(help);
		
		file.add(login);
		file.add(exit);
		process.add(registerPatients);
		process.add(tumorIdentification);
		process.add(reports);
		help.add(about);
		return menubar;
	}
   public void actionPerformed(ActionEvent event)
   {
	   
	   
	   if(event.getActionCommand()=="Login")
	   {
		   new Login();
	   }
	   
	   
	   if(event.getActionCommand()=="Exit")
	   {
		   System.exit(0);
	   }
	   if(event.getActionCommand()=="RegisterPatients")
	   {
		   new PatientDetails();
	   }
	   if(event.getActionCommand()=="TumorIdentification")
	   {
		   new TumorIdentification();
	   }
	   
	   if(event.getActionCommand()=="Testimony")
	   {
		  new ResultTable();
	   }
	   
	   if(event.getActionCommand()=="About")
	   {
		  URL img = getClass().getResource("author.jpg");
		  String imagesrc = "<img src=\"" + img + "\" width=\"323\" height=\"185\">";
		  String message ="\n\t\t\tTumor segmentation\nfrom MRI data is an important but time consuming manual task\n" +
		  		" performed by medical experts. Automating this process is challenging due\n" +
		  		"to high diversity in appearance of tumort issue among different patients and," +
		  		" in many\ncases, similarity with normal tissue.\n\n" +
		  		"Author's are \n" +
		  		"1.Raj\n" +
		  		"2.Raj\n" +
		  		"3.Raj\n" +
		  		"4.Raj\n\n\n";
		  JOptionPane.showMessageDialog(this,"<html><center>\t" + imagesrc + "<br>" + message); 
	   }
   }
	public static void main(String[] args) {
		if(authenticateLicence()){
			new BrainMain();
		}else{
			new LicenceForm();
		}
		
       
	}
	
static public boolean authenticateLicence(){
		
		ObjectInputStream objectinputstream = null;
		 try {
		        FileInputStream streamIn = new FileInputStream(Constrains.LICENSE_KEY_APPROVED_FILE_PATH);
		        objectinputstream = new ObjectInputStream(streamIn);
		        
		        LicenseDetails licenseDetails = (LicenseDetails) objectinputstream.readObject();
		                   
		        
		        if(licenseDetails.getApprovedDate().compareTo(new Date()) < 0){
		        	return false;
		        }
		        
		      
		   } catch (Exception e) {

		        e.printStackTrace();
		        return false;
		   }finally {
		        if(objectinputstream != null){
		            try {
						objectinputstream .close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return false;
					}
		         } 
		   }
		 return true;
	}
	


}
class LicenceForm extends JFrame implements ActionListener {
    
	
	String selectefile = null;
	Container con;
	JPanel panel=new JPanel();
	JLabel licenceLbl=new JLabel("Upload Licence Key file:");
	JButton browse=new JButton("Browse");
	JButton submit=new JButton("Submit");
	JButton exit=new JButton("Exit");
	
	public LicenceForm() {
		
		Image titleImage=Toolkit.getDefaultToolkit().getImage("logo.jpg");
		con=getContentPane();
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Brain Tumor Segmentation");
		setBounds(400, 300, 600, 200);
		setIconImage(titleImage);
	    con.setLayout(null) ;
	    con.add(panel);
	    panel.setLayout(null);	
	    panel.setBounds(15,10, 550, 140);
	    panel.setBorder(new TitledBorder("Licence Page"));
	    panel.setBackground(Color.lightGray);
	    
	    panel.add(licenceLbl);
	    panel.add(browse);
	    panel.add(submit);
	    panel.add(exit);
	    
		Font font=new Font("Bookman Old Style",1,15);
	   
		licenceLbl.setBounds(25, 40, 150, 40);
		browse.setBounds(225, 45, 125, 25);
	    submit.setBounds(150, 80, 125, 40);
	    exit.setBounds(300, 80, 125, 40);
	    
	    licenceLbl.setFont(font);
	    browse.setFont(font);
	    submit.setFont(font);
	    exit.setFont(font);
	    
	    submit.setBorder(BorderFactory.createLineBorder(Color.black, 5));
	    exit.setBorder(BorderFactory.createLineBorder(Color.black, 5));
	    setVisible(true);
	    
	    browse.addActionListener(this);
	    submit.addActionListener(this);
	    exit.addActionListener(this);

	
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		

		if(event.getActionCommand()=="Submit")
		{
			
			if(ValidateLicenseKey.generateApprovedFile(selectefile)){
				JOptionPane.showMessageDialog(this ,"Licence File Approved");
			}else{
				JOptionPane.showMessageDialog(this ,"Licence File is not Valid");
			}
			
		}
		if (event.getActionCommand() == "Browse") {
			JFileChooser brainImageChooser = new JFileChooser();
			brainImageChooser.showOpenDialog(this);
			File selectedFile = brainImageChooser.getSelectedFile();
			System.out.println("___________" + selectedFile.getAbsolutePath());
			selectefile = selectedFile.getAbsolutePath();
					
		}

		if(event.getActionCommand()=="Exit")
		{
			System.exit(0);
		}
	
		
	}
	
	
}