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
public class LieuController {
	
	@Autowired
	private LieuRepository lieuRep;
	
	@RequestMapping(value = {"/adminLieu"}, method = RequestMethod.GET)
	public String adminUser(Model model)
	{
		model.addAttribute("lieu", new Lieu());
		model.addAttribute("lieux",lieuRep.findAll());
		return "adminLieu";
	}
	@RequestMapping("/saveLieu")
	public String save(  Lieu l , Model model)
	{
		lieuRep.save(l);
		model.addAttribute("lieu", new Lieu());
		model.addAttribute("lieux",lieuRep.findAll());
		return "saveLieu";
	}
	
	@RequestMapping("/editLieu")
	public String edit( @RequestParam Long ref , Model model)
	{
		
		model.addAttribute("lieu", lieuRep.findById(ref));
		model.addAttribute("lieux",lieuRep.findAll());
		return "editLieu";
	}
	@RequestMapping("/deleteLieu")
	public String delete( @RequestParam Long ref , Model model)
	{
		Lieu l = lieuRep.findById(ref).get();
		lieuRep.delete(l);
		model.addAttribute("lieu", new Lieu());
		model.addAttribute("lieux",lieuRep.findAll());
		return "deleteLieu";
	}

}
