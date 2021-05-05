package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Achat;

public interface AchatRepository extends JpaRepository<Achat,Long>{
/*
	@Query("insert into achat (date, quantite, id) values (?1, ?2, ?3)")
	public void acheter(String date, String quantite, Long id, Long bId, Long uId);
	*/
}
