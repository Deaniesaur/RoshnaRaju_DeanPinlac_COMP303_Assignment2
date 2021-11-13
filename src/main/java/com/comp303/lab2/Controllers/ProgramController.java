package com.comp303.lab2.Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comp303.lab2.Models.Program;
import com.comp303.lab2.Repositories.ProgramRepository;

@Controller
public class ProgramController {
	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Autowired
	private ProgramRepository programRepository;
	
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
	
	@RequestMapping({"/", "/programs"})
	public String programs(Model model, HttpSession session) {
		session.setAttribute("pgmDate", LocalDate.now().format(dtf));
		model.addAttribute("partial", "program");
		return "index";
	}

	@RequestMapping(value = "/programs/detail")
	public String enroll(HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		String programCode = request.getParameter("program");
		String programDate = request.getParameter("pgmDate");
		
		try {
			Program pgm = programRepository.getById(programCode);
			if(pgm == null) {
				throw new Exception("Program not found!");
			}
			
			session.setAttribute("pgmName", pgm.getProgramName());
			session.setAttribute("pgmDuration", pgm.getDuration() + " Months");
			session.setAttribute("pgmFees", pgm.getFee());
			session.setAttribute("pgmCode", programCode);
			session.setAttribute("pgmDate", programDate);
			
			request.setAttribute("partial", "detail");
			return "index";
		}catch(Exception ex) {
			session.setAttribute("programError", ex.getMessage());
		}
		
		return "redirect:/program";
	}
}
