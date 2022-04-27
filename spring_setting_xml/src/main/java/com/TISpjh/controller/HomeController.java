package com.TISpjh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 알림표시.. 컨트롤러!라는 알림..
public class HomeController {
	// spring이 로딩과 함께 스캔.. > controller 로 인식시킴
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String home() {
		//business logic이 들어감..
		System.out.println("index");
		return "index"; //return 되는 페이지... 
	}
	
	@GetMapping(value = "/sub")
	public String sub() {
		System.out.println("sub");
		return "sub"; //return 되는 페이지... 
		
	}
}
