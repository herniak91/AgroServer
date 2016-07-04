package com.hwilliams.agroServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="test")
public class Test {

	@RequestMapping(value = "form")
	public ModelAndView getInfo() {
		return new ModelAndView("index");
	}
}