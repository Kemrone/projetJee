package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Billet;
import com.example.demo.entities.Utilisateur;

public interface BilletRepository extends JpaRepository<Billet,Long>{

	
	@Query("SELECT b FROM Billet b WHERE b.bId= ?1")
	public Billet find( Long Bid);
	/*
	@Modifying
	@Query("update Billet b set b.b_critere = :bCritere, b.b_tarif = :bTarif, b.stock = :stock where b.b_id = :bId")
	void setUserInfoById(String bCritere, String bTarif, Long bId);
	*/
}
