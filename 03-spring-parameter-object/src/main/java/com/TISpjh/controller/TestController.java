package com.TISpjh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TISpjh.model.BoardDto;
import com.TISpjh.model.DataDto;
import com.TISpjh.model.MemberDto;

@Controller
public class TestController {

	@GetMapping("/ParameterObject01.do")
	public String parameterObject01(@RequestParam Map<String, String> map, @RequestParam List<String> data03){
		String data01 = map.get("data01");
		String data02 = map.get("data02");
		String mapData03 = map.get("Data03");
		System.out.println("data01==="+data01);
		System.out.println("data02==="+data02);
		System.out.println("data03==="+data03);
		System.out.println("mapData03==="+mapData03);
		
		return null;
	}

	@GetMapping("/ParameterObject02.do")  
//	public String ParameterObject02 (@ModelAttribute DataDto dataDto) {
	public String ParameterObject02 (DataDto dataDto) {
		
		int data01 = dataDto.getData01();
		int data02 = dataDto.getData02();
		System.out.println("data01==="+data01);
		System.out.println("data02==="+data02);
		for(int num:dataDto.getData03()) {
			System.out.println("num==="+num);
		}
		
		return null;
	}
	
	@GetMapping("/ParameterObject03.do")  
	public String ParameterObject03 (@ModelAttribute MemberDto memberDto) {
		
		int no = memberDto.getNo();
		String id = memberDto.getId();
		String name = memberDto.getName();
		String password = memberDto.getPassword();
		
		System.out.println("no==="+no);
		System.out.println("id==="+id);	
		System.out.println("name==="+name);	
		System.out.println("password==="+password);	
		System.out.println("no+10==="+(no+10));
		
		return null;
	}
	
	@PostMapping("/ParameterObject04.do")  
	public String ParameterObject04 (@ModelAttribute BoardDto boardDto) {
		
		int no = boardDto.getNo();
		String subject = boardDto.getSubject();
		String password = boardDto.getPassword();
		boardDto.setHit(boardDto.getHit()+1);
		int hit = boardDto.getHit();
		
		System.out.println("no==="+no);
		System.out.println("subject==="+subject);	
		System.out.println("password==="+password);	
		System.out.println("hit==="+hit);
		
		return null;
	}
}
