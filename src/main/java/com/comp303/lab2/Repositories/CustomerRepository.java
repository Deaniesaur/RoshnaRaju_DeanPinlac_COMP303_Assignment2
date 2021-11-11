package com.comp303.lab2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comp303.lab2.Models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	long countByUserNameAndPassword(String username, String password);
}
