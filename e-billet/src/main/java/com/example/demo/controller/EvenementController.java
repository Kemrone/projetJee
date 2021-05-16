package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
	@Autowired
	private LieuRepository lieuRep;
	@Autowired
	private TypeRepository typeRep;
	@Autowired
	private AcceuilRepository accueilRep;
	
	@RequestMapping(value = {"/adminEvent"}, method = RequestMethod.GET)
	public String adminEvent(Model model)
	{
		model.addAttribute("types", typeRep.findAll());
		model.addAttribute("lieux", lieuRep.findAll());
		model.addAttribute("event", new Evenement());
		model.addAttribute("events",eventRep.findAll());
		return "adminEvent";
	}
	@RequestMapping("/saveEvent")
	public String save( Model model,@Valid Type type,@Valid Lieu lieu,@Param("eName") String eName)
	{
		Evenement e = new Evenement();
		e.setType(type);
		e.seteName(eName);
		
		
		
		Acceuil a = new Acceuil();
		a.setEvenement(e);
		a.setLieu(lieu);
		
		
		eventRep.save(e);
		
		accueilRep.save(a);
		
		
		
		
		model.addAttribute("types", typeRep.findAll());
		model.addAttribute("lieux", lieuRep.findAll());
		model.addAttribute("event", new Evenement());
		model.addAttribute("events",eventRep.findAll());
		return "adminEvent";
	}
	
	@RequestMapping("/editEvent")
	public String edit( @RequestParam Long ref , Model model)
	{
		model.addAttribute("types", typeRep.findAll());
		model.addAttribute("lieux", lieuRep.findAll());
		model.addAttribute("event", eventRep.findById(ref));
		model.addAttribute("events",eventRep.findAll());
		return "adminEvent";
	}
	@RequestMapping("/deleteEvent")
	public String delete( @RequestParam Long ref , Model model)
	{
		//Evenement e = eventRep.findById(ref).get();

		eventRep.deleteEvent(ref);
		model.addAttribute("types", typeRep.findAll());
		model.addAttribute("lieux", lieuRep.findAll());
		model.addAttribute("event", new Evenement());
		model.addAttribute("events",eventRep.findAll());
		return "adminEvent";
	}

}
