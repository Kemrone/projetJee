package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.*;
import com.example.demo.entities.*;

@EntityScan(basePackages = {"com.example.demo.entities"})
@SpringBootApplication
public class EBilletApplication implements CommandLineRunner {

	@Autowired
	private BilletRepository billetRep;
	@Autowired
	private UtilisateurRepository userRep;
	@Autowired
	private LieuRepository lieuRep;
	@Autowired
	private EvenementRepository eventRep;
	@Autowired
	private AcceuilRepository accRep;
	@Autowired
	private TypeRepository typeRep;
	
	public static void main(String[] args) {
		
		SpringApplication.run(EBilletApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		//Billet b = billetRep.save(new Billet("critere1","12",null,null));
		Type t = new Type("type2");
		Evenement e = new Evenement("event1",t);
		Lieu l = new Lieu("Endroit1","adress1");
		AcceuilKey aKey = new AcceuilKey();
		Acceuil a = new Acceuil();
			
		//l = lieuRep.save(l);
		t = typeRep.save(t);
		e = eventRep.save(e);
		
		
		var val2 = 1L;
		var val = billetRep.findById(val2);
		 if (val.isPresent()) {
	            System.out.println(val.get().getbTarif());
	        } 
	*/
		
		
	}
	
	
	

}
