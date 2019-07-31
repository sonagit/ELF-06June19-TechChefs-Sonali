package com.techchefs.emp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techchefs.emp.dto.UserBean;

@Controller
@RequestMapping("/forms")
public class FormSubmitController {
	
	@GetMapping(path="/getForm")
	public String getForm() {
		return "myForm";
	}
	@PostMapping(path="/formsubmit")
	public String formsubmit(HttpServletRequest req) {
		int userId = Integer.parseInt(req.getParameter("userId"));
		String password = req.getParameter("password");
		
		req.setAttribute("userId",userId );
		req.setAttribute("password",password );
		
		return "formDataDisplay";
	}
	@PostMapping(path="/formsubmit2")
	public String formsubmit2(int userId, String password, ModelMap modalMap) {
		
		modalMap.addAttribute("userId", userId);
		modalMap.addAttribute("password", password);
		
		return "formDataDisplay";
	}
	@PostMapping(path="/submitform3")
	public String submitform3(UserBean userBean, ModelMap modalMap) {
		modalMap.addAttribute("userBean", userBean); 
		return "formDataDisplay";
	}
	@PostMapping(path="/submitform4")
	public String submitform4(@RequestParam(name="userId") int uId, @RequestParam(name="password") String pwd, ModelMap modalMap) {
		modalMap.addAttribute("userId", uId); 
		modalMap.addAttribute("password", pwd); 
		
		return "formDataDisplay";
	}
	@PostMapping(path="/submitform5")
	public String submitform5(@RequestParam(name="userId") int uId, @RequestParam(name="password") String pwd, ModelMap modalMap) {
		modalMap.addAttribute("userId", uId); 
		modalMap.addAttribute("password", pwd); 
		
		return "formDataDisplayEL";
	}
	@PostMapping(path="/submitform6")
	public String submitform6(UserBean userBean, ModelMap modalMap) {
		modalMap.addAttribute("userBean", userBean); 
		
		
		return "formDataDisplayEL";
	}
	@GetMapping(path="/getempForm")
	public String getempForm() {
		return "Login";
	}
	@PostMapping(path="/submitemp")
	public String submitemp(int userId, String password, ModelMap modalMap) {
		
		modalMap.addAttribute("userId", userId);
		modalMap.addAttribute("password", password);
		
		return "home";
	}
}