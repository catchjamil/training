package com.sd.training.struts2.imran;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
public class PropertyClass {
	public static void main(String[]  args){/*
		Properties capitals =new Properties();
		
		capitals.put("Usa","Washington");
		capitals.put("France","Paris");
		capitals.put("England","London");
		capitals.put("China","Hongkong");
		
		Set states =capitals.keySet();
		
		for(Object name : states)
			System.out.println("The capital of " + name + " is " + capitals.getProperty((String)name) + ". ");
	*/
		
		Properties prop = new Properties();
		 
    	try {
    		//set the properties value
    		prop.setProperty("database", "localhost");
    		prop.setProperty("dbuser", "mkyong");
    		prop.setProperty("dbpassword", "password");
 
    		//save properties to project root folder
    		File file = new File("E:\\New folder\\SWIFTDesk\\config.properties");
    		if(file.exists()){
    			file.createNewFile();
    		}
    		prop.store(new FileOutputStream(file), null);
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
	
	}

}
