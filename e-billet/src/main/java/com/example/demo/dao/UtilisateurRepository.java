package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long>{
	
	@Query("SELECT u FROM Utilisateur u WHERE u.uLastname = ?1 AND u.password = ?2 ")
	public Utilisateur checkUserConnection( String uLastname,String password);

	

}
