package com.pixelware.project.controller;

import java.util.regex.Pattern;

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
import com.pixelware.project.model.Register;
import com.pixelware.project.model.User;
import com.pixelware.project.dao.ServiceHistory;


@Controller

/*
 * Crear atributo de sesión "user" cuyo valor es el atributo del modelo
 * "user" creado en el método setUpTeam()
 * 
 */
@SessionAttributes("user")


public class MainController {
	
	private ServiceUser serviceusers;
	
	@Autowired
	private ServiceHistory servicehistories;
	
	@Autowired
	public void setServiceUser(ServiceUser serviceUser) {
		this.serviceusers = serviceUser;
	}
	

	public void setServiceHistory(ServiceHistory servicehistory) {
		this.servicehistories = servicehistory;
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


		return "newcity";
	}
	
	
	@PostMapping("/newUser")
	public String newUser() {
		return "newUser";
	}
	
	@PostMapping("/newcity")
	public String newcity() {
		return "newcity";
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

	      try {
			if (!Pattern.matches("[0-9]*", city.getCityName())) {
				RestTemplate restTemplate = new RestTemplate();
				GlobalClimate climate = restTemplate
						.getForObject("http://api.apixu.com/v1/current.json?key=656fb7b9319c48c7a31125431171010&q="
								+ city.getCityName(), GlobalClimate.class);
				servicehistories
						.addRegister(new Register(climate.getLocation().getCountry(), climate.getLocation().getName(),
								climate.getCurrent().getTemp_c(), climate.getCurrent().getCondition().getIcon()));
				model.addAttribute("ListadoReg", servicehistories.obtenerRegistros());
				// Crear atributo en el modelo especificando clave y valor
				model.addAttribute("country", climate.getLocation().getCountry());
				model.addAttribute("city", climate.getLocation().getName());
				model.addAttribute("temp", climate.getCurrent().getTemp_c());
				model.addAttribute("img", climate.getCurrent().getCondition().getIcon());
				return "main";
			}
			model.addAttribute("error", "Campo no válido");
			return "newcity";
		} catch (Exception HttpClientErrorException) {
			model.addAttribute("error", "Ciudad No Encontrada");
			return "newcity";
			
		}
	}
}
