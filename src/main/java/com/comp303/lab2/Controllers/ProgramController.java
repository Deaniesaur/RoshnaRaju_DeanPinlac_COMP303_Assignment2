package com.comp303.lab2.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.comp303.lab2.Models.Program;
import com.comp303.lab2.Repositories.ProgramRepository;

@Controller
public class ProgramController {
	
	@Autowired
	private ProgramRepository programRepository;
	private String pgmCode ;
	private String username;
	@PostConstruct
	private void initializePrograms() {
		//Initialize Programs
		long programCount = programRepository.count();
		
		if(programCount == 0) {
		  List<Program> pgmList = new ArrayList<Program>();
		  pgmList.add(new Program("100","Yoga",6,100));
		  pgmList.add(new Program("101","Swimming",4,150));
		  pgmList.add(new Program("102","Bootcamp",3,200));
		  programRepository.saveAll(pgmList);
		}
	}

	@RequestMapping(value = "/enroll", method = RequestMethod.POST)
	public ModelAndView processEnroll(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mview;
		
		String program = request.getParameter("program");
		username = request.getParameter("username");
		if(null==program || "".equalsIgnoreCase(program))
		{
			mview = new ModelAndView("program");
			mview.addObject("errorMessageForPgm", "Please choose your program before proceeding");
		}else if(null == request.getParameter("pgmDate") || "".equalsIgnoreCase(request.getParameter("pgmDate"))){
			
			mview = new ModelAndView("program");
			mview.addObject("errorMessageForPgm", "Please choose your program start date before proceeding");
			
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
				pgmFees = pgm.get(0).getFee()+"";
				pgmCode = pgm.get(0).getProgramCode();
			}
			mview = new ModelAndView("enroll");
			mview.addObject("pgmName", pgmName);
			mview.addObject("pgmDuration", pgmDuration);
			mview.addObject("pgmFees", pgmFees);
			mview.addObject("pgmCode", pgmCode);
			mview.addObject("pgmDate", request.getParameter("pgmDate"));
		}
		
		return mview;
	}
	
	@RequestMapping("/programs")
	public ModelAndView programs() {
		
		ModelAndView mview = new ModelAndView("program");
		return mview;
	}
	
	@RequestMapping(value = "/proceed", method = RequestMethod.POST)
	public ModelAndView proceedToCheckout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mview;
		mview = new ModelAndView("checkout");
		mview.addObject("username", username);
		mview.addObject("pgmCode", request.getParameter("pgmCode"));
		mview.addObject("pgmDate", request.getParameter("pgmDate"));
		mview.addObject("pgmFees", request.getParameter("pgmFees"));
		
		return mview;
	}
}
