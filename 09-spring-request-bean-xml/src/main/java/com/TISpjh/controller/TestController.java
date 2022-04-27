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
	DataDto02 dataDto02;
	
	@Autowired
	MemberDto memberDto;
	
	@GetMapping("/Test01.do")
	public String test01( ) {
		
		dataDto.setdata01("자동주입된 DataDto 의 속성 data01!");
		dataDto.setdata02("자동주입된 DataDto 의 속성 data02!");
		dataDto02.setdata0201("직접생성된 dataDto02 속성 중중 data0201");
		dataDto02.setdata0201("직접생성된 dataDto02 중 dat속상202");
		return "forward:Sub01.do";
	}
	
	@GetMapping("/Sub01.do")
	public String sub01(Model model) {
		
		model.addAttribute("dataDto", dataDto);
		
		return "sub01";
	}
	
	@GetMapping("/Test02.do")
	public String test02() {
		memberDto.setNo(1);
		memberDto.setName("콩콩");
		memberDto.setAge(22);
		return "forward:Sub02.do";
	}
	
	@GetMapping("/Sub02.do")
	public String sub02(Model model) {
		
		model.addAttribute("memberDto", memberDto);
		return "sub02";
	}
	
	@GetMapping("/Test03.do")
	public String test03() {
		memberDto.setNo(1);
		memberDto.setName("콩콩");
		memberDto.setAge(22);
		
		dataDto.setdata01("청년 희망적금~");
		dataDto.setdata02("첫주는 5부제 신청 받는다아ㅏㅏ~");
		
		return "forward:Sub03.do";
	}
	
	@GetMapping("/Sub03.do")
	public String sub03(Model model) {
		model.addAttribute("dataDto",dataDto);
		model.addAttribute("memberDto", memberDto);
		return "sub03";
	}

	
	@GetMapping("/Test04.do")
	public String test04() {
		memberDto.setNo(1);
		memberDto.setName("콩콩");
		memberDto.setAge(22);
		
		dataDto.setdata01("청년 희망적금~");
		dataDto.setdata02("첫주는 5부제 신청 받는다아ㅏㅏ~");
		
		return "forward:Sub04.do";
	}
	
	@GetMapping("/Sub04.do")
	public String sub04(Model model) {
		model.addAttribute("dataDto",dataDto);
		model.addAttribute("memberDto", memberDto);
		return "sub03";
	}
	
	
}
