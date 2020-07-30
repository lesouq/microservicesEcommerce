package com.thelem.microservice.entity;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;

@Entity
public class Commande {
	
	@Id
	@GeneratedValue
	
	private int id;
	private Integer productId;
	private Date dateCommande;
	private Integer quantite;
	private Boolean commandePayer;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	public Boolean getCommandePayer() {
		return commandePayer;
	}
	public void setCommandePayer(Boolean commandePayer) {
		this.commandePayer = commandePayer;
	}
	
}
