package com.comp303.lab2.Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProgramRepository programRepository;
	
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String processCheckout(HttpServletRequest request, HttpServletResponse response) {
		final LocalDate dt = LocalDate.parse(request.getParameter("pgmDate"), dtf); 
		//Get customer by userName
		Customer custObj = customerRepository.findByUserName(request.getParameter("username"));
		//Get program by program code
		Program pgmObj = programRepository.getById(request.getParameter("pgmCode"));
		Enrollment enroll = new Enrollment(custObj, pgmObj, dt, Double.parseDouble(request.getParameter("pgmFees")), "A");
		enroll = enrollmentRepository.save(enroll);
		return "redirect:/confirm/" + enroll.getApplicationNo();
	}
	
	@RequestMapping("/confirm/{enrollId}")
	public ModelAndView getLogin(@PathVariable("enrollId") int id,
									HttpServletRequest request, HttpServletResponse response) {		Enrollment enrollment;
		try {
			enrollment = enrollmentRepository.getById(id);
			Customer customer = enrollment.getCustomer();
			Program program = enrollment.getProgram();
			ModelAndView mview = new ModelAndView("confirmation");
			mview.addObject("Name", customer.getLastName() + ", " + customer.getFirstName());
			mview.addObject("ProgramName", program.getProgramName());
			mview.addObject("Code", program.getProgramCode());
			mview.addObject("Date", enrollment.getStartDate().format(dtf));
			mview.addObject("Paid", enrollment.getAmountPaid());
			
			return mview;
		}catch(Exception ex) {
			System.out.print(ex);
		}
		
		return null;
	}
}
