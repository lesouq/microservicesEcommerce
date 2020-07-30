package com.thelem.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thelem.microservice.entity.Commande;

@Repository
public interface CommandesRepository extends JpaRepository<Commande, Integer> {

}
