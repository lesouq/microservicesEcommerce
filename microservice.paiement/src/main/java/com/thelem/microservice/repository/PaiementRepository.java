package com.thelem.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thelem.microservice.entity.Paiement;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Integer> {
	
	
	Paiement findByidCommande(int idCommande);

}
