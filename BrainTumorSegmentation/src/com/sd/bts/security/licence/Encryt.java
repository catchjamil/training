package com.sd.bts.security.licence;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
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

public static String getCurrentSystemMacAddress(){

	
	InetAddress ip;
	StringBuilder sb = new StringBuilder();
	try {
 
		ip = InetAddress.getLocalHost();
 
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
 
		byte[] mac = network.getHardwareAddress();
 
 
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
 
	} catch (UnknownHostException e) {
 
		e.printStackTrace();
 
	} catch (SocketException e){
 
		e.printStackTrace();
 
	}
	return sb.toString();

		
	}
	
	
}
