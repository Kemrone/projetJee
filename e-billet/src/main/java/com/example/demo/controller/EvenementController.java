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
public class EvenementController {
	
	@Autowired
	private EvenementRepository eventRep;
	
	@RequestMapping(value = {"/adminEvent"}, method = RequestMethod.GET)
	public String adminEvent(Model model)
	{
		model.addAttribute("evenement", new Evenement());
		model.addAttribute("evenements",eventRep.findAll());
		return "adminEvent";
	}
	@RequestMapping("/saveEvent")
	public String save(  Evenement e , Model model)
	{
		eventRep.save(e);
		model.addAttribute("evenement", new Utilisateur());
		model.addAttribute("evenements",eventRep.findAll());
		return "saveEvent";
	}
	
	@RequestMapping("/editEvent")
	public String edit( @RequestParam Long ref , Model model)
	{
		
		model.addAttribute("evenement", eventRep.findById(ref));
		model.addAttribute("evenements",eventRep.findAll());
		return "editEvent";
	}
	@RequestMapping("/deleteEvent")
	public String delete( @RequestParam Long ref , Model model)
	{
		Evenement e = eventRep.findById(ref).get();
		eventRep.delete(e);
		model.addAttribute("evenement", new Evenement());
		model.addAttribute("evenements",eventRep.findAll());
		return "deleteEvent";
	}

}
