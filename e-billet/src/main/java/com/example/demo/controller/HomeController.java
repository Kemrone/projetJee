package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.*;
import com.example.demo.entities.*;

@Controller
@SessionAttributes("user")
public class HomeController {
	
	@Autowired
	private EvenementRepository eventRep;
	@Autowired
	private UtilisateurRepository userRep;
	@Autowired
	private BilletRepository billetRep;
	
	
	
	@RequestMapping(value = {"/", "/home"} )
	public String home(Model model,@Param("keyword") String keyword) {
		
		

		 Utilisateur user = (Utilisateur) model.asMap().get("user");
		 model.addAttribute("u", user);
		 List<Evenement> events = eventRep.search(keyword);
		 if(keyword==null) {
			 events = eventRep.findAll()
;		 }
	
		 model.addAttribute("events", events);
		 model.addAttribute("keyword", keyword);
				return "home";
	}
	
	@RequestMapping(value = {"/goToEvent"}, method = RequestMethod.GET )
	public String eventDetails(RedirectAttributes attributes,Model model,@RequestParam("ref") Long ref) {
		
				Evenement e = eventRep.findById(ref).get();
				
				model.addAttribute("event", e);

		
				return "eventPreview";
	}
	
	
	
	
	
	
	
}
