package com.microservices.demo.requestdata;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetialRequestData {

	@NotNull(message = "firstname must not be null.")
	@Size(min = 4, message = "Fistname must be at least 4 characters.")
	private String firstname;
	
	@NotNull(message = "lastname must not be null.")
	private String lastname;

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
	
	
}
