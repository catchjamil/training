package com.sd.training.struts2.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryt {
	
	public static String getHash(String password){

        MessageDigest mDigest;
        StringBuffer obj = null;
		try {
			mDigest = MessageDigest.getInstance("SHA1");
			byte[] result = mDigest.digest(password.getBytes());
			 obj = new StringBuffer();
			for (int i = 0; i < result.length; i++) {
				obj.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-genercmdated catch block
			e.printStackTrace();
		}
        return obj.toString();
 		
	}


}
