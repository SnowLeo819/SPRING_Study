package com.TISpjh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TISpjh.model.TodoDao;
import com.TISpjh.model.TodoDto;

@Controller
public class TodoController {

	@Autowired
	TodoDao todoDao;
	
	@Autowired
	TodoDto todoDto;
	
	@RequestMapping("/List.do")
	@ResponseBody
	public Map<String, Object> list(@RequestBody TodoDto todoDto) {
		System.out.println("List 페이지");

		Map<String,Object> hashMap = new HashMap<>();
		String pickedDate = todoDto.getPickedDate();
		List<TodoDto> todoList = todoDao.getAllList(pickedDate);
		hashMap.put("todoList", todoList);
		
		return hashMap;
	}
	
	//json 으로 넘기기
	@RequestMapping("/Insert.do")
	@ResponseBody
	public Map<String, Object> insertTodo(@RequestBody TodoDto todoDto) {
		//@RequestBody 는 String(텍스트) 형식으로 데이터를 넘겨줌
		System.out.println("todoDto=테스트="+todoDto);
		
		Map<String, Object> hashMap = new HashMap<>();
		List<TodoDto> todoList = null;
		
		String pickedDate = todoDto.getPickedDate();
		int result = todoDao.insertTodo(todoDto);
		if(result>0) {
			todoList = todoDao.getAllList(pickedDate);
			hashMap.put("todoList", todoList);
		}
 		return hashMap;
	}
	
	//삭제
	@RequestMapping("/Delete.do")
	@ResponseBody
	public Map<String, Object> deleteTodo(@RequestBody TodoDto todoDto) {
		System.out.println("삭제");
		
		Map<String, Object> hashMap = new HashMap<>();
		int no = todoDto.getNo();
		int result = todoDao.deleteTodo(no);
		hashMap.put("result", result);
		
 		return hashMap;
	}
	
	// 수정
	@RequestMapping("/Update.do")
	@ResponseBody
	public Map<String, Object> updateTodo(@RequestBody TodoDto todoDto){
		System.out.println("수정");
		
		Map<String, Object> hashMap = new HashMap<>();
		int result = todoDao.updateTodo(todoDto);
		hashMap.put("result", result);
		
 		return hashMap;
	}
}
