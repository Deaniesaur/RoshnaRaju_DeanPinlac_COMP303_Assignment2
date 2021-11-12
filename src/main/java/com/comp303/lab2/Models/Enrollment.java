package com.comp303.lab2.Models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Enrollment {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int applicationNo;
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@OneToOne
	@JoinColumn(name = "program_code")
	private Program program;
	private LocalDate startDate;
	private double amountPaid;
	private String status;
	
	public Enrollment(Customer customer, Program program, LocalDate startDate, double amountPaid, String status) {
		super();
		this.customer = customer;
		this.program = program;
		this.startDate = startDate;
		this.amountPaid = amountPaid;
		this.status = status;
	}
	
	
}
