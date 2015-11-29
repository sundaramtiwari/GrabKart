package com.grabkart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.grabkart.entity.User;
import com.grabkart.service.GrabKartService;

/**
 * @author Sundaram
 *
 */
@Controller
public class RegistrationController {

	private static final String Register = "register";
	
	@Autowired
	private GrabKartService grabKartService;

	@RequestMapping("/home")
	public String initForm(Model model){
		String target = "home";
		User user = new User();
		model.addAttribute(user);
		return target;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegForm(Model model){
		String target = Register;
		User user = new User();
		model.addAttribute(user);
		return target;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@RequestParam("type") String type,
			@ModelAttribute("user") User user, Model model){
		String target="home";
		user.setType(type);
		boolean register = grabKartService.register(user);
		if (!register) {
			target = "register";
			model.addAttribute("errorMessage", "username already exist!");
		}
		return target;
	}
}
