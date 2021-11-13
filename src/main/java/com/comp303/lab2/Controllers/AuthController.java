package com.comp303.lab2.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String getLogin(Model model) {
		model.addAttribute("partial", "login");
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLogin(HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		
		String username = request.getParameter("username").toLowerCase();
		String password = request.getParameter("password");
		
		long count = customerRepository.countByUserNameAndPassword(username, password);
		
		if(count == 0)
		{
			session.setAttribute("loginError", "Invalid Username");
			return "redirect:/login";
		}
		
		session.setMaxInactiveInterval(900);
		session.setAttribute("username", username);
		return "redirect:/programs";
	}
	
	@RequestMapping("/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	@RequestMapping("/register")
	public String getRegister(Model model) {
		model.addAttribute("partial", "register");
		return "index";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegister(HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		//TODO: Add Validation for confirm password
		try {
			String password = request.getParameter("password");
			String confirm = request.getParameter("confirmpassword");
			if(!password.equals(confirm))
				throw new Exception("Passwords Mismatched!");
			
			Customer customer = new Customer(
						request.getParameter("username").toLowerCase(),
						request.getParameter("firstname"),
						request.getParameter("lastname"),
						request.getParameter("password")
					);
		
			customerRepository.save(customer);
			return "redirect:/login";
		}catch(DataIntegrityViolationException ex) {
			session.setAttribute("registrationError", "Username already exists");
		}catch(Exception ex) {
			session.setAttribute("registrationError", ex.getMessage());
		}
		
		session.setAttribute("username", request.getParameter("username"));
		session.setAttribute("firstname", request.getParameter("firstname"));
		session.setAttribute("lastname", request.getParameter("lastname"));
		return "redirect:/register";
	}
	
	@RequestMapping("/profile")
	public String getProfile(Model model, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		String username = (String) session.getAttribute("username");
		
		if(username == null) {
			return "redirect:/login";
		}
		
		Customer customer = customerRepository.findByUserName(username);
		model.addAttribute("partial", "profile");
		model.addAttribute("customer", customer);
		return "index";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String updateProfile(HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		String username = (String) session.getAttribute("username");
		if(username == null) {
			return "redirect:/login";
		}
		
		Customer customer = customerRepository.findByUserName(username);
		customer.setFirstName(request.getParameter("firstname"));
		customer.setLastName(request.getParameter("lastname"));
		customer.setAddress(request.getParameter("address"));
		customer.setCity(request.getParameter("city"));
		customer.setPostalCode(request.getParameter("postalcode"));
		
		customerRepository.save(customer);
		session.setAttribute("updateNotification", "Profile Updated!");
		return "redirect:/profile";
	}
}
