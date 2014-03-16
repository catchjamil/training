package com.sd.training.struts2.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Contact")
public class Contact {

 private String firstName;
 private String lastName;
 private String email;
 private long id;

 @Column(name="Email")
 public String getEmail() {
  return email;
 }

 @Column(name="First_Name")
 public String getFirstName() {
  return firstName;
 }

 @Column(name="Last_Name")  
 public String getLastName() {
  return lastName;
 }

public void setEmail(String s) {
 email = s;
}

public void setFirstName(String s) {
 firstName = s;
}

public void setLastName(String s) {
 lastName = s;
}  

@Id
@GeneratedValue
@Column(name="id")
public long getId() {
 return id;
}

public void setId(long l) {
 id = l;
}
}