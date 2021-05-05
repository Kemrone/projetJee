package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.UtilisateurRepository;
import com.example.demo.entities.Utilisateur;


@Controller
public class LoginController {
	
	@Autowired
	private UtilisateurRepository userRep;
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET )
	public String loginIndex(Model model) {
	
		
			return "login";
	}
	
	
	@RequestMapping(value = {"/redirect"} )
	public String login( RedirectAttributes attributes,Model model,@Param("usermail") String usermail,@Param("password") String password) {
		String returnUrl ="";
		String message = "Id incorrects.";
		Utilisateur u = userRep.checkUserConnection(usermail, password);
		if(u!=null) {
			if(u.getRole().getrId() == 0L) {
				model.addAttribute("user",u);
				attributes.addFlashAttribute("user", u);	
				returnUrl= "redirect:home";
			
			}
			else if(u.getRole().getrId() == 1L) {
				model.addAttribute("user",u);
				attributes.addFlashAttribute("user", u);
	
				returnUrl= "redirect:admin";
			}
			else {
				model.addAttribute("message", message);
				returnUrl= "login";
				
			}
		}		
		return returnUrl;
		
	}

}
