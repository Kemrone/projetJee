package com.example.demo.controller;

import javax.validation.Valid;

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
	private EvenementRepository eventRep;
	@Autowired
	private RequiertRepository reqRep;
	
	
	@RequestMapping(value = {"/adminBillet"}, method = RequestMethod.GET)
	public String adminBillet(Model model)
	{
		model.addAttribute("events", eventRep.findAll());
		model.addAttribute("rests", restRep.findAll());
		model.addAttribute("billet", new Billet());
		model.addAttribute("billets",billetRep.findAll());
		return "adminBillet";
	}
	
	@RequestMapping("/saveBillet")
	public String save(  Billet b , Model model,@Valid Restriction restriction,@Param("value") String value)
	{
		
		
		Requiert r = new Requiert();
		r.setValue(value);
		r.setBillet(b);
		r.setRestriction(restriction);
		billetRep.save(b);
		
		reqRep.save(r);
		
		
		model.addAttribute("events", eventRep.findAll());
		model.addAttribute("rests", restRep.findAll());
		model.addAttribute("billet", new Billet());
		model.addAttribute("billets", billetRep.findAll());
		return "redirect:adminBillet";
	}

	
	@RequestMapping(value ="/checkEditBillet")
	public String check( @RequestParam Long ref ,Model model)
	{
		Billet b = billetRep.findById(ref).get();
		model.addAttribute("event", eventRep.findAll());
		model.addAttribute("rests", restRep.findAll());
		model.addAttribute("billet", new Billet());
		model.addAttribute("check", b);
		model.addAttribute("billets",billetRep.findAll());
		return "redirect:adminBillet";
	}
	
	
	@RequestMapping(value = {"/editBillet"})
	public String edit( Model model,@ModelAttribute Billet check,@Param("bId") String id,
			@Param("bStockDec") String bStockDec, @Param("bStockAdd") String bStockAdd
			)
	{
		model.addAttribute("events", eventRep.findAll());
		model.addAttribute("rests", restRep.findAll());
		model.addAttribute("billet", new Billet());
		Billet b = billetRep.find(check.getbId());
		model.addAttribute("billets",billetRep.findAll());
		
		if(bStockDec !=null && bStockDec != "") {
		b.setStock(b.getStock()-Integer.parseInt(bStockDec));
		billetRep.save(b);
		}
		
		else if(bStockAdd !=null && bStockAdd !="") {
			b.setStock(b.getStock()+Integer.parseInt(bStockAdd));
			billetRep.save(b);
			}
		 
		return "redirect:adminBillet";
	}
	
	
	@RequestMapping("/deleteBillet")
	public String delete( @RequestParam Long ref , Model model)
	{
		Billet b = billetRep.findById(ref).get();
		billetRep.delete(b);
		model.addAttribute("events", eventRep.findAll());
		model.addAttribute("rests", restRep.findAll());
		model.addAttribute("billet", new Billet());
		model.addAttribute("billets",billetRep.findAll());
		return "redirect:adminBillet";
	}

}
