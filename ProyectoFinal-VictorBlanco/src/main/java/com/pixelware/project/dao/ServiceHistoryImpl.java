package com.pixelware.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.pixelware.project.model.Register;

@Repository
public class ServiceHistoryImpl implements ServiceHistory {


	private static List<Register> registros;

	static {
		registros = new ArrayList<>();

//		registros.add(new Register("Francia","Marseille",26,""));
//
//		registros.add(new Register("España","Cuenca",21,""));
	}
	@Override
	public void addRegister(Register register) {	
		if (registros.size()==10) {
			registros.remove(0);
			registros.add(register);
		}	
		registros.add(register);	
	}
	@Override
	public List<Register> obtenerRegistros() {
		return registros;
	}


}
