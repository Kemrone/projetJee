package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement,Long> {
	
	@Query("SELECT e FROM Evenement e INNER JOIN  e.type "
			+ "INNER JOIN e.acceuil a "
			+ "INNER JOIN a.lieu  "
			
			+ " WHERE CONCAT(e.eName, e.type.tName, a.lieu.lAddress) LIKE %?1%")
	public List<Evenement> search(String keyword);
	
	/*
	@Modifying
	@Query("insert into Evenement (eName,tId) VALUES (:eName,:tId)")	
	public void saveEvent(String eName, String tId);
	*/
}
