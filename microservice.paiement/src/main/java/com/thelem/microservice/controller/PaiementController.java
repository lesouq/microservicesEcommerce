package com.thelem.microservice.controller;

import com.microservice.exceptions.PaiementExistantException;
import com.microservice.exceptions.PaiementImpossibleException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.thelem.microservice.entity.Paiement;
import com.thelem.microservice.repository.PaiementRepository;



@RestController

public class PaiementController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	PaiementRepository paiementRepository;
	
	@PostMapping(value = "/paiement")
	public ResponseEntity<Paiement> payerUneCommande(@RequestBody Paiement paiement){
		
		//Vérifions s'il y a déjà un paiement enregistré pour cette commande
		Paiement paiementExistant = paiementRepository.findByidCommande(paiement.getIdCommande());
		if(paiementExistant != null) throw new PaiementExistantException("Cette commande est déjà payée");
		
		//Enregistrer le paiement
		Paiement nouveauPaiement = paiement.save(paiement);
		if(nouveauPaiement == null) throw new PaiementImpossibleException("Erreur, impossible d'établir le paiement, réessayer plus tard");
		
		 //TODO Nous allons appeler le Microservice Commandes ici pour lui signifier que le paiement est accepté
		return new ResponseEntity<Paiement>(nouveauPaiement, HttpStatus.CREATED);
	}
	
	@GetMapping("/paiement/{idCommande}")
	@HystrixCommand(fallbackMethod = "fallback_getReviews", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMillisecods", value = "1000")
	})
	
        
	private List<Paiement> fallback_getReviews(int idCommande){
		System.out.println("getReviews fallback: productpage temporarilu unavailable");
		return Arrays.asList();
	}
	
	public List<Paiement> fallback_paiement(@PathVariable int idCommande){
		//log.debug("fallback_paiement called");
		return null;
	}
}
