package com.app.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.user.model.Profession;
import com.app.user.model.User;
import com.app.user.service.IUserService;

@Controller
public class UserController {
	
	private IUserService service;
	
	public UserController(IUserService service) {
		this.service = service;
	}

	@GetMapping("/register")
	public String showRegister(ModelMap map) {
		map.addAttribute("user", new User());
		map.addAttribute("professionList", Profession.values());
		return "register";
	}
	
	@PostMapping("/register")
	public String doRegistration(@ModelAttribute("user") User user, ModelMap map) {
		User savedInDb = service.save(user);
		map.addAttribute("user", savedInDb);
		return "register_success";
	}
	
	@GetMapping("/viewAllUsers")
	public String showAllUsers(ModelMap map){
		List<User> users = service.findAll();
		map.addAttribute("users", users);
		return "users_data";
	}
	
	@GetMapping("/showUpdate/{id}")
	public String showUpdate(@PathVariable("id") long id,ModelMap map) {
		Optional<User> optional = service.findById(id);
		User user = optional.get();
		
		if(optional.isPresent()) {
			map.addAttribute("professionList", Profession.values());
			map.addAttribute("user", user);			
		}
		return "user_update";
	}
	
	@PostMapping("/update")
	public String updateData(@ModelAttribute User user,ModelMap map) {
		User updatedUser = service.update(user);
		map.addAttribute("user", updatedUser);
		return "register_success";
	}
}
