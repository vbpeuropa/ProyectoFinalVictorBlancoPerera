package com.pixelware.project.dao;

import java.util.List;

import com.pixelware.project.model.Register;



public interface ServiceHistory {
	
	
	void addRegister(Register register);
	
	public List<Register> obtenerRegistros();
}
