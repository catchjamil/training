package com.sd.bts.bean;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.sql.Blob;
import java.sql.Date;

@Entity
public class PatientRegistery implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5595592733541419120L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	@Column
	private String imagePath;
	@Column
	private String patientid;
	@Column
	private String name;
	@Column
	private String age;	
	@Column
	private String address;
	@Column
	private String contactNumber;
	@Column
	private String gender;
	@Column
	private String addimittedDate;
	@Column
	private String description;
	@Column
	private String handledDoctor;
	@Column
	private String lastScannedDate;
	@Column
	private String brainImagePath;
	@Column
	private String bloodGroup;
	@Column
	private String brainImageName;
	@Column
	private String fileName;
	@Column
	private String fileDescription;
	
	@Column
	private Date createTime;
	
	
	@Column(name = "fileData", unique = false, nullable = false, length = 100000)
    private byte[] fileData;

	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileDescription() {
		return fileDescription;
	}
	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getPatientid() {
		return patientid;
	}
	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHandledDoctor() {
		return handledDoctor;
	}
	public void setHandledDoctor(String handledDoctor) {
		this.handledDoctor = handledDoctor;
	}
	public String getBrainImagePath() {
		return brainImagePath;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddimittedDate() {
		return addimittedDate;
	}
	public void setAddimittedDate(String addimittedDate) {
		this.addimittedDate = addimittedDate;
	}
	public String getLastScannedDate() {
		return lastScannedDate;
	}
	public void setLastScannedDate(String lastScannedDate) {
		this.lastScannedDate = lastScannedDate;
	}
	public void setBrainImagePath(String brainImagePath) {
		this.brainImagePath = brainImagePath;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getBrainImageName() {
		return brainImageName;
	}
	public void setBrainImageName(String brainImageName) {
		this.brainImageName = brainImageName;
	}
	
}
