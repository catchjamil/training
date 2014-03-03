package com.sd.trainging.hibernate.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3406656473274772638L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	@Column
	private String name;
	@Column
	private Long dempartmentId;
	@Column
	private String address;
	/*@ManyToMany(cascade={CascadeType.ALL})
	private Set<Student> student;
	*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getDempartmentId() {
		return dempartmentId;
	}
	public void setDempartmentId(Long dempartmentId) {
		this.dempartmentId = dempartmentId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	/*public Set<Student> getStudent() {
		return student;
	}
	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	*/


}
