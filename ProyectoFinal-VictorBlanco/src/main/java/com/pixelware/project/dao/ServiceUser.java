package com.pixelware.project.dao;

import java.util.Date;
import java.util.List;

import com.pixelware.project.model.User;


public interface ServiceUser {

	List<User> getUserList();
	boolean validateUser(User Currentuser);
	void createuser(User newUser);
	
	boolean validateEmail(User newUser);
	boolean validateBirthDate(User newUser);
}
