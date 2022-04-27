package com.TISpjh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@GetMapping("/Test01.do")
	public String test01() {
		return "test01";
	}
	
	@GetMapping("/Test02.do")
	public String test02(HttpServletRequest request) {
		request.setAttribute("msg", "hello spring");
		return "test02";
	}
	
	@GetMapping("/Test03.do")  // 요즘 많이 쓰는 방식
	public String test03(Model model) {
		// request 에 데이터가 담겨있다. 
		//data 를 jsp 에 넘겨야 한다
		model.addAttribute("msg", "검은호랑이의 해 콩콩절..");
		model.addAttribute("data", "2022.02.22");
		return "test03";
	}
	
	@GetMapping("/Test04.do")  // 요즘 많이 안쓰는 방식
	public ModelAndView test04(ModelAndView mav) {
		// request 에 데이터가 담겨있다.
		mav.addObject("msg", "검은호랑이의 해 콩콩절..");
		mav.addObject("data", "2022.02.22");
		mav.setViewName("test04");    // view 페이지를 따로 지정해야함..
		return mav;
	}
}
