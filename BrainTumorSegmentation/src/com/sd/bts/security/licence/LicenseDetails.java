package com.sd.bts.security.licence;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;

public class LicenseDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String email;
    private String licenseNumber;
    private int licensePeriod;
    private String macAddress;
    private String hashCode;
    private Date approvedDate;
    
    public Date getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
	public String getMacAddress() {
    	
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
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getHashCode() {
		return hashCode;
	}
	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
		
	}
	public int getLicensePeriod() {
		return licensePeriod;
	}
	public void setLicensePeriod(int licensePeriod) {
		this.licensePeriod = licensePeriod;
	}
	
}