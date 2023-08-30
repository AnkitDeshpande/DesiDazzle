package com.desidazzle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desidazzle.model.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {
	List<Address> findByUser_Id(Long id);
}
