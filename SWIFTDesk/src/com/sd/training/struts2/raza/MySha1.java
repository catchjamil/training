package com.sd.training.struts2.raza;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MySha1 {
	static String mysha1(String input) throws NoSuchAlgorithmException{
		 MessageDigest mDigest = MessageDigest.getInstance("SHA1");
	        byte[] result = mDigest.digest(input.getBytes());
	       
	       StringBuilder builder = new StringBuilder();
	       for (int i = 0; i < result.length; i++) {
	           
	    	   builder.append(String.format("%02x", result[i]));
	       }
      return builder.toString();	
	}
	 public static void main(String[] args) throws NoSuchAlgorithmException {
		 System.out.println(MySha1.mysha1("raza imam"));
   }
	
}
