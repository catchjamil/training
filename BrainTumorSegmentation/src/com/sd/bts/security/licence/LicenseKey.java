/**
 * 
 */
package com.sd.bts.security.licence;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.sd.bts.utils.Constrains;

/**
 * @author Mohammad.Ahmed
 *
 */
public class LicenseKey {

	/**
	 * @param args
	 */
	public static boolean generateKey(LicenseDetails licenseDetails) {
		// TODO Auto-generated method stub
		
		licenseDetails.setHashCode(Encryt.getHash(generateHashKey(licenseDetails)));
		
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try{
			 fout = new FileOutputStream(Constrains.LICENSE_KEY_FILE_PATH, true);
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
