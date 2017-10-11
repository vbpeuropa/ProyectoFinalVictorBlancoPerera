package com.pixelware.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.pixelware.project.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/info")
	public String teamInfo(@SessionAttribute("user") User currentUser) {

		// Mostrar por consola algun dato
		System.out.println("\nPais: " + 
				currentUser.getCountry() + "\n");

		return "currentUser";

	}

}
