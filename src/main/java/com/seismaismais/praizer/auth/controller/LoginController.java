package com.seismaismais.praizer.auth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
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
		return "/login";
	}

	@RequestMapping(value = "/authentication", method = RequestMethod.POST)
	public String getAuth(@ModelAttribute User user, ModelMap model, HttpServletRequest request) {
		String requestUrl = "/login";
		try{
			User userAuth = authenticateService.authenticate(user.getEmail(), user.getPassword());
			authenticateService.saveObjectRequest(userAuth, request);

			DefaultSavedRequest savedRequest = (DefaultSavedRequest) request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
			requestUrl =  savedRequest.getServletPath();
		}catch(AuthenticationException e){
			model.addAttribute("error", "O e-mail e a senha que você digitou não coincidem.");
		}
		return "redirect:" + requestUrl;
	}
}