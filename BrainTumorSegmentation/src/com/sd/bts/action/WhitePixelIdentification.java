package com.sd.bts.action;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.EnumControl.Type;


public class WhitePixelIdentification {
	
	int i=0;
	public WhitePixelIdentification()
	{
	try
		{
		BufferedImage buff;
		buff=ImageIO.read(new File("3.jpg"));
		DataBufferByte dbb = (DataBufferByte)buff.getRaster().getDataBuffer();
		byte pixels[] = dbb.getData();
	    for (byte pix : pixels) {
		    	
		    	/*if(pix!=0)
		    	{
		    		 System.out.println(pix+" ");
		    		 i++;
		    	}
		    	
		    	*/
		    	
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

		}
		catch(Exception e)
		{
			
		}
}

	
	public static void main(String arg[])
	{
	new WhitePixelIdentification();
	}

}
