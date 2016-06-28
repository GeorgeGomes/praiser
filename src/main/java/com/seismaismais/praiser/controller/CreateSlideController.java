package com.seismaismais.praiser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreateSlideController {

	@RequestMapping(value="/createSlide/{id}", method = RequestMethod.GET)
	public String getSlides1(@PathVariable("id") long id) {
		return "/createSlide";
	}
	
	@RequestMapping(value="/createSlide", method = RequestMethod.GET)
	public String getSlides() {
		return "/createSlide";
	}
}