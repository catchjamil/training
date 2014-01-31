package com.sd.training.struts2.imran;

//package com.javacodegeeks.snippets.core;

 

public class Main5{

 

    public static void main(String arg[]) throws Exception {

 

  System.out.println(encrypt("JavaCodeGeeks"));

    }

 

    public static byte[] encrypt(String x) throws Exception {

 

  java.security.MessageDigest digest = null;

 

  digest = java.security.MessageDigest.getInstance("SHA-1");

 

  digest.reset();

 

  digest.update(x.getBytes("UTF-8"));

 

  return digest.digest();

    }

}

