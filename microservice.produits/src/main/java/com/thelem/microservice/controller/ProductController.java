package com.thelem.microservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.thelem.microservice.entity.Product;
import com.thelem.microservice.exception.ProductNotFoundException;
import com.thelem.microservice.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    // Affiche la liste de tous les produits disponibles
    @GetMapping("/")
    public List<Product> listeDesProduits(){

        List<Product> products = productRepository.findAll();

        if(products.isEmpty()) throw new ProductNotFoundException("Aucun produit n'est disponible à la vente");

        return products;

    }

    //Récuperer un produit par son id
    @GetMapping( value = "/Produits/{id}")
    public Optional<Product> recupererUnProduit(@PathVariable int id) {

        Optional<Product> product = productRepository.findById(id);

        if(!product.isPresent())  throw new ProductNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas");

        return product;
    }
}
