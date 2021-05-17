package com.example.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.*;
public interface AcceuilRepository extends JpaRepository<Acceuil,Long>{
	/*
	@Query("SELECT a FROM Acceuil a WHERE a.id.eId= ?1 AND a.id.lId = ?2")
	public Acceuil findAcceuil( Long e, Long l);
	*/
}
