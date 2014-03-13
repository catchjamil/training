
import javax.swing.*;
import java.io.*;
import java.awt.MediaTracker.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.*;
import java.util.*;
import java.lang.Math.*;

public class Backupcode extends javax.swing.JFrame {
    Image bi;
    int NoOfCluster=10;
    double e=0.1;
     static ImageIcon im2;
        /** Creates new form brain */
    public Backupcode() {
        initComponents();
    }
    
   
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setBackground(new java.awt.Color(102, 204, 255));
        jButton1.setFont(new java.awt.Font("MS Sans Serif", 1, 11));
        jButton1.setForeground(new java.awt.Color(0, 51, 51));
        jButton1.setText("Browse");
        jButton1.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setMargin(new java.awt.Insets(12, 24, 12, 24));
        jButton1.setPreferredSize(new java.awt.Dimension(75, 17));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.insets = new java.awt.Insets(11, 13, 12, 11);
        jPanel1.add(jButton1, gridBagConstraints);

        jLabel2.setBorder(new javax.swing.border.EtchedBorder(java.awt.Color.lightGray, java.awt.Color.gray));
        jLabel2.setPreferredSize(new java.awt.Dimension(255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.ipady = 49;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 1);
        jPanel1.add(jLabel2, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1.setBackground(new java.awt.Color(0, 153, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel1.setForeground(new java.awt.Color(51, 51, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Brain Tumour Segmentation");
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBackground(new java.awt.Color(153, 255, 255));
        jButton2.setBackground(new java.awt.Color(51, 204, 255));
        jButton2.setFont(new java.awt.Font("MS Sans Serif", 1, 11));
        jButton2.setText("Segmentation");
        jButton2.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(9, 2, 8, 2);
        jPanel3.add(jButton2, gridBagConstraints);

        jButton4.setBackground(new java.awt.Color(51, 204, 255));
        jButton4.setFont(new java.awt.Font("MS Sans Serif", 1, 11));
        jButton4.setText("Reconstruction");
        jButton4.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 7, 0);
        jPanel3.add(jButton4, gridBagConstraints);

        jButton3.setText("Exit");
        jButton3.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel3.add(jButton3, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-500)/2, (screenSize.height-400)/2, 500, 400);
    }//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jLabel2.setIcon(im2);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
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
    BufferedImage b3=new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY); 
    b3.setRGB(0,0,width,height,  resultmat1, 0, width);
    try
    {
    	ImageIO.write(b3, "jpg", new File("5.jpg"));
    }
    catch(Exception e)
    {
    	
    }
    im2=new ImageIcon(b3); 
    jLabel2.setIcon(im);
   // }
   //  }
     
    }//GEN-LAST:event_jButton2ActionPerformed
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       jf=new JFileChooser(".");
       File f1=null;
       int s= jf.showOpenDialog(this);
       if(s==jf.APPROVE_OPTION)
       {
         f1=jf.getSelectedFile();
        }
         try
           {
           File file=new File(f1.getAbsolutePath());   
           bi=ImageIO.read(file);
           ImageIcon im=new ImageIcon(bi);
          jLabel2.setIcon(im);
          }
           catch(Exception e){}
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new Backupcode().show();
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
     
    private javax.swing.JFileChooser jf;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
    
}
