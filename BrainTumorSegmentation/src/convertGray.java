import java.awt.event.*;
import java.applet.Applet;
import java.awt.Graphics; 
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
 
 
public class convertGray {
      
public static void main(String[] args) {
 
String path  = "kalai.jpg";
String path1 = "sk.jpg";
 
BufferedImage old_img = null;   
 
   try { old_img = ImageIO.read(new File(path));} 
   catch (Exception e) {  e.printStackTrace(); }  
 
 
BufferedImage new_img = new BufferedImage( old_img.getWidth(),
					 old_img.getHeight(), 
					 BufferedImage.TYPE_BYTE_GRAY);
 
Graphics gr = new_img.getGraphics();
 
gr.drawImage(old_img, 0, 0, null);
gr.dispose();
 
try {   
        ImageIO.write(new_img, "jpg", new File(path1));   
    } 
catch (Exception e)   { 
	e.printStackTrace(); 
	}  
 
byte pix[] = new byte[1];
int n = new_img.getWidth();
int m = new_img.getHeight();
double[][] matrix = new double[n][m];
 
     //swips the rows
     for (int row = 0; row < n; ++row) 
       {
	//swips the columns
         for (int col = 0; col < m; ++col) 
          {
          //matrix[row][col] = new_img.getRGB(row, col);
           new_img.getRaster().getDataElements(row, col, pix);
           matrix[row][col] = pix[0];
           System.out.println("row " + row + " col " + col + " pixel " + matrix[row][col]);                     
	      }
        }	
}
}

