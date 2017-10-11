package com.pixelware.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Current {
	private int temp_c;

	public int getTemp_c() {
		return temp_c;
	}

	public void setTemp_c(int temp_c) {
		this.temp_c = temp_c;
	}

	@Override
	public String toString() {
		return "Current [temp_c=" + temp_c + "]";
	}

}