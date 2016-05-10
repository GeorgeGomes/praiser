package com.seismaismais.praizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SlidesController {

	@RequestMapping(value="/slides", method = RequestMethod.GET)
	public String getSlides() {
		return "slides";
	}
}