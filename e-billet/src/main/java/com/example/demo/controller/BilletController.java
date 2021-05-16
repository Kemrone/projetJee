package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.dao.*;
import com.example.demo.entities.*;

@Controller
@SessionAttributes("check")
public class BilletController {
	
	@Autowired
	private BilletRepository billetRep;
	@Autowired
	private RestrictionRepository restRep;
	@Autowired
	private RestrictionRepository reqRep;
	
	@RequestMapping(value = {"/adminBillet"}, method = RequestMethod.GET)
	public String adminBillet(Model model)
	{
		model.addAttribute("rest", restRep.findAll());
		model.addAttribute("billet", new Billet());
		model.addAttribute("billets",billetRep.findAll());
		return "adminBillet";
	}
	
	@RequestMapping("/saveBillet")
	public String save(  Billet b , Model model)
	{
		billetRep.save(b);
		model.addAttribute("billet", new Billet());
		model.addAttribute("billets", billetRep.findAll());
		return "adminBillet";
	}

	
	@RequestMapping(value ="/checkEditBillet")
	public String check( @RequestParam Long ref ,Model model)
	{
		Billet b = billetRep.findById(ref).get();
		model.addAttribute("billet", new Billet());
		model.addAttribute("check", b);
		model.addAttribute("billets",billetRep.findAll());
		return "adminBillet";
	}
	
	
	@RequestMapping(value = {"/editBillet"})
	public String edit( Model model,@ModelAttribute Billet check,@RequestParam("bId") String id,
			@Param("bCritere") String bCritere,@Param("bEvent") String bEvent,
			@Param("bTarif") String bTarif,@Param("bStock") String bStock,
			@Param("bRestriction") String bRestriction)
	{
		
		model.addAttribute("billet", new Billet());
		Billet b = billetRep.findById(check.getbId()).get();
		model.addAttribute("billets",billetRep.findAll());
		b.setbCritere(bCritere);
		b.setStock(Integer.parseInt(bStock));
		b.setbTarif(Double.parseDouble(bTarif));
		b.setEvenement(null);
		//b.setRequiert(null);
		billetRep.save(b);
		//model.addAttribute("billet", billetRep.findById(ref));
		//model.addAttribute("billets",billetRep.findAll());
		 
		return "adminBillet";
	}
	
	
	@RequestMapping("/deleteBillet")
	public String delete( @RequestParam Long ref , Model model)
	{
		Billet b = billetRep.findById(ref).get();
		billetRep.delete(b);
		model.addAttribute("billet", new Billet());
		model.addAttribute("billets",billetRep.findAll());
		return "adminBillet";
	}

}
