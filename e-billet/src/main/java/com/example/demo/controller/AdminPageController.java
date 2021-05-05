package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.*;
import com.example.demo.entities.*;

@Controller
public class AdminPageController {
	
	@Autowired
	private AchatRepository achatRep;
	@Autowired
	private EvenementRepository eventRep;
	@Autowired
	private BilletRepository billetRep;

	@RequestMapping(value = {"/admin"}, method = RequestMethod.GET )
	public String home(Model model) {
				model.addAttribute("nbEvents", eventRep.count());
				model.addAttribute("achats", achatRep.findAll());
				model.addAttribute("billets", billetRep.findAll());
				
				return "admin";
	}
	
	
}
