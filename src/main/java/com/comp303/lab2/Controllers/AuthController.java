package com.comp303.lab2.Controllers;

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
import com.comp303.lab2.Repositories.CustomerRepository;

@Controller
public class AuthController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping({"/", "/login"})
	public ModelAndView getLogin() {
		ModelAndView mview = new ModelAndView("index");
		return mview;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView processLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mview;
		
		String username = request.getParameter("username").toLowerCase();
		String password = request.getParameter("password");
		
		long count = customerRepository.countByUserNameAndPassword(username, password);
		
		if(count == 0)
		{
			mview = new ModelAndView("index");
			mview.addObject("username", username);
			mview.addObject("errorMessage", "Invalid Username");
		}else {
			mview = new ModelAndView("program");
			mview.addObject("username", username);
			mview.addObject("errorMessage", "Succesfully Logged In");
		}
		
		return mview;
	}

	@RequestMapping("/register")
	public ModelAndView getRegister() {
		ModelAndView mview = new ModelAndView("register");
		return mview;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRegister(HttpServletRequest request, HttpServletResponse response) {
		//TODO: Add Validation for confirm password
		ModelAndView mview = new ModelAndView("register");
		
		Customer customer = new Customer(
					request.getParameter("username").toLowerCase(),
					request.getParameter("firstname"),
					request.getParameter("lastname"),
					request.getParameter("password")
				);
		
		try {
			customerRepository.save(customer);
		}catch(DataIntegrityViolationException ex) {
			mview.addObject("errorMessage", "Username already exists");
			return mview;
		}catch(Exception ex) {
			mview.addObject("errorMessage", ex.getClass());
			return mview;
		}
		
		mview = new ModelAndView("index");
		return mview;
	}
}
