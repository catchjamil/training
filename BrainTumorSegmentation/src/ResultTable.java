import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import oracle.jdbc.driver.OracleDriver;

//import com.sun.media.ui.ComboBox;


public class ResultTable extends JFrame implements ActionListener {

	String query,option,result,id,name;
	int i=0;
	Container con;
	JTable table;
	JPanel panel=new JPanel();
	DefaultTableModel defaultTableModel;
	JScrollPane scroll;
	JTableHeader header=new JTableHeader();
	JComboBox combo=new JComboBox();
	JButton submit=new JButton("Submit");
	JButton exit=new JButton("Exit");
	JLabel imageLable=new JLabel();
	String col[]={"Patient Id"," Name"};
	
	public ResultTable() {
		
		
		defaultTableModel=new DefaultTableModel(null,col);
		table=new JTable(defaultTableModel);
		table.setModel(defaultTableModel);
		scroll=new JScrollPane(table);
		   
		Image titleImage=Toolkit.getDefaultToolkit().getImage("logo.jpg");
		con=getContentPane();
	//	setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(110, 50, 800, 600);
		setTitle("Brain Tumor Segmentation");
		setIconImage(titleImage);
		con.setLayout(null);
		con.add(panel);
		panel.setLayout(null);
		panel.setBounds(10,10, 770, 550);
		panel.setBackground(Color.lightGray);
		panel.add(combo);
		panel.add(submit);
		panel.add(exit);
		panel.add(scroll);
		panel.add(imageLable);
		imageLable.setIcon(new ImageIcon("keyboard_hand.jpg"));
		combo.setBounds(175, 50, 225, 40);
		submit.setBounds(475, 50, 100, 40);
		exit.setBounds(625, 50, 100,40);
		imageLable.setBounds(425, 100, 425, 400);
		scroll.setBounds(15, 100, 400, 400);
		combo.addItem("Tumor Affected Patient Details");
		combo.addItem("Tumor Not Affected Patient Details");
	 
	
		
	
		header=table.getTableHeader();
		header.setBackground(Color.gray);
		header.setForeground(Color.white);
		header.setFont(new Font("Bookman Old Style",3,18));
		
		table.setBackground(Color.white);
		scroll.setBackground(Color.WHITE);
		
	    table.setFont(new Font("Bookman Old Style",3,18));
		header.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		submit.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		exit.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		panel.setBorder(BorderFactory.createTitledBorder("Patients Reports"));
		
		setVisible(true);
	    submit.addActionListener(this);
	    exit.addActionListener(this);
	    
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getActionCommand()=="Submit")
		{
				
			int rowCount=table.getRowCount();
			System.out.println(">>>>>>>>"+rowCount);
			while(rowCount>0)
			{
			System.out.println(">>>>>>>>>"+i);
			defaultTableModel.removeRow(rowCount-1);
			rowCount=rowCount-1;
			}
			option=""+combo.getSelectedItem();
			System.out.println("_____________________"+option);
			if(option.equalsIgnoreCase("Tumor Affected Patient Details"))
			{
				result="yes";
			}
			if(option.equalsIgnoreCase("Tumor Not Affected Patient Details"))
			{
				result="no";
			}
			
			
		try
		{
			DriverManager.registerDriver(new OracleDriver());
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@paresh-a876a5b0:1521:oracle","system","manager");
			Statement stmt = conn.createStatement();
			query="select a.patientid ,b.name from patientRegistery b,brainResult a where a.patientid=b.patientid AND a.result='"+result+"'";
			ResultSet rs=stmt.executeQuery(query);
			i=0;
			while(rs.next())
			{
				id=rs.getString(1);
				name=rs.getString(2);
				System.out.println(name);
				String data[]={id,name};
				defaultTableModel.addRow(data);
				i++;
			}
			System.out.println("__________"+i);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		}
		if(event.getActionCommand()=="Exit")
		{
		System.exit(0)	;
		}
		
	}

	

}
