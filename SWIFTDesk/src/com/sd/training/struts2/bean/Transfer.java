package com.sd.training.struts2.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Contact")
public class Transfer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String SourceAcc; 
	private String Oor;
	private String TransferAmount;
	private String DestinationAcc; 
	private String Beneficiary;
	private String Ifsc;
	private String PaymentDetail; 
	
	
	@Column(name="Source_Account")
	public String getSourceAcc() {
		return SourceAcc;
	}

	public void setSourceAcc(String sourceAcc) {
		SourceAcc = sourceAcc;
	}
	
	@Column(name="Oor")
	public String getOor() {
		return Oor;
	}

	public void setOor(String oor) {
		Oor = oor;
	}
	
	@Column(name="Transfer_Amount")
	public String getTransferAmount() {
		return TransferAmount;
	}

	public void setTransferAmount(String transferAmount) {
		TransferAmount = transferAmount;
	}
	
	@Column(name="Destination_Account")
	public String getDestinationAcc() {
		return DestinationAcc;
	}

	public void setDestinationAcc(String destinationAcc) {
		DestinationAcc = destinationAcc;
	}
	
	@Column(name="Beneficiary")
	public String getBeneficiary() {
		return Beneficiary;
	}

	public void setBeneficiary(String beneficiary) {
		Beneficiary = beneficiary;
	}

	@Column(name="IFSC")
	public String getIfsc() {
		return Ifsc;
	}

	public void setIfsc(String ifsc) {
		Ifsc = ifsc;
	}

	@Column(name="Payment_Detail")
	public String getPaymentDetail() {
		return PaymentDetail;
	}



	public void setPaymentDetail(String paymentDetail) {
		PaymentDetail = paymentDetail;
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
