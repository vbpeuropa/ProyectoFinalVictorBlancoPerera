package com.pixelware.project.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Repository;

import com.pixelware.project.model.User;

@Repository
public class ServiceUserImpl implements ServiceUser {

	private static List<User> users;

	static {
		users = new ArrayList<>();

		users.add(new User("hhh@iii.com","pswd1","11/11/1111", "Spain"));
		users.add(new User("aaa@bbb.com","pswd2","22/22/2222","France"));
		users.add(new User("a","b","c","d"));
		users.add(new User("1","2","3","4"));
	}

	@Override
	public List<User> getUserList() {
		
		return null;
	}

	@Override
	public boolean validateUser(User Currentuser) {
		for (User useri : users) {
			if (useri.getEmail().compareTo(Currentuser.getEmail())==0 &&
				useri.getPassword().compareTo(Currentuser.getPassword())==0 &&
				useri.getBirthDate().compareTo(Currentuser.getBirthDate())==0 &&
				useri.getCountry().compareTo(Currentuser.getCountry())==0) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void createuser(User newUser) {
		users.add(newUser);
	}

	@Override
	public boolean validateEmail(User newUser) {
		if (Pattern.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$", newUser.getEmail())) {
			return false;
		}
		return true;
	}

	@Override
	public boolean validateBirthDate(User newUser) {
		if (Pattern.matches("\\d{1,2}/\\d{1,2}/\\d{4}", newUser.getBirthDate())) {
			return false;
		}
		return true;
	}

}
