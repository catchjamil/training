package com.sd.bts.action;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.sd.bts.bean.PatientRegistery;
import com.sd.bts.utils.DatabaseUtil;


public class RegisterPatients extends JFrame implements ActionListener{

	
	
	static String imagePath,Patientid,Name,Age,Address,Contactnumber,Gender,Addimitteddate,Description,Handleddoctor,Lastscanneddate,Brainimagepath,Bloodgroup,Brainimagename;
	String SplitArray[];
	Container con;
	JPanel panel=new JPanel();
	JLabel patientId=new JLabel("PatientID");
	JLabel name=new JLabel("Name");
	JLabel age=new JLabel("Age");
	JLabel address=new JLabel("Address");
	JLabel contactNumber=new JLabel("Contact Number");
	JLabel gender=new JLabel("Gender");
	JLabel addimittedDate=new JLabel("Addimitted Date");
	JLabel description=new JLabel("Description");
	JLabel handledDoctor=new JLabel("Handled Doctor Name");
	JLabel lastScannedDate=new JLabel("Last Scanned Date");
	JLabel browseImage=new JLabel("Browse Brain Image");
	JLabel bloodGroup=new JLabel("Blood Group");
	
	JTextField patientIdTxt=new JTextField();
	JTextField nameTxt=new JTextField();
	JTextField ageTxt=new JTextField();
	JTextArea addressTxt=new JTextArea();
	JScrollPane pane=new JScrollPane(addressTxt);
	JTextField contactNumberTxt=new JTextField();
	JComboBox gendetTxt=new JComboBox();
	JTextField addimittedDateTxt=new JTextField();
	JTextField descriptionTxt=new JTextField();
	JTextField handledDoctorTxt=new JTextField();
	JTextField lastScannedDateTxt=new JTextField();
	JComboBox bloodGroupTxt=new JComboBox();
	JLabel footImage=new JLabel(new ImageIcon("flowrber.gif"));
	JButton browse=new JButton("Browse");
	JButton register=new JButton("Register");
	JButton exit=new JButton("Exit");
	JButton clear=new JButton("Clear");
	JButton find=new JButton("Find");
	JButton delete=new JButton("Delete");


	
	
	public RegisterPatients() {
		Image titleImage=Toolkit.getDefaultToolkit().getImage("logo.jpg");
		con=getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Brain Tumor Segmentation");
		setBounds(110, 50, 800, 600);
		setIconImage(titleImage);
	    con.setLayout(null) ;
	    con.add(panel);
	    panel.setLayout(null);	
	    panel.setBounds(15,10, 760,540);
	    panel.setBorder(new TitledBorder("Enter The Patients Detials"));
	    panel.setBackground(Color.lightGray);
	    
	    
	    panel.add(patientId).setBounds(100, 75, 125, 30);
	    panel.add(patientIdTxt).setBounds(225, 75, 125, 30);
	    panel.add(name).setBounds(100, 125, 125, 30);
	    panel.add(nameTxt).setBounds(225, 125, 125, 30);
	    panel.add(age).setBounds(100, 175, 125, 30);
	    panel.add(ageTxt).setBounds(225, 175, 125, 30);
	    panel.add(address).setBounds(100, 225, 125, 30);
	    addressTxt.setFont(new Font("Bookman Old Style",1,14));
        panel.add(pane).setBounds(225, 225, 125, 30);
	    panel.add(contactNumber).setBounds(100, 275, 125, 30);
	    panel.add(contactNumberTxt).setBounds(225, 275, 125, 30);
	    panel.add(gender).setBounds(100, 325, 125, 30);
        panel.add(gendetTxt).setBounds(225, 325, 125, 30);
	  
        
        panel.add(addimittedDate).setBounds(400, 75, 225, 30);
	    panel.add(addimittedDateTxt).setBounds(575, 75, 125, 30);
	    panel.add(description).setBounds(400, 125, 125, 30);
	    panel.add(descriptionTxt).setBounds(575, 125, 125, 30);
	    panel.add(handledDoctor).setBounds(400, 175, 175, 30);
	    panel.add(handledDoctorTxt).setBounds(575, 175, 125, 30);
	    panel.add(lastScannedDate).setBounds(400, 225, 175, 30);
	    panel.add(lastScannedDateTxt).setBounds(575, 225, 125, 30);
	    panel.add(bloodGroup).setBounds(400, 275, 125, 30);
	    panel.add(bloodGroupTxt).setBounds(575, 275, 125, 30);
	    panel.add(browseImage).setBounds(400, 325, 175, 30);
	    panel.add(browse).setBounds(575, 325, 125, 30);
	 
	    panel.add(register).setBounds(100, 400, 100, 30);
	    panel.add(find).setBounds(225, 400, 100, 30);
	    panel.add(delete).setBounds(350,400, 100, 30);
	    panel.add(clear).setBounds(475, 400, 100, 30);
	    panel.add(exit).setBounds(600, 400, 100, 30);
	    panel.add(footImage).setBounds(130, 450, 500, 100);
	 
	    
	    patientId.setFont(new Font("Bookman Old Style",1,14));
	    patientIdTxt.setFont(new Font("Bookman Old Style",1,14));
	    name.setFont(new Font("Bookman Old Style",1,14));
	    nameTxt.setFont(new Font("Bookman Old Style",1,14));
	    age.setFont(new Font("Bookman Old Style",1,14));
	    ageTxt.setFont(new Font("Bookman Old Style",1,14));
	    address.setFont(new Font("Bookman Old Style",1,14));
	    pane.setFont(new Font("Bookman Old Style",1,14));
	    contactNumber.setFont(new Font("Bookman Old Style",1,14));
	    contactNumberTxt.setFont(new Font("Bookman Old Style",1,14));
	    gender.setFont(new Font("Bookman Old Style",1,14));
	    gendetTxt.setFont(new Font("Bookman Old Style",1,14));
	    
	    addimittedDate.setFont(new Font("Bookman Old Style",1,14));
	    addimittedDateTxt.setFont(new Font("Bookman Old Style",1,14));
	    description.setFont(new Font("Bookman Old Style",1,14));
	    descriptionTxt.setFont(new Font("Bookman Old Style",1,14));
	    handledDoctor.setFont(new Font("Bookman Old Style",1,14));
	    handledDoctorTxt.setFont(new Font("Bookman Old Style",1,14));
	    lastScannedDate.setFont(new Font("Bookman Old Style",1,14));
	    lastScannedDateTxt.setFont(new Font("Bookman Old Style",1,14));
	    bloodGroup.setFont(new Font("Bookman Old Style",1,14));
	    bloodGroupTxt.setFont(new Font("Bookman Old Style",1,14));
	    browseImage.setFont(new Font("Bookman Old Style",1,14));
	    browse.setFont(new Font("Bookman Old Style",1,14));
	    register.setFont(new Font("Bookman Old Style",1,14));
	    find.setFont(new Font("Bookman Old Style",1,14));
	    delete.setFont(new Font("Bookman Old Style",1,14));
	    clear.setFont(new Font("Bookman Old Style",1,14));
	    footImage.setFont(new Font("Bookman Old Style",1,14));
	   	    
	    
	    
	    gendetTxt.addItem("Male");
	    gendetTxt.addItem("Female");
	    
	    bloodGroupTxt.addItem("A+");
	    bloodGroupTxt.addItem("A-");
	    bloodGroupTxt.addItem("b+");
	    bloodGroupTxt.addItem("b-");
	    bloodGroupTxt.addItem("o+");
	    bloodGroupTxt.addItem("o-");
	    bloodGroupTxt.addItem("Ab+");
	    bloodGroupTxt.addItem("Ab-");

	    
	    setVisible(true);
	    browse.addActionListener(this);
	    register.addActionListener(this);
	    find.addActionListener(this);
	    delete.addActionListener(this);
	    clear.addActionListener(this);
	    exit.addActionListener(this);
	    
	
	}
	/*
	* The variable output will return one of the following values:
	* 0 ----- Indicates success.
	* 1 ----- Indicates that the SELECT statement could not find a record.
	* 2 ----- Indicates a SQLException has occurred.
	* 3 ----- Indicates a FileNotException has occurred.
	* 4 ----- Indicates a some other Exception has occurred.
	* 5 ----- Indicates an error has occurred in the finally block.
	*/
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getActionCommand()=="Browse")
		{
			JFileChooser brainImageChooser=new JFileChooser();
			brainImageChooser.showOpenDialog(this);
			imagePath=""+brainImageChooser.getSelectedFile();
			System.out.println("___________"+imagePath);
		}
		if(event.getActionCommand()=="Register")
		{
			Patientid=patientIdTxt.getText();
			Name=nameTxt.getText();
			Age=ageTxt.getText();
			Address=addressTxt.getText();
			Contactnumber=contactNumberTxt.getText();
			Gender=""+gendetTxt.getSelectedItem();
			Addimitteddate=addimittedDateTxt.getText();
			Description=descriptionTxt.getText();
			Handleddoctor=handledDoctorTxt.getText();
			Lastscanneddate=lastScannedDateTxt.getText();
			Bloodgroup=""+bloodGroupTxt.getSelectedItem();
			Brainimagepath=imagePath.replaceAll("\\\\", "/");
			SplitArray=Brainimagepath.split("/");
			for(int i=0;i<SplitArray.length;i++)
			{
				if(SplitArray[i].endsWith(".jpg")||SplitArray[i].endsWith(".png"))
				{
					Brainimagename=SplitArray[i];
				}
			}
			System.out.println(">................."+Brainimagename);
			
			int output=insertBlobData(Brainimagename,Description,Brainimagepath);
		
			System.out.println(output);
		}
		if(event.getActionCommand()=="Exit")
		{
			System.exit(0);
		}
		if(event.getActionCommand()=="Find")
		{
			System.out.println("Check");
		}
		if(event.getActionCommand()=="Delete")
		{
			System.out.println("Check");
		}
		
	}
	
	
	private static int insertBlobData(final String fileName, final String fileDescription, final String filePath) {
		
		Session session = DatabaseUtil.getSession();
		Query createQuery = session.createQuery("from PatientRegistery WHERE fileName  =" + fileName + "\' AND fileDescription=" + fileDescription);
		List list = createQuery.list();

		
		if(list == null || list.size() == 0){
			PatientRegistery patientRegistery = new PatientRegistery();
			patientRegistery.setPatientid(Patientid);
			patientRegistery.setName(Name);
		
			patientRegistery.setBrainImagePath(Brainimagepath);
			
			Transaction transaction = session.getTransaction();
			session.save(patientRegistery);
			transaction.commit();
			session.close();
			return 1;
		}

		return 2;
		
			}
	
	
	public static void main(String[] args) {
		
     new RegisterPatients();
	}
}
