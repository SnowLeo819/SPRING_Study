package com.TISpjh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/",method=RequestMethod.GET)
	public String home() {
		System.out.println("main 페이지 -> redirect (List)");
//		return "index";
		return "redirect:/member/List.do";
	}
}
