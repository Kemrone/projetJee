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
public class TypeController {
	
	@Autowired
	private TypeRepository typeRep;
	
	@RequestMapping(value = {"/adminType"}, method = RequestMethod.GET)
	public String adminType(Model model)
	{
		model.addAttribute("type", new Type());
		model.addAttribute("types",typeRep.findAll());
		return "adminType";
	}
	@RequestMapping("/saveType")
	public String save(  Type t , Model model)
	{
		typeRep.save(t);
		model.addAttribute("type", new Type());
		model.addAttribute("types",typeRep.findAll());
		return "saveType";
	}
	
	@RequestMapping("/editType")
	public String edit( @RequestParam Long ref , Model model)
	{
		
		model.addAttribute("type", typeRep.findById(ref));
		model.addAttribute("types",typeRep.findAll());
		return "editType";
	}
	@RequestMapping("/deleteType")
	public String delete( @RequestParam Long ref , Model model)
	{
		Type t = typeRep.findById(ref).get();
		typeRep.delete(t);
		model.addAttribute("type", new Type());
		model.addAttribute("types",typeRep.findAll());
		return "deleteType";
	}

}
