package com.sd.training.struts2.raza;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MySha1 {
	static String mysha1(String input) throws NoSuchAlgorithmException{
		 MessageDigest mDigest = MessageDigest.getInstance("SHA1");
	        byte[] result = mDigest.digest(input.getBytes());
	        //StringBuffer sb = new StringBuffer();
	        String str="";
	       for (int i = 0; i < result.length; i++) {
	            //sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
	    	  str += (char)result[i]; 	
	       }
	         
	        //return sb.toString();
	        return str;
		
		
		
	}
	
   public static void main(String[] args) throws NoSuchAlgorithmException {
	System.out.println(MySha1.mysha1("raza imam"));
}
	
}
