package com.pixelware.project.model;

public class Location {
	private String name;
	private String country;
	private Current current;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Current getCurrent() {
		return current;
	}

	public void setCurrent(Current current) {
		this.current = current;
	}

	@Override
	public String toString() {
		return "Location [name=" + name + ", country=" + country + ", current=" + current + "]";
	}

}
