package com.TISpjh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.TISpjh.model.DataDto;

@Controller
public class TestController {
	
	// 
	
	
	@GetMapping("/Test01.do")
	public String Test01(HttpServletRequest request) {

		request.setAttribute("data01", "나는 data01");
		return "forward:/Sub01.do";
	}
	
	@GetMapping("/Sub01.do")
	public String sub01(HttpServletRequest request) {
		String data01 = (String)request.getAttribute("data01");
		System.out.println(data01);
		return "sub01";
	}

	// 02   제일 많이 사용... modle → request
	@GetMapping("/Test02.do")
	public String Test02(Model model) {

		model.addAttribute("data02", "나는 data02");
		return "forward:/Sub02.do";
	}
	
	// model에 실어 보내도 받을땐 request로 받는다
	@GetMapping("/Sub02.do")
	public String sub02(HttpServletRequest request) {
		String data02 = (String)request.getAttribute("data02");
		System.out.println(data02);
		return "sub02";
	}
	
	// 03    mav 는 형태가 조금 특이함...
	@GetMapping("/Test03.do")
	public ModelAndView Test03(ModelAndView mav) {

		mav.addObject("data03", "나는 data03");
		mav.setViewName("forward:/Sub03.do");
		return mav; 
	}
	
	// model에 실어 보내도 받을땐 request로 받는다
	@GetMapping("/Sub03.do")
	public String sub03(HttpServletRequest request) {
		String data03 = (String)request.getAttribute("data03");
		System.out.println(data03);
		return "sub03";
	}
	
	
	// 04   
	@GetMapping("/Test04.do")
	public String Test04(Model model) {
		DataDto dataDto = new DataDto();
		dataDto.setdata01("dataDto data01");
		dataDto.setdata02("dataDto data02");
		model.addAttribute("dataDto", dataDto);
		return "forward:/Sub04.do"; 
	}
	
	// model에 실어 보내도 받을땐 request로 받는다
	@GetMapping("/Sub04.do")
	public String sub04(HttpServletRequest request) {
		DataDto dataDto = (DataDto) request.getAttribute("dataDto");
		System.out.println(dataDto.toString());
		return "sub04";
	}
	
	// 05   
	@GetMapping("/Test05.do")
	//public String Test05(DataDto dataDto) {
	public String Test05(@ModelAttribute("dataDto") DataDto dataDto) {
		dataDto.setdata01("ModelAttribute dataDto data01");
		dataDto.setdata02("ModelAttribute dataDto data02");
		return "forward:/Sub05.do"; 
	}
	
	// model에 실어 보내도 받을땐 request로 받는다
	@GetMapping("/Sub05.do")
	public String sub05(HttpServletRequest request) {
		DataDto dataDto = (DataDto) request.getAttribute("dataDto");

	// model에 실어 보내도 받을땐 request로 받는다
//	public String sub05(DataDto dataDto) {
		System.out.println(dataDto.toString());
		return "sub05";
	}
}
