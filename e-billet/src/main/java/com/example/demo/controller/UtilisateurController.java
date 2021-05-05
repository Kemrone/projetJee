package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.*;
import com.example.demo.entities.*;



@Controller
public class UtilisateurController {
	
	@Autowired
	private UtilisateurRepository userRep;
	
	@RequestMapping(value = {"/adminUser"}, method = RequestMethod.GET)
	public String adminUser(Model model)
	{
		model.addAttribute("utilisateur", new Utilisateur());
		model.addAttribute("utilisateurs",userRep.findAll());
		return "adminUser";
	}
	@RequestMapping("/saveUser")
	public String save(  Utilisateur u , Model model)
	{
		userRep.save(u);
		model.addAttribute("utilisateur", new Utilisateur());
		model.addAttribute("utilisateurs",userRep.findAll());
		return "saveUser";
	}
	
	@RequestMapping("/editUser")
	public String edit( @RequestParam Long ref , Model model)
	{
		
		model.addAttribute("utilisateur", userRep.findById(ref));
		model.addAttribute("utilisateurs",userRep.findAll());
		return "editUser";
	}
	@RequestMapping("/deleteUser")
	public String delete( @RequestParam Long ref , Model model)
	{
		Utilisateur u = userRep.findById(ref).get();
		userRep.delete(u);
		model.addAttribute("utilisateur", new Utilisateur());
		model.addAttribute("utilisateurs",userRep.findAll());
		return "deleteUser";
	}

}
