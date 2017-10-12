package com.pixelware.project.model;

public class Register {
	
	private String country;
	private String city;
	private int temp;
	private String img;
	
	public Register(String country, String city, int temp, String img) {
		super();
		this.country = country;
		this.city = city;
		this.temp = temp;
		this.img = img;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
}
