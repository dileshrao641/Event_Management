package com.capstone.eventmanagement.model;

import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;

@Entity
public class users {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long user_id;
public users() {
	super();
}
@Override
public String toString() {
	return "users [user_id=" + user_id + ", fullname=" + fullname + ", l email=" + email
			+ ", mobileno=" + mobileno + ", password=" + password + ", confirmpassword=" + confirmpassword + "]";
}
public users(long user_id, String fullname, String email, long mobileno, String password,
		String confirmpassword) {
	super();
	this.user_id = user_id;
	this.fullname = fullname;
	this.email = email;
	this.mobileno = mobileno;
	this.password = password;
	this.confirmpassword = confirmpassword;
}
private String fullname;
private String email;
@Column(length=10)
private long mobileno;
private String password;
private String confirmpassword;
public long getId() {
	return user_id;
}
public void setId(long user_id) {
	this.user_id = user_id;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getMobileno() {
	return mobileno;
}
public void setMobileno(long mobileno) {
	this.mobileno = mobileno;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfirmpassword() {
	return confirmpassword;
}
public void setConfirmpassword(String confirmpassword) {
	this.confirmpassword = confirmpassword;
}



}
