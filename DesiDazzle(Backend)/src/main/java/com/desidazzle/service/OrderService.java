package com.desidazzle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desidazzle.model.Customer;
import com.desidazzle.model.WebOrder;
import com.desidazzle.repository.WebOrderRepo;

@Service
public class OrderService {
	@Autowired
	private WebOrderRepo webOrderRepo;

	public List<WebOrder> getOrders(Customer user) {
		return webOrderRepo.findByUser(user);
	}
	
}
