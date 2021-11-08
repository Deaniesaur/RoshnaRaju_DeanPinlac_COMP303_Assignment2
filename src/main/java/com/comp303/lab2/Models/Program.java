package com.comp303.lab2.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Program {
	@Id
	private String programCode;
	private String programName;
	private long duration;
	private double fee;
	
	
	public Program(String programCode, String programName, long duration, double fee) {
		super();
		this.programCode = programCode;
		this.programName = programName;
		this.duration = duration;
		this.fee = fee;
	}

	public Program() {
		super();
	}

	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
}
