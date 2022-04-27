package com.TISpjh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

	@GetMapping("/List.do")
	public String list() {
		System.out.println("회원리스트");
		return "member/list";
	}
	
	@GetMapping("/Join.do")
	public String join() {
		System.out.println("회원가입");
		return "member/join";
	}	
	
	@GetMapping("/Login.do")
	public String login() {
		System.out.println("로그인");
		return "member/login";
	}
	
	@GetMapping("/Logout.do")
	public String logout() {
		System.out.println("로그아웃");
		return "../";
	}
	
	@GetMapping("/Info.do")
	public String info() {
		System.out.println("회원정보");
		return "member/info";
	}
	
	@GetMapping("/Delete.do")
	public String delete() {
		System.out.println("회원탈퇴");
		return "member/delete";
	}
	
	@GetMapping("/Update.do")
	public String update() {
		System.out.println("정보수정");
		return "member/update";
	}
}
