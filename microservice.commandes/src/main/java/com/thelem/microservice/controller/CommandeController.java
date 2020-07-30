package com.thelem.microservice.controller;

import com.thelem.microservice.repository.CommandesRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.thelem.microservice.entity.Commande;
import com.thelem.microservice.exceptions.CommandeNotfoundException;
import com.thelem.microservice.exceptions.ImpossibleAjouterCommandeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CommandeController {

	@Autowired
	RestTemplate restTemplate;
	
    @Autowired
    CommandesRepository commandesRepository;

    @PostMapping (value = "/commandes")
    public ResponseEntity<Commande> ajouterCommande(@RequestBody Commande commande){

        Commande nouvelleCommande = commandesRepository.save(commande);

        if(nouvelleCommande == null) throw new ImpossibleAjouterCommandeException("Impossible d'ajouter cette commande");

        return new ResponseEntity<Commande>(commande, HttpStatus.CREATED);
    }

    @GetMapping(value = "/commandes/{id}")
    public Optional<Commande> recupererUneCommande(@PathVariable int id){

        Optional<Commande> commande = commandesRepository.findById(id);

        if(!commande.isPresent()) throw new CommandeNotfoundException("Cette commande n'existe pas");

        return commande;
    }
    
    @GetMapping("/commandes")
    @HystrixCommand(fallbackMethod = "fallback_front", commandProperties = {
    	@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")	
    })
    
    public String fallback_front (HttpServletRequest request, Model model) {
    	System.out.println("frontfallback called...");
    	return "commandes";
    }
}
