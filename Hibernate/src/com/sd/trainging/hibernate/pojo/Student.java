package com.sd.trainging.hibernate.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student implements Serializable{
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
	private Long roleNumber;
	@Column
	private String address;
	@OneToOne(cascade=CascadeType.ALL)
	private StudentDetails studentDetails;
	@OneToMany(cascade={CascadeType.ALL})
	private Set<Marksheet> marksheet;
	@ManyToMany(cascade={CascadeType.ALL})
	private Set<Teacher> teachers;
	
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	public Set<Marksheet> getMarksheet() {
		return marksheet;
	}
	public void setMarksheet(Set<Marksheet> marksheet) {
		this.marksheet = marksheet;
	}
	public StudentDetails getStudentDetails() {
		return studentDetails;
	}
	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}
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
	public Long getRoleNumber() {
		return roleNumber;
	}
	public void setRoleNumber(Long roleNumber) {
		this.roleNumber = roleNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


}
