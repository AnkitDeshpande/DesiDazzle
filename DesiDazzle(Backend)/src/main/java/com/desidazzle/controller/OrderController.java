package com.desidazzle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desidazzle.model.Customer;
import com.desidazzle.model.WebOrder;
import com.desidazzle.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping
	public List<WebOrder> getOrders(@AuthenticationPrincipal Customer user) {
		return orderService.getOrders(user);
	}
}
