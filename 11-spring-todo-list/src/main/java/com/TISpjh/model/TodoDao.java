package com.TISpjh.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoDao {
	
	@Autowired
	public SqlSessionFactory sqlSessionFactory;
	
	public int insertTodo(TodoDto todoDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("insertTodo", todoDto);
		System.out.println(result+"건 입력");
		sqlSession.commit();
		
		sqlSession.close();
		return result;
	}
	
	public List<TodoDto> getAllList(String pickedDate){
		List<TodoDto> todoList = null;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		todoList = sqlSession.selectList("getAllList", pickedDate);

		System.out.println("todoList크기=="+todoList.size());
		
		sqlSession.close();
		return todoList;
	}
	
	public int deleteTodo(int no) {
		int result = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.delete("deleteTodo", no);
		sqlSession.commit();
		
		sqlSession.close();		
		return result;
	}
	
	public int updateTodo(TodoDto todoDto) {
		int result = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.delete("updateTodo", todoDto);
		sqlSession.commit();
		
		sqlSession.close();
		return result;
	}
}
