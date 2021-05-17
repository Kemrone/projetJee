package com.example.demo.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.dao.*;
import com.example.demo.entities.*;

@Controller
@SessionAttributes("check")
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
		model.addAttribute("check",null);
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
		return "redirect:adminEvent";
	}
	
	
	@RequestMapping(value ="/checkEditEvent")
	public String check( @RequestParam Long ref ,Model model)
	{
		Evenement e = eventRep.findById(ref).get();
		model.addAttribute("event", eventRep.findAll());
		model.addAttribute("event", new Evenement());
		model.addAttribute("check", e);
		model.addAttribute("events",eventRep.findAll());
		model.addAttribute("types", typeRep.findAll());
		model.addAttribute("lieux", lieuRep.findAll());
		return "adminEvent";
	}
	
	
	
	@RequestMapping("/editEvent")
	public String edit(  Model model,@ModelAttribute Evenement check,
						@Valid Type type,@Valid Lieu lieu,@Param("eName") String eName)
	{
		Evenement e = eventRep.find(check.geteId());
		
		accueilRep.deleteAll(e.getAcceuil());
		
		Acceuil a = new Acceuil();
		a.setEvenement(e);
		a.setLieu(lieu);
		e.setType(type);
		e.seteName(eName);
		accueilRep.save(a);
		eventRep.save(e);
		
		
		
		

		
		model.addAttribute("types", typeRep.findAll());
		model.addAttribute("lieux", lieuRep.findAll());
		model.addAttribute("event", new Evenement());
		model.addAttribute("events",eventRep.findAll());
		model.addAttribute("check",null);
		return "redirect:adminEvent";
	}
	@RequestMapping("/deleteEvent")
	public String delete( @RequestParam Long ref , Model model)
	{
		

		eventRep.deleteEvent(ref);
		model.addAttribute("types", typeRep.findAll());
		model.addAttribute("lieux", lieuRep.findAll());
		model.addAttribute("event", new Evenement());
		model.addAttribute("events",eventRep.findAll());
		return "redirect:adminEvent";
	}

}
