package com.pixelware.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.pixelware.project.dao.ServiceUser;
import com.pixelware.project.model.City;
import com.pixelware.project.model.GlobalClimate;
import com.pixelware.project.model.User;


@Controller

/*
 * Crear atributo de sesión "user" cuyo valor es el atributo del modelo
 * "user" creado en el método setUpTeam()
 * 
 */
@SessionAttributes("user")


public class LoginController {
	private ServiceUser serviceusers;


	@Autowired
	public void setServiceUser(ServiceUser serviceUser) {
		this.serviceusers = serviceUser;
	}

	
	/*
	 * Añadir atributo user al modelo
	 */
	@ModelAttribute("user")
	public User setUpUser() {

		return new User();
	}
	
	/*
	 * Añadir atributo user al modelo
	 */
	@ModelAttribute("city")
	public City setUpCity() {

		return new City();
	}

	/*
	 * Método negocio petición GET para URL /
	 */
	@GetMapping("/")
	public String index() {
		return "index";
	}

	/*
	 * Método negocio petición POST para URL /login
	 * 
	 * Enlazamos el atributo del modelo "user" con el argumento currentUser del método
	 * de negocio
	 * 
	 */
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User currentUser, Model model) {
		
		if (serviceusers.validateEmail(currentUser)) { 
			model.addAttribute("error", "Email no valido, Utilice formato aa@bb.cc");
			return "index";
		}	
		
		if (serviceusers.validateBirthDate(currentUser)) {
			model.addAttribute("error", "Fecha no valida, utilice fecha formato: dd/mm/aaaa");
			return "index";
		}
		
		if (serviceusers.validateUser(currentUser)==false) {
			
			model.addAttribute("error", "Credenciales entrada incorrectas");
			return "index";
		}


		return "city";
	}
	
	
	@PostMapping("/newUser")
	public String newUser() {
		return "newUser";
	}
	
	@PostMapping("/createUser")
	public String createUser(@ModelAttribute("user") User currentUser, Model model) {	
		
		if (serviceusers.validateEmail(currentUser)) {
			model.addAttribute("error", "Email no valido, Utilice formato aaa@bbb.ccc");
			return "newUser";
		}	
		
		if (serviceusers.validateBirthDate(currentUser)) {
			model.addAttribute("error", "Fecha no valida, utilice fecha formato: dd/mm/aaaa");
			return "newUser";
		}		
		if (serviceusers.validateUser(currentUser)==true) {		
			model.addAttribute("error", "El Usuario no se puede crear, ya existe");
			return "newUser";
		}

		serviceusers.createuser(currentUser);
		
		return "index";
	}
	@PostMapping("/index")
	public String ReturnToIndex() {
		return "index";
	}
	@PostMapping("/getCity")
	public String Cities(@ModelAttribute("city") City city, Model model) {

	      RestTemplate restTemplate = new RestTemplate();
	      GlobalClimate climate = restTemplate.getForObject("http://api.apixu.com/v1/current.json?key=656fb7b9319c48c7a31125431171010&q="+city.getCityName(), GlobalClimate.class);	
			// Crear atributo en el modelo especificando clave y valor
			model.addAttribute("index", climate.toString());
		
		return "main";
	}
//	 @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
//		public String listado(Model model) {
//
//	      RestTemplate restTemplate = new RestTemplate();
//	      GlobalClimate climate = restTemplate.getForObject("http://api.apixu.com/v1/current.json?key=656fb7b9319c48c7a31125431171010&q=", GlobalClimate.class);	
//			// Crear atributo en el modelo especificando clave y valor
//			model.addAttribute("index", climate.toString());
//			return "index";
//		}
}
