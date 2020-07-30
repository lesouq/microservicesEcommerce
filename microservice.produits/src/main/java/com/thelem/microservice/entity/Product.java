package com.thelem.microservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "representation")
    private String representation;

    @Column(name = "image")
    private String image;

    @Column(name = "prix")
    private Double prix;


    public Product() {
    }

    public Product(int id, String titre, String representation, String image, Double prix) {
        this.id = id;
        this.titre = titre;
        this.representation = representation;
        this.image = image;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
   }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", representation='" + representation + '\'' +
                ", image='" + image + '\'' +
                ", prix=" + prix +
                '}';
    }


}
