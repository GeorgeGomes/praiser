package com.seismaismais.praiser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlayController {
	
	@RequestMapping(value="/play/{id}", method = RequestMethod.GET)
	public String getPlay(@PathVariable("id") long id) {
		return "/play";
	}
	
}