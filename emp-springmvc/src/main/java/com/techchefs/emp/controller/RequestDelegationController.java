package com.techchefs.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Controller
@RequestMapping("/deligate")
public class RequestDelegationController {
	
	@GetMapping("/getHomePage")
	public String getHomePage() {
		return "homepage";
	}// End of getHomePage

	@GetMapping("/forwardReq")
	public String forwardReq() {
		return "forward:/forms/getForm";
	}// End of forwardReq
	
	@GetMapping("/redirectReq")
	public String redirectReq() {
		return "redirect:https://www.google.com";
	}// End of forwardReq

} //End of controller
