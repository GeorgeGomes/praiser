package com.seismaismais.praiser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MySlidesController {

	@RequestMapping(value="/mySlides", method = RequestMethod.GET)
	public String getMySlides() {
		return "/mySlides";
	}
}