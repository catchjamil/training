package com.sd.trainging.hibernate.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentDetails implements Serializable{
	
	private static final long serialVersionUID = 3406656473274772638L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	@Column
	private String fatherName;
	@Column
	private Long branchID;
	@Column
	private String studentCurrentYear;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public Long getBranchID() {
		return branchID;
	}
	public void setBranchID(Long branchID) {
		this.branchID = branchID;
	}
	public String getStudentCurrentYear() {
		return studentCurrentYear;
	}
	public void setStudentCurrentYear(String studentCurrentYear) {
		this.studentCurrentYear = studentCurrentYear;
	}
	
}
