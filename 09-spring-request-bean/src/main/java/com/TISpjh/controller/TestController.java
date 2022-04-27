package com.TISpjh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.TISpjh.model.DataDto;
import com.TISpjh.model.DataDto02;
import com.TISpjh.model.MemberDto;

@Controller
public class TestController {
	
	// 자동 주입!
	@Autowired
	DataDto dataDto;
	
	@Autowired
	MemberDto memberDto;
	
	//직접 bean을 등록해서 Component를 입력하지 않더라도 주입은 받아야함..
	@Autowired
	DataDto02 dataDto02;
	
	@GetMapping("/Test01.do")
	public String test01( ) {
		
		dataDto.setdata01("자동주입된 DataDto 의 속성 data01!");
		dataDto.setdata02("자동주입된 DataDto 의 속성 data02!");
		
		return "forward:Sub01.do";
	}
	
	@GetMapping("/Sub01.do")
	public String sub01(Model model) {
		
		model.addAttribute("dataDto", dataDto);
		
		return "sub01";
	}
	
	@GetMapping("/Test02.do")
	public String test02() {
		
		dataDto.setdata01("직접입력 후 주입된 DataDto 의 속성 data01!");
		dataDto.setdata02("직접입력 후 주입된 DataDto 의 속성 data02!");
		
		dataDto02.setData03("직접입력 후 주입된 DataDto02 의 속성 data03!");
		dataDto02.setData04("직접입력 후 주입된 DataDto02 의 속성 data04!");
		
		return "forward:Sub02.do";
	}
	
	@GetMapping("/Sub02.do")
	public String sub02(Model model) {
		
		model.addAttribute("dataDto", dataDto);
		model.addAttribute("dataDto02", dataDto02);
		return "sub02";
	}
}
