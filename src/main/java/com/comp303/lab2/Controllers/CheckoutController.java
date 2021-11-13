package com.comp303.lab2.Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.comp303.lab2.Models.Customer;
import com.comp303.lab2.Models.Enrollment;
import com.comp303.lab2.Models.Program;
import com.comp303.lab2.Repositories.CustomerRepository;
import com.comp303.lab2.Repositories.EnrollmentRepository;
import com.comp303.lab2.Repositories.ProgramRepository;

@Controller
public class CheckoutController {
	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProgramRepository programRepository;
	
	@RequestMapping("/checkout")
	public String proceedToCheckout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("partial", "checkout");
		return "index";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String processCheckout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		try {
			LocalDate dt = LocalDate.parse((String) session.getAttribute("pgmDate"), dtf); 
			//Get customer by userName
			Customer custObj = customerRepository.findByUserName((String) session.getAttribute("username"));
			//Get program by program code
			Program pgmObj = programRepository.getById((String) session.getAttribute("pgmCode"));
			Enrollment enroll = new Enrollment(custObj, pgmObj, dt, (Double) session.getAttribute("pgmFees"), "A");
			enroll = enrollmentRepository.save(enroll);

			//Enrollment Success, remove session attributes for program
			session.removeAttribute("pgmName");
			session.removeAttribute("pgmDuration");
			session.removeAttribute("pgmCode");
			session.removeAttribute("pgmFees");
			session.removeAttribute("pgmDate");
			
			return "redirect:/confirm/" + enroll.getApplicationNo();
		}catch(Exception ex) {
			session.setAttribute("checkoutError", ex.getMessage());
		}
		
		return "redirect:/checkout";
	}
	
	@RequestMapping("/confirm/{enrollId}")
	public String confirm(@PathVariable("enrollId") int id, HttpSession session,
			HttpServletRequest request) {
		
		try {
			Enrollment enrollment = enrollmentRepository.getById(id);
			Customer customer = enrollment.getCustomer();
			Program program = enrollment.getProgram();
			
			if(!customer.getUserName().equals(session.getAttribute("username")))
				throw new Exception("Invalid Access");
			
			request.setAttribute("Name", customer.getLastName() + ", " + customer.getFirstName());
			request.setAttribute("ProgramName", program.getProgramName());
			request.setAttribute("Code", program.getProgramCode());
			request.setAttribute("Duration", program.getDuration() + " Months");
			request.setAttribute("Date", DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(enrollment.getStartDate()));
			request.setAttribute("Paid", enrollment.getAmountPaid());

			request.setAttribute("partial", "confirmation");
			return "index";
		}catch(Exception ex) {
			session.setAttribute("confirmError", ex.getMessage());
		}
		
		return "redirect:/checkout";
	}
}
