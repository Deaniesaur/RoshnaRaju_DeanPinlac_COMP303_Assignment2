package com.comp303.lab2.Models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Enrollment {
	@Id
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
}
