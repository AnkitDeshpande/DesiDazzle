package com.desidazzle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desidazzle.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
