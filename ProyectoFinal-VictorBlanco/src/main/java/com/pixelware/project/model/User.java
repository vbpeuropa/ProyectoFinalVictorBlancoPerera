package com.pixelware.project.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	private String birthDate;
	private String country;
	
	public User(String email, String password, String birthDate, String country) {

		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.country = country;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
	
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}



	@Override
	public String toString() {
		return "User [ email=" + email + ", password=" + password + ", birthDate=" + birthDate
				+ ", country=" + country + "]";
	}

	

}
