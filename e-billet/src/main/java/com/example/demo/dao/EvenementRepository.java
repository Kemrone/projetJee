package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement,Long> {
	
	@Query("SELECT e FROM Evenement e INNER JOIN  e.type "
			+ "INNER JOIN e.acceuil a "
			+ "INNER JOIN a.lieu  "
			
			+ " WHERE CONCAT(e.eName, e.type.tName, a.lieu.lAddress) LIKE %?1%")
	public List<Evenement> search(String keyword);
	
	
/*
	@Query("SELECT e FROM Evenement e INNER JOIN Type t ON t.tId = e.tId "
			+ " INNER JOIN Accueil a ON a.eId = e.eId "
			+ " INNER JOIN Lieu l ON l.lId = a.lId  "
			+ " WHERE CONCAT(e.eName, l.lAddress, t.tName) LIKE %?1%")
			*/
}
