/**
 * 
 */
package com.sd.bts.security.licence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;

import com.sd.bts.utils.Constrains;

/**
 * @author Mohammad.Ahmed
 *
 */
public class ValidateLicenseKey {

	/**
	 * @param args
	 */
	static private LicenseDetails licenseDetails = null;
	public static boolean generateApprovedFile(String licenceKeyPath) {
		
		if(validateLicenseFile(licenceKeyPath)){
			
			Calendar cal = Calendar.getInstance(); 
			cal.add(Calendar.MONTH, licenseDetails.getLicensePeriod());
			licenseDetails.setApprovedDate(cal.getTime());
			ObjectOutputStream oos = null;
			FileOutputStream fout = null;
			try{
				 fout = new FileOutputStream(Constrains.LICENSE_KEY_APPROVED_FILE_PATH, true);
				 oos = new ObjectOutputStream(fout);
				oos.writeObject(licenseDetails);
			} catch (Exception ex) {
				ex.printStackTrace();
				return false;
			}finally {
				if(oos  != null){
					try {
						oos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return false;
					}
				} 
			}
		
		}else{
			return false;
		}
		return true;
	}
	
	
	private static boolean validateLicenseFile(String licenceKeyPath){

		
		ObjectInputStream objectinputstream = null;
		 try {
		        FileInputStream streamIn = new FileInputStream(licenceKeyPath);
		        objectinputstream = new ObjectInputStream(streamIn);
		        
		        licenseDetails = (LicenseDetails) objectinputstream.readObject();
		                   
		        System.out.println(licenseDetails.getEmail());
		        String hashKey = Encryt.getHash(generateHashKey(licenseDetails));
		        if(!hashKey.equals(licenseDetails.getHashCode())){
		        	return false;
		        }
		        if(!Encryt.getCurrentSystemMacAddress().equals(licenseDetails.getMacAddress())){
		        	return false;
		        }

		   } catch (Exception e) {

		        e.printStackTrace();
		   }finally {
		        if(objectinputstream != null){
		            try {
						objectinputstream .close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		         } 
		   }
		 return true;
	}
	
	private static String generateHashKey(LicenseDetails licenseDetails){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(licenseDetails.getEmail());
		stringBuffer.append(licenseDetails.getName());
		stringBuffer.append(licenseDetails.getLicenseNumber());
		stringBuffer.append(licenseDetails.getLicensePeriod());
		return stringBuffer.toString();
		
	}
	
}
