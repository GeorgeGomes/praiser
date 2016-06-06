package com.seismaismais.praiser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BackgroundController {

	@RequestMapping(value="/admin/background", method = RequestMethod.GET)
	public String getBackground() {
		return "/admin/background";
	}
}