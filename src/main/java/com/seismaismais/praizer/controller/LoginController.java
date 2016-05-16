package com.seismaismais.praizer.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seismaismais.praizer.auth.model.User;
import com.seismaismais.praizer.auth.service.AuthenticateService;

@Controller
public class LoginController {

	Logger logger = Logger.getLogger(LoginController.class);


	@Autowired
	private AuthenticateService authenticateService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {
		return "login";
	}

	@RequestMapping(value = "/authentication", method = RequestMethod.POST)
	public String getAuth(@ModelAttribute User user, ModelMap model, HttpServletRequest request) {	
		try{
			User user1 = authenticateService.authenticate(user.getEmail(), user.getPassword());
			request.getSession().setAttribute("user",user1);
		}catch(AuthenticationException e){
			model.addAttribute("error", "O e-mail e a senha que você digitou não coincidem.");
		}
		return "login";
	}



	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}