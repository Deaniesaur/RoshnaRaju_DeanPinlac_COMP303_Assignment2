package com.comp303.lab2.Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.comp303.lab2.Models.Customer;
import com.comp303.lab2.Models.Enrollment;
import com.comp303.lab2.Models.Program;
import com.comp303.lab2.Repositories.CustomerRepository;
import com.comp303.lab2.Repositories.EnrollmentRepository;
import com.comp303.lab2.Repositories.ProgramRepository;

@Controller
public class CheckoutController {
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProgramRepository programRepository;
	
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public ModelAndView processCheckout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mview = null;
		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		final LocalDate dt = LocalDate.parse(request.getParameter("pgmDate"), dtf); 

		//double pgmFees = Double.parseDouble(request.getParameter("pgmFees"));
		List<Customer> customerList = customerRepository.findAll();
		int custId = 0;
		Customer custObj = null;
		for (Customer customer : customerList) {
			if(customer.getUserName().equalsIgnoreCase(request.getParameter("username"))) {
				custId = customer.getCustomerId();
				custObj = customer;
			}
		}
		
		List<Program> pgmList = programRepository.findAll();
		Program pgmObj = null;
		for (Program program : pgmList) {
			if(program.getProgramCode().equalsIgnoreCase(request.getParameter("pgmCode"))) {
				pgmObj = program;
			}
		}
		Enrollment enroll = new Enrollment(custObj, pgmObj, dt, Double.parseDouble(request.getParameter("pgmFees")), "A");
		enrollmentRepository.save(enroll);
		//mview.addObject("custId", custId);
		mview = new ModelAndView("confirmation");
		return mview;
	}
	
}
