import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.sd.bts.bean.BrainResult;
import com.sd.bts.utils.DatabaseUtil;

import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.driver.OracleResultSet;
import oracle.sql.BLOB;


public class TumorIdentification extends JFrame implements ActionListener{
	
String query,id,path,filename,result;
BufferedImage b3;
int i=0;
Connection conn ;
Statement stmt;
Container con;
ResultSet rs;
Image bi;
int NoOfCluster=10;
double e=0.1;

ImageIcon im2;
JPanel panel=new JPanel();
JLabel patientID=new JLabel("Select PatientID:");
JLabel imageView=new JLabel();
JComboBox patientIdTxt=new JComboBox();
JButton segmentation=new JButton("Segmentation");
JButton reconstruction=new JButton("Reconstruction");
JButton identification=new JButton("Tumor Identification");
JButton find=new JButton("Find Image");
JButton exit=new JButton("Exit");

	public TumorIdentification() {
		
		
		try
		{
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@paresh-a876a5b0:1521:oracle","system","manager");
			stmt = conn.createStatement();
			query="select patientid from patientRegistery";
			rs=stmt.executeQuery(query);
			while(rs.next())
			{
				id=rs.getString(1);
				patientIdTxt.addItem(id);
			}
			
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
		Image titleImage=Toolkit.getDefaultToolkit().getImage("logo.jpg");
		con=getContentPane();
	//  setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(110, 50, 800, 600);
		setTitle("Brain Tumor Segmentation");
		setIconImage(titleImage);
		setLayout(null);
		con.add(panel);
		panel.setLayout(null);
		panel.setBounds(15,10, 765,540);
	    panel.setBorder(new TitledBorder("Tumor Identification"));
	    panel.setBackground(Color.lightGray);
		panel.add(patientID);
		panel.add(patientIdTxt);
		panel.add(imageView);
		panel.add(find);
		panel.add(segmentation);
		panel.add(reconstruction);
		panel.add(identification);
		panel.add(exit);
		
		Font font=new Font("Bookman Old Style",1,15);
		patientID.setBounds(225, 50, 150, 30);
		patientIdTxt.setBounds(375, 50, 150, 30);
		
		find.setBounds(550, 125 ,175, 50);
		segmentation.setBounds(550, 200, 175, 50);
		reconstruction.setBounds(550, 275, 175, 50);
		identification.setBounds(550, 350, 175, 50);
		exit.setBounds(550, 425, 175, 50);
		imageView.setBounds(25,100,400,400);
		
		
		
		imageView.setBorder(BorderFactory.createRaisedBevelBorder());
		find.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		segmentation.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		reconstruction.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		identification.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		exit.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		
		patientID.setFont(font);
		patientIdTxt.setFont(font);
		find.setFont(font);
		segmentation.setFont(font);
		reconstruction.setFont(font);
		identification.setFont(font);
		exit.setFont(font);
		
		
		find.addActionListener(this);
		segmentation.addActionListener(this);
		reconstruction.addActionListener(this);
		identification.addActionListener(this);
		exit.addActionListener(this);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		try
		{
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@paresh-a876a5b0:1521:oracle","system","manager");
			stmt = conn.createStatement();
		
		
			if(event.getActionCommand()=="Find Image")
			{
			id=""+patientIdTxt.getSelectedItem();
			path="G:\\BrainTumorSegmentation\\";
			final int output = selectBlobData(id, path);
			System.out.println(output);
				query="select filename from patientRegistery where patientid='"+id+"'";
				rs=stmt.executeQuery(query);
				if(rs.next())
				{
					filename=rs.getString(1);
					//JOptionPane.showMessageDialog(this, filename);
					ImageIcon br=new ImageIcon(path+filename);
				    File f1=new File(path+filename);
				    bi=ImageIO.read(f1);
					imageView.setIcon(br);
				}	
				
		   
			
			
			}
			
			if(event.getActionCommand()=="Segmentation")
			{
				   int height=bi.getHeight(null);
			        int width=bi.getWidth(null);
			        System.out.println(width+" "+height);
			        int rgb[]=new int[width*height];
			        int index=0;
			        int pixel[][]=new int[height][width];
			        double inputpix[][]=new double[height][width];
			         double resultpix[][]=new double[height][width];
			        int outpix[][]=new int[height][width];
			        double outpix1[][]=new double[height][width];
			        int pix[][][]=new int[height][width][4];
			        BufferedImage b1=new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY); 
			        Graphics2D gt=b1.createGraphics();
			        gt.drawImage(bi,null,null);
			        b1.getRGB(0,0,width,height,rgb,0, width);
			        for(int i=0;i<height;i++)
			        {
			           for(int j=0;j<width;j++)
			           {
			              pixel[i][j]=rgb[index];
			              index++;
			           }
			        }
			      // System.out.println(pixel[50][50]);
			       pix=convertToThreeDim(rgb,width,height);
			       
			       for(int i=0;i<height;i++)
			       {
			        for(int j=0;j<width;j++)
			        {
			            inputpix[i][j]=((double)pix[i][j][1])/255;
			           //System.out.print("  "+inputpix[i][j]);
			          }
			      //  System.out.println("\n");
			        }
			     // System.out.println(" test  "+pix[53][110][1]);
			          // System.out.print("  "+pix[50][50][1]);
			          // System.out.print("  "+pix[50][50][2]);
			            //System.out.print("  "+pix[50][50][3]);
			        
			     double mean=mean(inputpix); 
			     String str=null;
			     double threshold=mean*e;
			    // System.out.println("threshold"+threshold);
			     double minpix=min(inputpix);
			     double maxpix=max(inputpix);
			     double range=maxpix-minpix;
			     double step=range/NoOfCluster;
			     double interval=step/10;
			    // System.out.println(interval);
			     double[][] centroid=new double[NoOfCluster][1];
			     
			     for(int i=0;i<NoOfCluster;i++) 
			     {
			        centroid[i][0]=interval;
			        interval=interval+0.11;
			       // System.out.println(centroid[i][0]);
			     }
			     for(int i=0;i<height;i++)
			     {
			     for(int j=0;j<width;j++)
			     {
			     outpix1[i][j]=inputpix[i][j];  
			     //System.out.print(" "+outpix[i][j]);
			     }
			    // System.out.println("\n");
			     }
			     int loop=1;
			     double[] dist=new double[10];
			     double[] temp=new double[10];
			     for(int i=0;i<NoOfCluster;i++)
			     {
			      //centroid[i].get(1).toString();  
			      dist[i]=centroid[i][0];
			     }
			     while(max1(dist)>threshold)
			     {
			     for(int i=0;i<NoOfCluster;i++)
			     {
			     //str=centroid[i].get(1).toString();  
			     temp[i]=centroid[i][0];
			          //Double.parseDouble(str);    
			     }
			     double diff[]=new double[10];
			     double tempr=0.0,tempr1=0.0,tempr2=0.0;
			     //initial clustering 
			     for(int i=0;i<height;i++)
			     {
			     for(int j=0;j<width;j++)
			     {
			       for(int k=0;k<NoOfCluster;k++)
			       {
			           diff[k]=Math.abs(inputpix[i][j]-centroid[k][0]);
			          if(inputpix[i][j]!=0.0)
			           tempr1=inputpix[i][j];
			           tempr2=centroid[k][0];
			          tempr=diff[k];
			        }
			       int minval=minval(diff);
			      // System.out.println(minval);
			       outpix[i][j]=minval;
			       }
			     }
			        //new centroid
			     double[] sum=new double[NoOfCluster];
			     int[] count=new int[NoOfCluster];
			     for(int i=0;i<height;i++)
			     {
			     for(int j=0;j<width;j++)
			     {
			     for(int k=0;k<NoOfCluster;k++)
			     {
			       if(outpix[i][j]==k)
			       {
			             sum[k]=sum[k]+outpix1[i][j];
			             count[k]=count[k]+1;
			       }
			        //System.out.println( "count"+sum[k]+" "+count[k]);     
			     }
			     
			     }
			     }
			     // update centroid
			     for(int k=0;k<NoOfCluster;k++)
			     {
			       
			            centroid[k][0] =sum[k]/count[k];
			       
			      //  System.out.println(" "+centroid[k][0]);
			     }
			   //  loop=loop+1;
			     for(int i=0;i<NoOfCluster;i++)
			     {
			         dist[i]=0;
			     }
			     //new distance
			     for(int ii=0;ii<NoOfCluster;ii++)
			     {
			         dist[ii]=temp[ii]-centroid[ii][0];
			        // System.out.println(dist[ii]);
			     }
			     }
			   for(int i=0;i<height;i++)
			     {
			         for(int j=0;j<width;j++)
			         {
			            resultpix[i][j]=(double)centroid[(outpix[i][j])][0]; 
			            //System.out.print("  "+resultpix[i][j]);
			         }
			          //System.out.println("\n");
			     }
			     double[][] result=new double[height][width];
			     for(int i=0;i<height;i++)
			     {
			      for(int j=0;j<width;j++)
			      {
			          result[i][j]=0;
			      }
			     }
			    // for(int i=0;i<NoOfCluster;i++)
			    // {
			        for(int i1=0;i1<height;i1++)
			        {
			            for(int j1=0;j1<width;j1++)
			            {
			                if(outpix[i1][j1]==7)
			                {
			                    result[i1][j1]=centroid[7][0];
			                    System.out.println( result[i1][j1]);
			                }
			            }
			        }
			        int indx=0;
			        int[] resultmat=new int[height*width];
			         int[] resultmat1=new int[height*width];
			   // if(i==9)
			    // {
			        for(int i1=0;i1<height;i1++)
			        {
			            for(int j1=0;j1<width;j1++)  
			            {
			                   if(result[i1][j1]>0.7)
			                   {
			                       resultmat[indx]=1*255;
			                       indx++;
			                   }
			                   else
			                   {
			                        resultmat[indx]=(int)result[i1][j1]*255;
			                                    indx++;
			                   }
			                       }
			            System.out.println("\n");
			            }
			          for(int i1=0;i1<height;i1++)
			        {
			            for(int j1=0;j1<width;j1++)
			            {
			                if(outpix[i1][j1]==9)
			                {
			                    result[i1][j1]=centroid[9][0];
			                   System.out.println( result[i1][j1]);
			                }
			            }
			        }
			     
			         indx=0;
			        for(int i1=0;i1<height;i1++)
			        {
			            for(int j1=0;j1<width;j1++)  
			            {
			                   if(result[i1][j1]>0.9)
			                   {
			                       resultmat1[indx]=1*255;
			                       indx++;
			                   }
			                   else
			                   {
			                        resultmat1[indx]=(int)result[i1][j1]*255;
			                                    indx++;
			                   }
			                       }
			           // System.out.println("\n");
			            }
			    for(int j=0;j<resultmat.length;j++)
			    {
			    resultmat[j]=((255<<24) & 0xFF000000)|((resultmat[j]<<16) & 0x00FF0000)|((resultmat[j]<< 8))|(resultmat[j] & 0x000000FF);
			    } 
			    BufferedImage b2=new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY); 
			    b2.setRGB(0,0,width,height,  resultmat, 0, width);
			    ImageIcon im=new ImageIcon(b2);
			    for(int j=0;j<resultmat.length;j++)
			    {
			    resultmat1[j]=((255<<24) & 0xFF000000)|((resultmat1[j]<<16) & 0x00FF0000)|((resultmat1[j]<< 8))|(resultmat1[j] & 0x000000FF);
			    } 
			     b3=new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY); 
			    b3.setRGB(0,0,width,height,  resultmat1, 0, width);
			    try
			    {
			    	ImageIO.write(b3, "jpg", new File("5.jpg"));
			    }
			    catch(Exception e)
			    {
			    	
			    }
			    im2=new ImageIcon(b3); 
			    imageView.setIcon(im); 
			
			}
			
			if(event.getActionCommand()=="Reconstruction")
			{
				 imageView.setIcon(im2);
			}
			
			
			if(event.getActionCommand()=="Tumor Identification")
			{
				try
				{
			
				DataBufferByte dbb = (DataBufferByte)b3.getRaster().getDataBuffer();
				byte pixels[] = dbb.getData();
			    for (byte pix : pixels) {
				    	
				    	if(pix!=0)
				    	{
				    		int r = (pix >> 16) & 0xff;
				    		int g = (pix >> 8) & 0xff;
				    		int b = (pix >> 0) & 0xff; 
				    			    		
				    		if(r==255&g==255&b==255)
				    		{
				    		System.out.println("(R,G,B)=("+r+","+g+","+b+")");
				    		i++;
				    		}

				    	}
				       
				    }
					System.out.println("------------"+i);
					Session session = DatabaseUtil.getSession();
					Transaction beginTransaction = session.beginTransaction();
					BrainResult brainResult = new BrainResult();
					brainResult.setPatientid(id);
					if(i>300)
					{
						result="yes";
								
						brainResult.setResult(result);
						
						System.out.println(">>>>>>>>>>>>>"+i);
						JOptionPane.showMessageDialog(this, "The Image is Affected By Brain Tumor");
					}
					else
					{
						result="no";
						brainResult.setResult(result);
						
						System.out.println(">>>>>>>>>>>>>"+i);
						JOptionPane.showMessageDialog(this, "The Image is Not Affected By Brain Tumor");
						
					}
					session.save(brainResult);
					beginTransaction.commit();
					session.close();
					i=0;

				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			
			
			
			if(event.getActionCommand()=="Exit")
			{
				System.exit(0);
			}
			
			
		
			 }
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			
}
	
	

	private static int selectBlobData(final String fileId, final String path) {
		/*
		*	 Initialize the necessary parameters
		*/
		int returnValue = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		InputStream is = null;
		OutputStream os = null;
		BLOB blob = null;
		try {
			final String query = "SELECT filename ,fileData  FROM patientRegistery WHERE PATIENTID  = '" + fileId+"'";
			 /* 
			* Register the Oracle driver 
			*/
			DriverManager.registerDriver(new OracleDriver());
			/*
			* Establish a connection to the Oracle database. I have used the Oracle Thin driver.
			* jdbc:oracle:thin@host:port:sid, "user name", "password"
			*/
			conn = DriverManager.getConnection("jdbc:oracle:thin:@paresh-a876a5b0:1521:oracle","system","manager");
			/*
			* Set auto commit to false, it helps to speed up things, by default JDBC's auto commit feature is on.
			* This means that each SQL statement is commited as it is executed.
			*/
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			/*
			* Execute the SELECT statement
			*/
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				/*
				* Extract the BLOB data to a file on the local file system.
				*/
				blob = ((OracleResultSet)rs).getBLOB("fileData");
				is = blob.getBinaryStream();
				final String fileName = rs.getString("filename");
				System.out.println("___________________"+fileName);
				final String filePath = path + fileName;
				os = new FileOutputStream(filePath);
				final int bufferSize = blob.getBufferSize();
				final byte[] buffer = new byte[bufferSize];
				int bytesRead = 0;
				while ((bytesRead = is.read(buffer)) != -1) {
					os.write(buffer, 0, bytesRead);
				}
			}
			else {
				returnValue = 1;
			}
		}
		catch(SQLException e) {
			returnValue = 2;
			e.printStackTrace();
		}
		catch(FileNotFoundException e) {
			returnValue = 3;
			e.printStackTrace();
		}
		catch(Exception e) {
			returnValue = 4;
			e.printStackTrace();
		}
		finally {
			/*
			* Clean up.
			*/
			try {
				if(is != null) {
					is.close();
				}
				if(os != null) {
					os.flush();
					os.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(rs != null) {
					rs.close();
				}
				if(conn != null) {
					conn.commit();
					conn.close();
				}
				is = null;
				os = null;
				stmt = null;
				rs = null;
				conn = null;
				blob = null;
			}
			catch(Exception e) {
				returnValue = 5;
				e.printStackTrace();
			}
		}
		return returnValue;
	}
	
	
	
	int[][][] convertToThreeDim(
	          int[] oneDPix,int imgCols,int imgRows){
	   
	    int[][][] data =new int[imgRows][imgCols][4];

	    for(int row = 0;row < imgRows;row++){
	     
	      int[] aRow = new int[imgCols];
	      for(int col = 0; col < imgCols;col++){
	        int element = row * imgCols + col;
	        aRow[col] = oneDPix[element];
	        }//end for loop on col

	      
	      for(int col = 0;col < imgCols;col++){
	        //Alpha data
	        data[row][col][0] = (aRow[col] >> 24)
	                                          & 0xFF;
	        //Red data
	        data[row][col][1] = (aRow[col] >> 16)
	                                          & 0xFF;
	        //Green data
	        data[row][col][2] = (aRow[col] >> 8)
	                                          & 0xFF;
	        //Blue data
	        data[row][col][3] = (aRow[col])
	                                       & 0xFF;
	      }//end for loop on col
	    }//end for loop on row
	    return data;
	  }

	
    public double mean(double[][] image) {
        int height=image.length;
        int width=image[1].length;
        double sum=0,count=0;
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
              sum=sum+image[i][j];
              count++;
            }
        }
              return (sum/count);
    }
    
    public double min(double[][] image) {
        double temp=0.0;
        for(int i=0;i<image.length;i++)
        {
            for(int j=0;j<image[i].length;j++)
            {
                if(temp==0)
                {
                    temp=image[i][j];
                }
                else if(temp>image[i][j])
                {
                    temp=image[i][j];
                }
            }
        }
        return temp;
    }
    
    public double max(double[][] image) {
      double temp=0;
        for(int i=0;i<image.length;i++)
        {
            for(int j=0;j<image[i].length;j++)
            {
                if(temp==0)
                {
                    temp=image[i][j];
                }
                else if(temp<image[i][j])
                {
                    temp=image[i][j];
                }
            }
        }
        return temp;
    }
    
    private double max1(double[] dist) {
        double temp=0;
        for(int i=0;i<dist.length;i++)
        {
            if(i==0)
             {
            temp=dist[i];
        }
        else if(temp<dist[i])
        {
          temp=dist[i];
        }
        }
       // System.out.println(temp);
        return temp;
    }
     private double min1(double[] dist) {
      double temp=0;
      for(int i=0;i<dist.length;i++)
      {
        if(i==0)
        {
            temp=dist[i];
        }
        else if(temp>dist[i])
        {
          temp=dist[i];
        }
            
      }
     // System.out.println(temp);
      return temp;
    }
     
     public int minval(double[] value) {
    double temp=0.0;
    int index=0;
    
         for(int i=0;i<value.length;i++)
      {
        if(i==0)
        {
            temp=value[i];
                  index=i;
        }
        else if(temp>value[i])
        {
          temp=value[i];
          index=i;
        }
            
      }
         return index;
     }

}
