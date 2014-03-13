package com.sd.bts.action;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class GrayScale {

	
	public static void main(String[] args) {
	
		try
		{
			Image image = ImageIO.read(new File("kalai.jpg"));
			BufferedImage image1= convert(image);
			int w = image1.getWidth();

			int h = image1.getHeight();

			System.out.println("Height " +h +"   Width " +w);

			int[] rgbs = new int[w*h];
			int x = 0;
			image1.getRGB(0, 0, w, h, rgbs, 0, w);

			for (int i=0; i<2; i++)
			for (int j=0;j<2;j++)
			{
			System.out.println("Pixel " + i +"," + j + "has " + "RGB values of "+ rgbs[x]);
			x++; 
			}
			
	}
		catch(Exception e)
		{
			
		}
	}

			//
			public static BufferedImage convert(Image im)
			{
			BufferedImage bi = new BufferedImage(im.getWidth(null),im.getHeight(null),BufferedImage.TYPE_BYTE_GRAY);
			Graphics bg = bi.getGraphics();
			bg.drawImage(im, 0, 0, null);
			bg.dispose();
			return bi;
			}


	
	}


