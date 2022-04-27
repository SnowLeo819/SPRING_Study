package com.TISpjh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.TISpjh.model.BoardDto;
import com.TISpjh.model.DataDto;
import com.TISpjh.model.MemberDto;

@Controller
public class TestController {
	
	@PostMapping("/Test01.do")
//	public String test01(@ModelAttribute DataDto dataDto) {
	public String test01(DataDto dataDto) {
		System.out.println("data01=="+dataDto.getData01());
		System.out.println("data01=="+dataDto.getData02());
		
		return "test01";
	}
	
	@PostMapping("/MemberTest.do")
	public String memberTest(MemberDto memberDto) {
		System.out.println("no=="+memberDto.getNo());
		System.out.println("id=="+memberDto.getId());
		System.out.println("name=="+memberDto.getName());
		System.out.println("pw=="+memberDto.getPassword());
		
		return "member";
	}	
	
	@PostMapping("/MemberTest02.do")   // 별명지정할 때는 @ModelAttribute 생략 불가
	public String test01(@ModelAttribute("testDto") MemberDto memberDto) {
		System.out.println("no=="+memberDto.getNo());
		System.out.println("id=="+memberDto.getId());
		System.out.println("name=="+memberDto.getName());
		System.out.println("pw=="+memberDto.getPassword());
		
		return "member02";
	}
	
	@PostMapping("/BoardTest.do")   // 별명지정할 때는 @ModelAttribute 생략 불가
	public String board01(BoardDto boardDto) {
		System.out.println("no=="+boardDto.getNo());
		System.out.println("subject=="+boardDto.getSubject());
		System.out.println("regDate=="+boardDto.getRegDate());
		System.out.println("pw=="+boardDto.getPassword());
		
		return "board";
	}
}
