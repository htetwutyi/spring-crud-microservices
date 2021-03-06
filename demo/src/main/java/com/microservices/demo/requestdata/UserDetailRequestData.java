package com.microservices.demo.requestdata;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailRequestData {
	
	@NotNull(message = "firstname must not be null.")
	@Size(min = 4, message = "Fistname must be at least 4 characters.")
	private String firstname;
	
	@NotNull(message = "lastname must not be null.")
	private String lastname;
	
	@NotNull(message = "password must not be null.")
	@Size(min = 8, max = 16, message = "Password must be min 8 and max 16 characters.")
	private String password;
	
	@NotNull(message = "email must not be null.")
	@Email(message = "email is invlid.")
	private String email;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
