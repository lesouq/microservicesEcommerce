package com.thelem.microservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thelem.microservice.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
}
