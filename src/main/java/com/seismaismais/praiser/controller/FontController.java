package com.seismaismais.praiser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FontController {

	@RequestMapping(value="/admin/font", method = RequestMethod.GET)
	public String getFont() {
		return "/admin/font";
	}
}