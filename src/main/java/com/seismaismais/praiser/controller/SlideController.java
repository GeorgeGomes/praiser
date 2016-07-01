package com.seismaismais.praiser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SlideController {

	@RequestMapping(value="/slide/new", method = RequestMethod.GET)
	public String getSlides() {
		return "/slide/new";
	}
	
	@RequestMapping(value="/slide/{id}", method = RequestMethod.GET)
	public String getSlides1(@PathVariable("id") long id) {
		return "/slide/edit";
	}
	
}