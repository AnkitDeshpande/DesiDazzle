package com.desidazzle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desidazzle.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
	/**
	 * 
	 * @param username
	 * @return customer if exist
	 */
	Optional<Customer> findByUsernameIgnoreCase(String username);

	/**
	 * 
	 * @param email
	 * @return customer if exist
	 */
	Optional<Customer> findByEmailIgnoreCase(String email);

}
