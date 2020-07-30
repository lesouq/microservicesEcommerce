package com.thelem.microservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;

@Entity
public class Paiement {

	@Id
	@GeneratedValue
	
	private int id;
	
	@Column(unique = true)
	private Integer idCommande;
	private Integer montant;
	private Long numeroCarte;


	public Paiement() {
	}

	public Paiement(int id, Integer idCommande, Integer montant, Long numeroCarte) {
		this.id= id;
		this.idCommande= idCommande;
		this.setMontant(montant);
		this.setNumeroCarte(numeroCarte);
	}

	public Integer getMontant() {
		return montant;
	}

	public void setMontant(Integer montant) {
		this.montant = montant;
	}

	public Long getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(Long numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	public int getIdCommande() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Paiement save(Paiement paiement) {
		// TODO Auto-generated method stub
		return null;
	}
}