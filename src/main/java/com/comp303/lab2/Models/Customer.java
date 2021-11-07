package com.comp303.lab2.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	@Column(unique = true)
	@Size(min = 3, max = 15)
	private String userName;
	private String password;
	private String firstName;
	private String lastName; 
	private String address;
	private String city;
	private String postalCode;
	
	public Customer(String userName, String firstName, String lastName, String password) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
}
