package com.TISpjh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.TISpjh.model.MemberDto;

@Controller
public class TestController {
	
//	public String test01(@ModelAttribute MemberDto memberDto)
	@GetMapping("Test01.do")
	public String test01(MemberDto memberDto) {
		memberDto.setNo(22);
		memberDto.setId("Yee");
		memberDto.setName("콩콩");
		memberDto.setPassword("222");
		
		return "test01";
	}
	
	@GetMapping("Test02.do")
	public String test02(MemberDto memberDto) {
		memberDto.setNo(22);
		memberDto.setId("test");
		memberDto.setName("yeeee");
		memberDto.setPassword("222");
		
		return "test02";
	}
	
	@GetMapping("Test03.do")
	public String test03(@ModelAttribute("myMember") MemberDto memberDto) {
		memberDto.setNo(22);
		memberDto.setId("test");
		memberDto.setName("yeeee");
		memberDto.setPassword("222");
		
		return "test03";
	}
	
	@GetMapping("Test04.do")
	public String test04(Model model) {
		MemberDto memberDto = new MemberDto();
		memberDto.setNo(22);
		memberDto.setId("test");
		memberDto.setName("yeeee");
		memberDto.setPassword("222");
		
		model.addAttribute("memberDto",memberDto);
		
		return "test04";
	}
}
