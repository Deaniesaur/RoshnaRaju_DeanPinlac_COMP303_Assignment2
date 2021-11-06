package com.comp303.lab2.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Program {
	@Id
	private String programCode;
	private String programName;
	private long duration;
	private double fee;
}
