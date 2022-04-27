package com.TISpjh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	@GetMapping("/Parameter01.do") // 데이터 받은 후 변환
	public String parameter01(HttpServletRequest request) {
		String data01 = request.getParameter("data01");
		String data02 = request.getParameter("data02");
		String data03 = request.getParameter("data03");
		String data03v[] = request.getParameterValues("data03");

		System.out.println("data01==" + data01);
		System.out.println("data02==" + data02);
		System.out.println("data03==" + data03);
		System.out.println("data01 + 02==" + (data01 + data02)); // 텍스트로 처리되기 때문에 연산 X

		for (String str : data03v) {
			System.out.println("data03v==" + str);
		}

		return "parameter01"; // null 을 리턴하면 404 오류 표시
	}

	@GetMapping("/Parameter02.do") // 데이터 받을 때 변환
	public String parameter02(@RequestParam(value = "data01") int data01, @RequestParam(value = "data02") int data02,
			@RequestParam(value = "data03") int data03, @RequestParam(value = "data03") int[] data03v) {

		System.out.println("data01==" + data01);
		System.out.println("data02==" + data02);
		System.out.println("data03==" + data03);
		System.out.println("data01 + 02==" + (data01 + data02)); // 텍스트로 처리되기 때문에 연산 X

		for (int temp : data03v) {
			System.out.println("data03v==" + temp);
		}

		return null;
	}

	@GetMapping("/Parameter03.do") // 데이터 받을 때 변환
	public String parameter03(int data01, int data02, int data03, @RequestParam(value = "data03") int[] data03v) {

		System.out.println("data01==" + data01);
		System.out.println("data02==" + data02);
		System.out.println("data03==" + data03);
		System.out.println("data01 + 02==" + (data01 + data02)); // 텍스트로 처리되기 때문에 연산 X

		for (int temp : data03v) {
			System.out.println("data03v==" + temp);
		}

		return null;
	}

	@GetMapping("/parameter04.do") // 데이터 받을 때 변환
	public String parameter04(@RequestParam(value = "data01") int tdata01, 
							  @RequestParam(value = "data02") int tdata02, 
							  @RequestParam(value = "data03") int[] tdata03) {
		
		System.out.println("data01==" + tdata01);
		System.out.println("data02==" + tdata02);
		
		for (int temp : tdata03) {
			System.out.println("data03==" + temp);
		}

		return null;
	}
	
	// 동일한 이름으로 받기
//	@GetMapping("/parameter04.do")
//	public String parameter04(int data01, int data02, int[] data03) {
//		
//		System.out.println("data01==" + data01);
//		System.out.println("data02==" + data02);
//		
//		for (int temp : data03) {
//			System.out.println("data03==" + temp);
//		}
//
//		return null;
//	}
	
 	//동일한 이름으로 받기
	// null..  숫자.. javascript로 걸러서 보내주는것이 좋다
	@GetMapping("/parameter05.do")
	public String parameter05(@RequestParam int data01, 
							  @RequestParam(required = false) String data02,   // 데이터가 넘어오지 않아도 괜찮음
							  @RequestParam(defaultValue = "0") int[] data03) {
		
		System.out.println("data01==" + data01);
		System.out.println("data02==" + data02);
		
		for (int temp : data03) {
			System.out.println("data03==" + temp);
		}

		return null;
	}
	
	
	// 서버 api-server (서버가 프론트를 관여하지 않고 데이터만 던져주기)
	@GetMapping("/parameter/{data01}/{data02}/{data03}")
	public String parameter06(@PathVariable int data01,
							  @PathVariable int data02,
							  @PathVariable int data03) {
		
		System.out.println("data01==" + data01);
		System.out.println("data02==" + data02);
		System.out.println("data03==" + data03);
		
		return null;
	}
}
