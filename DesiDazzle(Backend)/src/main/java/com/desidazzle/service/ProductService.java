package com.desidazzle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desidazzle.model.Product;
import com.desidazzle.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	public List<Product> getProducts() {
		return productRepo.findAll();
	}
}
