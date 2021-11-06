package com.comp303.lab2.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Customer {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName; 
	private String address;
	private String city;
	private String postalCode;
}
