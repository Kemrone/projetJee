package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;

@Controller
@SessionAttributes({"event","user"})

public class EventPreviewController {
	
	@Autowired
	EvenementRepository eventRep;
	
	@RequestMapping(value = {"/goToBillet"}, method = RequestMethod.GET )
	public String billetStore(RedirectAttributes attributes,Model model,@RequestParam("ref") Long ref) {
		
				

			Evenement e = eventRep.findById(ref).get();
		
			model.addAttribute("event", e);
				return "choixAchat";
	}

}
