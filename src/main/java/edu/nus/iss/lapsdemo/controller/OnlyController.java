package edu.nus.iss.lapsdemo.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.nus.iss.lapsdemo.javabean.UserSession;
import edu.nus.iss.lapsdemo.model.Employee;
import edu.nus.iss.lapsdemo.model.LeaveRecord;
import edu.nus.iss.lapsdemo.service.LeaveService;

@Controller
@SessionAttributes("session")
public class OnlyController {
	@Autowired
	private LeaveService lService;
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView Login(@ModelAttribute Employee employee) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("employee", new Employee());
		return mav;
	}
	
	@RequestMapping(path = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute Employee employee, HttpSession session) {
		ModelAndView mav = new ModelAndView("apply");
		Employee emp = lService.authenticate(employee.getEmpName(), employee.getPwd());
		UserSession us = new UserSession();
		us.setEmployee(emp);
		session.setAttribute("US", us);
		mav.addObject("leave", new LeaveRecord());
		return mav;
	}
}
