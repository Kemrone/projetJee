package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.AchatRepository;
import com.example.demo.dao.BilletRepository;
import com.example.demo.dao.EvenementRepository;
import com.example.demo.dao.UtilisateurRepository;
import com.example.demo.entities.Achat;
import com.example.demo.entities.Billet;
import com.example.demo.entities.Evenement;
import com.example.demo.entities.Utilisateur;

@Controller
@SessionAttributes({"event","user","billet"})
public class TransactionController {
	
	@Autowired
	EvenementRepository eventRep;
	@Autowired
	BilletRepository billetRep;
	@Autowired
	UtilisateurRepository userRep;
	@Autowired
	AchatRepository achatRep;
	
	@RequestMapping(value = {"/goTo"}, method = RequestMethod.GET )
	public String billetAchat(RedirectAttributes attributes,Model model,@RequestParam("ref") Long ref) {
		
				
			Billet b = billetRep.findById(ref).get();
			model.addAttribute("billet", b);
				return "billetConfirm";
	}
	
	@RequestMapping(value = {"/confirm"} )
	public String achatConfirmation(RedirectAttributes attributes,Model model,@ModelAttribute Billet billet) {
		 
			
			Billet b = billetRep.findById(billet.getbId()).get();
			model.addAttribute("billet", b);
			Utilisateur user = (Utilisateur) model.asMap().get("user");
			
			if(user.getSolde()>b.getbTarif()) {
				
				long millis=System.currentTimeMillis();  
			    java.sql.Date date=new java.sql.Date(millis);  
			    
				Achat achat = new Achat();
				
				user.setSolde(user.getSolde()-b.getbTarif());
				
				b.setStock(b.getStock()-1);
				
				
				achat.setBillet(b);
				achat.setDate(date);
				achat.setUtilisateur(user);
				achat.setQuantite(1);
											
				billetRep.save(b);
				
				userRep.save(user);
				
				achatRep.save(achat);
				
				List<Evenement> events = eventRep.findAll();
				model.addAttribute("events", events);
				attributes.addFlashAttribute("user", user);	
				attributes.addFlashAttribute("events", events);	
				
				return "redirect:home";
			}
			else {
				String message = "Transaction echouee.";
				model.addAttribute("message",message);
				return "billetConfirm";
			}
			
	}

}
