package com.sd.training.struts2.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transfer_info")
public class Transfer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String sourceAcc; 
	private String oor;
	private String transferAmount;
	private String destinationAcc; 
	private String beneficiary;
	private String ifsc;
	private String paymentDetail; 
	
	@Column(name="Source_Account")
	public String getSourceAcc() {
		return sourceAcc;
	}
	public void setSourceAcc(String sourceAcc) {
		this.sourceAcc = sourceAcc;
	}
	@Column(name="Oor")
	public String getOor() {
		return oor;
	}
	public void setOor(String oor) {
		this.oor = oor;
	}
	@Column(name="Transfer_Amount")
	public String getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(String transferAmount) {
		this.transferAmount = transferAmount;
	}
	@Column(name="Destination_Account")
	public String getDestinationAcc() {
		return destinationAcc;
	}
	public void setDestinationAcc(String destinationAcc) {
		this.destinationAcc = destinationAcc;
	}
	@Column(name="Beneficiary")
	public String getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}
	@Column(name="IFSC")
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	@Column(name="Payment_Detail")

	public String getPaymentDetail() {
		return paymentDetail;
	}
	public void setPaymentDetail(String paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
