package com.comp303.lab2.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.comp303.lab2.Models.Customer;
import com.comp303.lab2.Models.Program;
import com.comp303.lab2.Repositories.CustomerRepository;
import com.comp303.lab2.Repositories.ProgramRepository;

@Controller
public class ProgramController {
	
	@Autowired
	private ProgramRepository programRepository;

	@RequestMapping(value = "/enroll", method = RequestMethod.POST)
	public ModelAndView processLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mview;
		
		String program = request.getParameter("program");
		
		if(null==program || "".equalsIgnoreCase(program))
		{
			mview = new ModelAndView("program");
			mview.addObject("errorMessageForPgm", "Please choose your program before proceeding");
		}else {
			List<String> idList = new ArrayList<String>();
			idList.add(program);
			String pgmName = null;
			String pgmDuration = null;
			String pgmFees = null;
			List<Program> pgm = programRepository.findAllById(idList);
			if(null!= pgm && pgm.size()>0) {
				pgmName =pgm.get(0).getProgramName();
				pgmDuration =pgm.get(0).getDuration()+" Months";
				pgmFees ="$"+pgm.get(0).getFee()+" Per Month";
			}
			mview = new ModelAndView("enroll");
			mview.addObject("pgmName", pgmName);
			mview.addObject("pgmDuration", pgmDuration);
			mview.addObject("pgmFees", pgmFees);
		}
		
		return mview;
	}
	
	@RequestMapping({"/back"})
	public ModelAndView getLogin() {
		
		ModelAndView mview = new ModelAndView("program");
		return mview;
	}
}
