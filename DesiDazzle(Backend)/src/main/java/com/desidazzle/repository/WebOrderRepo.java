package com.desidazzle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desidazzle.model.Customer;
import com.desidazzle.model.WebOrder;

public interface WebOrderRepo extends JpaRepository<WebOrder, Long> {
	List<WebOrder> findByUser(Customer user);
}
