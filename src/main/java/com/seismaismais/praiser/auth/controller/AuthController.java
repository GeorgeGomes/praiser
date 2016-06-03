package com.seismaismais.praiser.auth.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seismaismais.praiser.auth.model.User;
import com.seismaismais.praiser.auth.service.AuthenticateService;

@Controller
public class AuthController {

	Logger logger = Logger.getLogger(AuthController.class);

	@Autowired
	private AuthenticateService authenticateService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "/login";
	}

	@RequestMapping(value = "/authentication", method = RequestMethod.POST)
	public String authentication(@ModelAttribute User user, ModelMap model, HttpServletRequest request) {
		String requestUrl = "/login";
		try {
			User userAuth = authenticateService.authenticate(user.getEmail(), user.getPassword());
			authenticateService.saveUserRequest(userAuth);

			DefaultSavedRequest savedRequest = (DefaultSavedRequest) request.getSession()
					.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
			if (savedRequest == null) {
				return "redirect:/";
			}
			requestUrl = savedRequest.getServletPath();
		} catch (AuthenticationException e) {
			model.addAttribute("error", "O e-mail e a senha que você digitou não coincidem.");
		}
		return "redirect:" + requestUrl;
	}

	@RequestMapping(value = "/logoff", method = RequestMethod.GET)
	public String logoff() {
		authenticateService.logout();
		authenticateService.removeUserRequest();
		return "redirect:/";
	}
}