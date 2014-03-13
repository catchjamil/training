package com.sd.bts.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BrainResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5595592733541419120L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	@Column
	private String result;
	@Column
	private String patientid;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getPatientid() {
		return patientid;
	}
	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}
	}
